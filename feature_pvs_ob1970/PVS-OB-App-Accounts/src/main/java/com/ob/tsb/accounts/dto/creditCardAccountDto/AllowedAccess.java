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
public class AllowedAccess {


        @JsonProperty("AssociatedDocument")
        public AssociatedDocument associatedDocument;
        @JsonProperty("PointOfAccessType")
        public String pointOfAccessType;
        @JsonProperty("AccessCredentialMethod")
        public String accessCredentialMethod;

}
