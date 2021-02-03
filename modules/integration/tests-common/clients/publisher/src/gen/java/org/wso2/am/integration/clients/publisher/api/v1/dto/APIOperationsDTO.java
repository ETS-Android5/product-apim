/*
 * WSO2 API Manager - Publisher API
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Publisher**.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the the API you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_publisher\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown bellow to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_publisher\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api123\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for publisher REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_passowrd&scope=<scopes seperated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:api_view apim:api_create\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:api_create apim:api_view\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a09044034b5c3c1b01a9) 
 *
 * The version of the OpenAPI document: v2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.publisher.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* APIOperationsDTO
*/

public class APIOperationsDTO {
        public static final String SERIALIZED_NAME_ID = "id";
        @SerializedName(SERIALIZED_NAME_ID)
            private String id;

        public static final String SERIALIZED_NAME_TARGET = "target";
        @SerializedName(SERIALIZED_NAME_TARGET)
            private String target;

        public static final String SERIALIZED_NAME_VERB = "verb";
        @SerializedName(SERIALIZED_NAME_VERB)
            private String verb;

        public static final String SERIALIZED_NAME_AUTH_TYPE = "authType";
        @SerializedName(SERIALIZED_NAME_AUTH_TYPE)
            private String authType = "Any";

        public static final String SERIALIZED_NAME_THROTTLING_POLICY = "throttlingPolicy";
        @SerializedName(SERIALIZED_NAME_THROTTLING_POLICY)
            private String throttlingPolicy;

        public static final String SERIALIZED_NAME_SCOPES = "scopes";
        @SerializedName(SERIALIZED_NAME_SCOPES)
            private List<String> scopes = null;

        public static final String SERIALIZED_NAME_USED_PRODUCT_IDS = "usedProductIds";
        @SerializedName(SERIALIZED_NAME_USED_PRODUCT_IDS)
            private List<String> usedProductIds = null;

        public static final String SERIALIZED_NAME_AMZN_RESOURCE_NAME = "amznResourceName";
        @SerializedName(SERIALIZED_NAME_AMZN_RESOURCE_NAME)
            private String amznResourceName;

        public static final String SERIALIZED_NAME_AMZN_RESOURCE_TIMEOUT = "amznResourceTimeout";
        @SerializedName(SERIALIZED_NAME_AMZN_RESOURCE_TIMEOUT)
            private Integer amznResourceTimeout;


        public APIOperationsDTO id(String id) {
        
        this.id = id;
        return this;
        }

    /**
        * Get id
    * @return id
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "postapiresource", value = "")
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


        public APIOperationsDTO target(String target) {
        
        this.target = target;
        return this;
        }

    /**
        * Get target
    * @return target
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "/order/{orderId}", value = "")
    
    public String getTarget() {
        return target;
    }


    public void setTarget(String target) {
        this.target = target;
    }


        public APIOperationsDTO verb(String verb) {
        
        this.verb = verb;
        return this;
        }

    /**
        * Get verb
    * @return verb
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "POST", value = "")
    
    public String getVerb() {
        return verb;
    }


    public void setVerb(String verb) {
        this.verb = verb;
    }


        public APIOperationsDTO authType(String authType) {
        
        this.authType = authType;
        return this;
        }

    /**
        * Get authType
    * @return authType
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Application & Application User", value = "")
    
    public String getAuthType() {
        return authType;
    }


    public void setAuthType(String authType) {
        this.authType = authType;
    }


        public APIOperationsDTO throttlingPolicy(String throttlingPolicy) {
        
        this.throttlingPolicy = throttlingPolicy;
        return this;
        }

    /**
        * Get throttlingPolicy
    * @return throttlingPolicy
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Unlimited", value = "")
    
    public String getThrottlingPolicy() {
        return throttlingPolicy;
    }


    public void setThrottlingPolicy(String throttlingPolicy) {
        this.throttlingPolicy = throttlingPolicy;
    }


        public APIOperationsDTO scopes(List<String> scopes) {
        
        this.scopes = scopes;
        return this;
        }

    /**
        * Get scopes
    * @return scopes
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[]", value = "")
    
    public List<String> getScopes() {
        return scopes;
    }


    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }


        public APIOperationsDTO usedProductIds(List<String> usedProductIds) {
        
        this.usedProductIds = usedProductIds;
        return this;
        }

    /**
        * Get usedProductIds
    * @return usedProductIds
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[]", value = "")
    
    public List<String> getUsedProductIds() {
        return usedProductIds;
    }


    public void setUsedProductIds(List<String> usedProductIds) {
        this.usedProductIds = usedProductIds;
    }


        public APIOperationsDTO amznResourceName(String amznResourceName) {
        
        this.amznResourceName = amznResourceName;
        return this;
        }

    /**
        * Get amznResourceName
    * @return amznResourceName
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public String getAmznResourceName() {
        return amznResourceName;
    }


    public void setAmznResourceName(String amznResourceName) {
        this.amznResourceName = amznResourceName;
    }


        public APIOperationsDTO amznResourceTimeout(Integer amznResourceTimeout) {
        
        this.amznResourceTimeout = amznResourceTimeout;
        return this;
        }

    /**
        * Get amznResourceTimeout
    * @return amznResourceTimeout
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public Integer getAmznResourceTimeout() {
        return amznResourceTimeout;
    }


    public void setAmznResourceTimeout(Integer amznResourceTimeout) {
        this.amznResourceTimeout = amznResourceTimeout;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            APIOperationsDTO apIOperations = (APIOperationsDTO) o;
            return Objects.equals(this.id, apIOperations.id) &&
            Objects.equals(this.target, apIOperations.target) &&
            Objects.equals(this.verb, apIOperations.verb) &&
            Objects.equals(this.authType, apIOperations.authType) &&
            Objects.equals(this.throttlingPolicy, apIOperations.throttlingPolicy) &&
            Objects.equals(this.scopes, apIOperations.scopes) &&
            Objects.equals(this.usedProductIds, apIOperations.usedProductIds) &&
            Objects.equals(this.amznResourceName, apIOperations.amznResourceName) &&
            Objects.equals(this.amznResourceTimeout, apIOperations.amznResourceTimeout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, target, verb, authType, throttlingPolicy, scopes, usedProductIds, amznResourceName, amznResourceTimeout);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class APIOperationsDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    verb: ").append(toIndentedString(verb)).append("\n");
    sb.append("    authType: ").append(toIndentedString(authType)).append("\n");
    sb.append("    throttlingPolicy: ").append(toIndentedString(throttlingPolicy)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    usedProductIds: ").append(toIndentedString(usedProductIds)).append("\n");
    sb.append("    amznResourceName: ").append(toIndentedString(amznResourceName)).append("\n");
    sb.append("    amznResourceTimeout: ").append(toIndentedString(amznResourceTimeout)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

