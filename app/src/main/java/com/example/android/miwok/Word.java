package com.example.android.miwok;

public class Word {

    //default translation for the word
    private String mDefaultTranslation;

    //miwork translation for the word
    private String mMiworkTranslation;

    //image for the word
    private int mMiworkImage = NO_IMAGE_PROVIDED;

    //check if image exists
    private static final int NO_IMAGE_PROVIDED = -1;

    //audio for word
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miworkTranslation, int miworkImages, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miworkTranslation;
        mMiworkImage = miworkImages;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miworkTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miworkTranslation;
        mAudioResourceId = audioResourceId;
    }

    //get users default translation
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //get users default translation
    public String getMiworkTranslation() {
        return mMiworkTranslation;
    }

    //get users default translation
    public int getImageResourceId() {
        return mMiworkImage;
    }

    //check if image exists
    public boolean hasImage() {
        return mMiworkImage != NO_IMAGE_PROVIDED;
    }

    //get audio file
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
