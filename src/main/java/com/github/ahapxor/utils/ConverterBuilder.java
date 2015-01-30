package com.github.ahapxor.utils;

import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ConverterBuilder {
    public <TS> ConverterFactory<TS> destination(final Class<TS> destClass) {
        if(destClass == null) {
            throw new IllegalArgumentException("Destination class can't be null");
        }

        return new ConverterFactory<>(destClass);
    }

    public class ConverterFactory<TD> {
        final Class<TD> destClass;

        private ConverterFactory(Class<TD> destClass) {
            this.destClass = destClass;
        }

        public <TS> EntityConverter<TS, TD> source(TS source) {
            if(source == null) {
                throw new IllegalArgumentException("Source object can't be null");
            }

            if(destClass.isAssignableFrom(DecisionDto.class) && source instanceof Decision) {
                return (EntityConverter<TS, TD>) new DecisionConverter((Decision) source);
            }

            if(destClass.isAssignableFrom(Purchase.class) && source instanceof PurchaseDto) {
                return (EntityConverter<TS, TD>) new PurchaseDtoConverter((PurchaseDto) source);
            }

            throw new NoSuchElementException("Converter for " + source + " is missing");
        }
    }

    public abstract class EntityConverter<TS, TD> {
        final TS source;

        public EntityConverter(TS source) {
            this.source = source;
        }

        public abstract TD convert();
    }

    public class PurchaseDtoConverter extends EntityConverter<PurchaseDto, Purchase> {
        private PurchaseDtoConverter(PurchaseDto source) {
            super(source);
        }

        @Override
        public Purchase convert() {
            return new Purchase(
                    source.getEmail(),
                    source.getFirstName(),
                    source.getLastName(),
                    source.getAmount());
        }
    }

    public class DecisionConverter extends EntityConverter<Decision, DecisionDto> {
        private DecisionConverter(Decision source) {
            super(source);
        }

        @Override
        public DecisionDto convert() {
            return new DecisionDto(source.isAccepted(), source.getReason().name());
        }
    }
}
