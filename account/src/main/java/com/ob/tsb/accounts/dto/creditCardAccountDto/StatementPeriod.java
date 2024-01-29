package com.ob.tsb.accounts.dto.creditCardAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementPeriod {
    @JsonProperty("FromDateTime")
    public String fromDateTime;
    @JsonProperty("ToDateTime")
    public String toDateTime;
    @JsonProperty("RelatedStandingOrder")
    public String relatedStandingOrder;
    @JsonProperty("PaymentInstruction")
    public String paymentInstruction;
    @JsonProperty("NumberOfDays")
    public String numberOfDays;
    @JsonProperty("ValuationStatistics")
    public String valuationStatistics;
    @JsonProperty("PerformanceFactors")
    public String performanceFactors;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("PriceCalculationRelatedPricing")
    public String priceCalculationRelatedPricing;
    @JsonProperty("CorporateActionOption")
    public String corporateActionOption;
    @JsonProperty("ParallelTradingProceedsDefinition")
    public String parallelTradingProceedsDefinition;
    @JsonProperty("PrivilegeSuspensionCorporateAction")
    public String privilegeSuspensionCorporateAction;
    @JsonProperty("WithdrawalSuspensionRelatedEvent")
    public String withdrawalSuspensionRelatedEvent;
    @JsonProperty("RelatedInterestCalculation")
    public String relatedInterestCalculation;
    @JsonProperty("BiddingConditions")
    public String biddingConditions;
    @JsonProperty("ClassAction")
    public String classAction;
    @JsonProperty("BookEntryTransferSuspensionRelatedEvent")
    public String bookEntryTransferSuspensionRelatedEvent;
    @JsonProperty("DepositAtAgentSuspensionRelatedEvent")
    public String depositAtAgentSuspensionRelatedEvent;
    @JsonProperty("DepositSuspensionRelatedEvent")
    public String depositSuspensionRelatedEvent;
    @JsonProperty("PledgeSuspensionRelatedEvent")
    public String pledgeSuspensionRelatedEvent;
    @JsonProperty("SegregationPeriodRelatedEvent")
    public String segregationPeriodRelatedEvent;
    @JsonProperty("WithdrawalAtAgentSuspensionRelatedEvent")
    public String withdrawalAtAgentSuspensionRelatedEvent;
    @JsonProperty("WithdrawalInNomineeNameSuspensionRelatedEvent")
    public String withdrawalInNomineeNameSuspensionRelatedEvent;
    @JsonProperty("WithdrawalInStreetNameSuspensionRelatedEvent")
    public String withdrawalInStreetNameSuspensionRelatedEvent;
    @JsonProperty("BookClosureCorporateAction")
    public String bookClosureCorporateAction;
    @JsonProperty("CoDepositoriesSuspensionRelatedEvent")
    public String coDepositoriesSuspensionRelatedEvent;
    @JsonProperty("ExtendiblePeriodDebt")
    public String extendiblePeriodDebt;
    @JsonProperty("SecuritiesConversion")
    public String securitiesConversion;
    @JsonProperty("YieldCalculation")
    public String yieldCalculation;
    @JsonProperty("CustomDateDebt")
    public String customDateDebt;
    @JsonProperty("TaxPeriod")
    public String taxPeriod;
    @JsonProperty("Account")
    public String account;
    @JsonProperty("RelatedAgreement")
    public String relatedAgreement;
    @JsonProperty("AssentedLinePeriodProceedsDefinition")
    public String assentedLinePeriodProceedsDefinition;
    @JsonProperty("SellThruIssuerProceedsDefinition")
    public String sellThruIssuerProceedsDefinition;
    @JsonProperty("RelatedProductDelivery")
    public String relatedProductDelivery;
    @JsonProperty("RelatedInvoice")
    public String relatedInvoice;
    @JsonProperty("TradeCertificate")
    public String tradeCertificate;
    @JsonProperty("RelatedPortfolioValuation")
    public String relatedPortfolioValuation;
    @JsonProperty("System")
    public String system;
    @JsonProperty("AccountRestriction")
    public String accountRestriction;
    @JsonProperty("BankOperation")
    public String bankOperation;
    @JsonProperty("RelatedCorporateAction")
    public String relatedCorporateAction;
    @JsonProperty("RelatedLimit")
    public String relatedLimit;
    @JsonProperty("RelatedIdentification")
    public String relatedIdentification;
    @JsonProperty("AssessmentValidityScheme")
    public String assessmentValidityScheme;
    @JsonProperty("ExercisePeriodDistribution")
    public String exercisePeriodDistribution;
    @JsonProperty("OfferPeriodDistribution")
    public String offerPeriodDistribution;
    @JsonProperty("TradingPeriodDistribution")
    public String tradingPeriodDistribution;
    @JsonProperty("BlockingPeriodDistribution")
    public String blockingPeriodDistribution;
    @JsonProperty("Guarantee")
    public String guarantee;
    @JsonProperty("PriceFactRelatedPricing")
    public String priceFactRelatedPricing;
    @JsonProperty("CashDistribution")
    public String cashDistribution;
    @JsonProperty("ComponentSecurity")
    public String componentSecurity;
    @JsonProperty("TradingSession")
    public String tradingSession;
    @JsonProperty("FinancialInstrumentSwap")
    public String financialInstrumentSwap;
    @JsonProperty("RelatedPostalAddress")
    public String relatedPostalAddress;
    @JsonProperty("RedemptionSchedule")
    public String redemptionSchedule;
    @JsonProperty("RelatedAccountLink")
    public String relatedAccountLink;
    @JsonProperty("RelatedAdjustment")
    public String relatedAdjustment;
    @JsonProperty("RelatedSecuritiesIdentification")
    public String relatedSecuritiesIdentification;
    @JsonProperty("RelatedStandingSettlementInstruction")
    public String relatedStandingSettlementInstruction;
    @JsonProperty("RelatedSecuritiesRegistration")
    public String relatedSecuritiesRegistration;
    @JsonProperty("Amount")
    public String amount;
    @JsonProperty("RelatedInvestmentPlan")
    public String relatedInvestmentPlan;
    @JsonProperty("Issuance")
    public String issuance;
    @JsonProperty("RelatedPaymentTerms")
    public String relatedPaymentTerms;
    @JsonProperty("Percentage")
    public String percentage;
    @JsonProperty("RelatedRolePlayer")
    public String relatedRolePlayer;
    @JsonProperty("RelatedSystemAvailability")
    public String relatedSystemAvailability;

}
