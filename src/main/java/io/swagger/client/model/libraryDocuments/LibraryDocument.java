/************************************************************************
*
* ADOBE CONFIDENTIAL
* ___________________
*
* Copyright 2023 Adobe
* All Rights Reserved.
*
* NOTICE: All information contained herein is, and remains
* the property of Adobe and its suppliers, if any. The intellectual
* and technical concepts contained herein are proprietary to Adobe
* and its suppliers and are protected by all applicable intellectual
* property laws, including trade secret and copyright laws.
* Dissemination of this information or reproduction of this material
* is strictly forbidden unless prior written permission is obtained
* from Adobe.

*************************************************************************
*/

package io.swagger.client.model.libraryDocuments;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * LibraryDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-11T15:49:09.941+05:30")
public class LibraryDocument {
  @SerializedName("creatorEmail")
  private String creatorEmail = null;

  @SerializedName("ownerEmail")
  private String ownerEmail = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("groupId")
  private String groupId = null;

  @SerializedName("hidden")
  private Boolean hidden = null;

  @SerializedName("modifiedDate")
  private Date modifiedDate = null;

  @SerializedName("name")
  private String name = null;

  /**
   * Specifies who should have access to this library document. GLOBAL sharing mode is not applicable in POST/PUT requests
   */
  @JsonAdapter(SharingModeEnum.Adapter.class)
  public enum SharingModeEnum {
    USER("USER"),
    
    GROUP("GROUP"),
    
    ACCOUNT("ACCOUNT"),
    
    GLOBAL("GLOBAL");

    private String value;

    SharingModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SharingModeEnum fromValue(String text) {
      for (SharingModeEnum b : SharingModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SharingModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SharingModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SharingModeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SharingModeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("sharingMode")
  private SharingModeEnum sharingMode = null;

  /**
   * Status of the library document
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    AUTHORING("AUTHORING"),
    
    ACTIVE("ACTIVE"),
    
    REMOVED("REMOVED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  /**
   * Gets or Sets templateTypes
   */
  @JsonAdapter(TemplateTypesEnum.Adapter.class)
  public enum TemplateTypesEnum {
    DOCUMENT("DOCUMENT"),
    
    FORM_FIELD_LAYER("FORM_FIELD_LAYER");

    private String value;

    TemplateTypesEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TemplateTypesEnum fromValue(String text) {
      for (TemplateTypesEnum b : TemplateTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TemplateTypesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TemplateTypesEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TemplateTypesEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TemplateTypesEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("templateTypes")
  private List<TemplateTypesEnum> templateTypes = null;

  public LibraryDocument creatorEmail(String creatorEmail) {
    this.creatorEmail = creatorEmail;
    return this;
  }

   /**
   * Email address of the library document creator. It will be ignored in POST/PUT requests
   * @return creatorEmail
  **/
  @ApiModelProperty(value = "Email address of the library document creator. It will be ignored in POST/PUT requests")
  public String getCreatorEmail() {
    return creatorEmail;
  }

  public void setCreatorEmail(String creatorEmail) {
    this.creatorEmail = creatorEmail;
  }

  public LibraryDocument ownerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

  @ApiModelProperty(value = "Email address of the library document owner.")
  public String getOwnerEmail() { return ownerEmail; }

  public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

  public LibraryDocument id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier that is used to refer to the library template
   * @return id
  **/
  @ApiModelProperty(value = "The unique identifier that is used to refer to the library template")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LibraryDocument groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The unique group identifier that is used to refer to the group
   * @return groupId
   **/
  @ApiModelProperty(value = "The unique group identifier that is used to refer to the group")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public LibraryDocument hidden(Boolean hidden) {
    this.hidden = hidden;
    return this;
  }

   /**
   * True if Library Document is hidden
   * @return hidden
  **/
  @ApiModelProperty(value = "True if Library Document is hidden")
  public Boolean isHidden() {
    return hidden;
  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public LibraryDocument modifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
    return this;
  }

   /**
   * The date on which the library document was last modified. Format would be yyyy-MM-dd&#39;T&#39;HH:mm:ssZ. For example, e.g 2016-02-25T18:46:19Z represents UTC time
   * @return modifiedDate
  **/
  @ApiModelProperty(value = "The date on which the library document was last modified. Format would be yyyy-MM-dd'T'HH:mm:ssZ. For example, e.g 2016-02-25T18:46:19Z represents UTC time")
  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public LibraryDocument name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the library document
   * @return name
  **/
  @ApiModelProperty(value = "The name of the library document")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LibraryDocument sharingMode(SharingModeEnum sharingMode) {
    this.sharingMode = sharingMode;
    return this;
  }

   /**
   * Specifies who should have access to this library document. GLOBAL sharing mode is not applicable in POST/PUT requests
   * @return sharingMode
  **/
  @ApiModelProperty(value = "Specifies who should have access to this library document. GLOBAL sharing mode is not applicable in POST/PUT requests")
  public SharingModeEnum getSharingMode() {
    return sharingMode;
  }

  public void setSharingMode(SharingModeEnum sharingMode) {
    this.sharingMode = sharingMode;
  }

  public LibraryDocument status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the library document
   * @return status
  **/
  @ApiModelProperty(value = "Status of the library document")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public LibraryDocument templateTypes(List<TemplateTypesEnum> templateTypes) {
    this.templateTypes = templateTypes;
    return this;
  }

  public LibraryDocument addTemplateTypesItem(TemplateTypesEnum templateTypesItem) {
    if (this.templateTypes == null) {
      this.templateTypes = new ArrayList<TemplateTypesEnum>();
    }
    this.templateTypes.add(templateTypesItem);
    return this;
  }

   /**
   * A list of one or more library template types
   * @return templateTypes
  **/
  @ApiModelProperty(value = "A list of one or more library template types")
  public List<TemplateTypesEnum> getTemplateTypes() {
    return templateTypes;
  }

  public void setTemplateTypes(List<TemplateTypesEnum> templateTypes) {
    this.templateTypes = templateTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryDocument libraryDocument = (LibraryDocument) o;
    return Objects.equals(this.creatorEmail, libraryDocument.creatorEmail) &&
        Objects.equals(this.id, libraryDocument.id) &&
        Objects.equals(this.hidden, libraryDocument.hidden) &&
        Objects.equals(this.modifiedDate, libraryDocument.modifiedDate) &&
        Objects.equals(this.name, libraryDocument.name) &&
        Objects.equals(this.sharingMode, libraryDocument.sharingMode) &&
        Objects.equals(this.status, libraryDocument.status) &&
        Objects.equals(this.templateTypes, libraryDocument.templateTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creatorEmail, id, hidden, modifiedDate, name, sharingMode, status, templateTypes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LibraryDocument {\n");
    
    sb.append("    creatorEmail: ").append(toIndentedString(creatorEmail)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
    sb.append("    modifiedDate: ").append(toIndentedString(modifiedDate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sharingMode: ").append(toIndentedString(sharingMode)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    templateTypes: ").append(toIndentedString(templateTypes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

