package com.z4.sonicraft.api.exception;

public class FeatureExistsException extends RuntimeException
{
    public FeatureExistsException(String name)
    {
        super("Feature " + name + " already exists!");
    }
}
