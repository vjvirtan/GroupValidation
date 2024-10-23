package com.validation.services;

import java.util.*;
import org.springframework.stereotype.*;
import com.validation.dto.*;
import com.validation.enums.*;
import com.validation.rules.*;

import jakarta.annotation.*;
import lombok.*;

@RequiredArgsConstructor
@Service

public class DefaultRules {
        private final FieldDictionaryService fieldDictionaryInterface;

        @PostConstruct
        public void doFieldRules() {
                System.out.println(" SHOULD START ON STARTUP ");
                String key = "personId";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Personal")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Henkilötunnus"),
                                                translation("EN", "ID"),
                                                translation("SE", "Personnummer")))
                                .validationRule(ValidationRules.personalId())
                                .build());
                key = "id";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("System")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "id"),
                                                translation("EN", "id"),
                                                translation("SE", "id")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME_NUMBERS_HYPHEN.getValue())
                                                .mandatory(false)
                                                .min(10)
                                                .max(100)
                                                .build())
                                .build());

                key = "firstname";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Personal")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Etunimi"),
                                                translation("EN", "Firstname"),
                                                translation("SE", "Förnamn")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME.getValue())
                                                .mandatory(true)
                                                .min(2)
                                                .max(30)
                                                .build())
                                .build());

                key = "lastname";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Personal")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Sukunimi"),
                                                translation("EN", "Lastname"),
                                                translation("SE", "Efternamn")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME.getValue())
                                                .mandatory(true)
                                                .min(2)
                                                .max(30)
                                                .build())
                                .build());

                key = "personId";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Personal")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Henkilötunnus"),
                                                translation("EN", "Id"),
                                                translation("SE", "Personnummer")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME_NUMBERS_HYPHEN.getValue())
                                                .mandatory(true)
                                                .subStrings(Arrays.asList(substring(7, "[A-+]")))
                                                .min(11)
                                                .max(11)
                                                .build())
                                .build());

                key = "nationality";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General"), category("Personal")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Kansalaisuus"),
                                                translation("EN", "Nationality"),
                                                translation("SE", "Medborgarskap")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME.getValue())
                                                .mandatory(true)
                                                .min(2)
                                                .max(30)
                                                .build())
                                .build());

                key = "companyName";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Business")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Toiminimi"),
                                                translation("EN", "Company name"),
                                                translation("SE", "Företagets namn")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME.getValue())
                                                .mandatory(true)
                                                .min(2)
                                                .max(30)
                                                .build())
                                .build());

                key = "businessId";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Business")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Y-tunnus"),
                                                translation("EN", "Business ID"),
                                                translation("SE", "FO-nummer")))
                                .validationRule(ValidationRules.businessIdRule())
                                .build());

                key = "beneficiaries";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Business")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Tosiasilliset edunsaajat"),
                                                translation("EN", "Beneficiaries"),
                                                translation("SE", "Faktisk förmånstagare")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.NAME.getValue())
                                                .mandatory(true)
                                                .min(2)
                                                .max(30)
                                                .build())
                                .build());

                key = "representation";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Business")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Edustajuus"),
                                                translation("EN", "Representation"),
                                                translation("SE", "Representation")))
                                .validationRule(DefaultValidationRules.nameRule())
                                .build());

                key = "percentage";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Prosenttia"),
                                                translation("EN", "Percent"),
                                                translation("SE", "Procent")))
                                .validationRule(ValidationRuleDto.builder()
                                                .allowedChars(FieldEnum.DECIMAL.getValue())

                                                .mandatory(true)
                                                .min(0.00)
                                                .build())
                                .build());

                key = "owners";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Omistajat"),
                                                translation("EN", "Owners"),
                                                translation("SE", "Ägare")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .build())
                                .build());

                key = "systemId";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "SystemId"),
                                                translation("EN", "SystemId"),
                                                translation("SE", "SystemId")))
                                .validationRule(DefaultValidationRules.nameRule())
                                .build());
                key = "roles";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Roolit"),
                                                translation("EN", "Roles"),
                                                translation("SE", "Roller")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .build())
                                .build());

                key = "tradeRegistryInfo";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Kaupparekisteritiedot"),
                                                translation("EN", "Trade Register information"),
                                                translation("SE", "Handelsregisteruppgifter")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .build())
                                .build());
                key = "boardRoles";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Hallituksen jäsenyydet"),
                                                translation("EN", "Board roles"),
                                                translation("SE", "Medlemskap i styrelsen")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .build())
                                .build());

                key = "boardRole";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Hallituksen jäsenyys"),
                                                translation("EN", "Board role"),
                                                translation("SE", "Styrelsemedlemskap")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .build())
                                .build());

                key = "headOfBoard";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Hallituksen puheenjohtaja"),
                                                translation("EN", "Head of board"),
                                                translation("SE", "Styrelseordförande")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .unique(true)
                                                .build())
                                .build());

                key = "boardMember";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Hallituksen jäsen"),
                                                translation("EN", "Board member"),
                                                translation("SE", "Styrelseledamot")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .unique(false)
                                                .build())
                                .build());
                key = "ceo";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Toimitusjohtaja"),
                                                translation("EN", "Chief executive officer"),
                                                translation("SE", "Verkställande direktör")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .unique(true)
                                                .build())
                                .build());
                key = "deputyBoardMember";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Hallituksen varajäsen"),
                                                translation("EN", "Deputy board member"),
                                                translation("SE", "Suppleant i styrelsen")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .unique(false)
                                                .build())
                                .build());

                key = "postalPlace";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("General")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "Postitoimipaikka"),
                                                translation("EN", "Postal place"),
                                                translation("SE", "Postort")))
                                .validationRule(ValidationRuleDto.builder().allowedChars(FieldEnum.NAME.getValue())
                                                .unique(false)
                                                .build())
                                .build());
                key = "mandatoryField";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "pakollinen tieto"),
                                                translation("EN", "mandatory field"),
                                                translation("SE", "obligatorisk information")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());
                key = "tooShortString";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "liian lyhyt"),
                                                translation("EN", "too short"),
                                                translation("SE", "för kort")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())

                                .build());
                key = "tooLongString";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "liian pitkä"),
                                                translation("EN", "Postal place"),
                                                translation("SE", "Postort")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());
                key = "tooShort";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "liian lyhyt"),
                                                translation("EN", "too short"),
                                                translation("SE", "för kort")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())

                                .build());
                key = "tooLong";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "luku on liian suuri"),
                                                translation("EN", "the number is too large"),
                                                translation("SE", "talet är för stort")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());
                key = "illegalCharacter";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "sallitut merkit"),
                                                translation("EN", "legal characters are"),
                                                translation("SE", "tillåtna tecken")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());

                key = "^[a-zA-ZäöåÄÖÅ0-9-]+$";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "a-Ö, numerot ja - "),
                                                translation("EN", "a-Ö, numbers and - "),
                                                translation("SE", "a-Ö, siffror och -")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());
                key = "[a-zA-ZäöåÄÖÅ]+";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "a-Ö"),
                                                translation("EN", "a-Ö"),
                                                translation("SE", "a-Ö")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());
                key = "^\\d+([.,]\\d+)?$";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI",
                                                                "numerot ja desimaalit pilkulla tai pisteellä"),
                                                translation("EN",
                                                                "numbers and decimals with comma or dot"),
                                                translation("SE",
                                                                "siffror och decimaler med komma eller punkt")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());
                key = "^[0-9]+$";
                fieldDictionaryInterface.create(key, FieldDictionaryDto.builder()
                                .categories(Arrays.asList(category("Valid")))
                                .key(key)
                                .translations(Arrays.asList(
                                                translation("FI", "kokonaisluvut"),
                                                translation("EN", "whole numbers"),
                                                translation("SE", "heltal")))
                                .validationRule(DefaultValidationRules.validationErrorMessage())
                                .build());

        }

        private ValuePair<Integer, String> substring(Integer index, String pattern) {
                return new ValuePair<Integer, String>(index, pattern);
        }

        private ValuePair<String, String> translation(String lang, String translation) {
                return new ValuePair<String, String>(lang, translation);
        }

        private CategoryDto category(String name) {
                return CategoryDto.builder().name(name).build();
        }
}
