package com.structurizr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Component extends Element {

    private Container parent;

    private String technology = "";
    private String interfaceType;
    private String implementationType;
    private String sourcePath;

    public Component() {
    }

    @Override
    @JsonIgnore
    public Element getParent() {
        return parent;
    }

    @JsonIgnore
    public Container getContainer() {
        return parent;
    }

    public void setParent(Container parent) {
        this.parent = parent;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getImplementationType() {
        return implementationType;
    }

    public void setImplementationType(String implementationType) {
        this.implementationType = implementationType;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @Override
    public String getName() {
        if (this.name != null) {
            return super.getName();
        } else if (this.interfaceType != null) {
            return interfaceType.substring(interfaceType.lastIndexOf(".") + 1);
        } else if (this.implementationType != null) {
            return implementationType.substring(implementationType.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    @JsonIgnore
    public String getPackage() {
        return interfaceType.substring(0, interfaceType.lastIndexOf("."));
    }

    @Override
    public final ElementType getType() {
        return ElementType.Component;
    }

    @Override
    public String getCanonicalName() {
        return getParent().getCanonicalName() + CANONICAL_NAME_SEPARATOR + formatForCanonicalName(getName());
    }

    @Override
    protected Set<String> getRequiredTags() {
        return new LinkedHashSet<>(Arrays.asList(Tags.ELEMENT, Tags.COMPONENT));
    }

}