/**
 * Copyright (c) 2015-2021 TomTom N.V. All rights reserved.
 *
 * This software is the proprietary copyright of TomTom N.V. and its subsidiaries and may be used
 * for internal evaluation purposes or commercial use strictly subject to separate licensee
 * agreement between you and TomTom. If you are the licensee, you are only permitted to use
 * this Software in accordance with the terms of your license agreement. If you are not the
 * licensee then you are not authorised to use this software in any manner and should
 * immediately return it to TomTom N.V.
 */
package com.tomtom.online.sdk.samples.cases.map.langparam;

import com.tomtom.online.sdk.map.TomtomMap;
import com.tomtom.online.sdk.samples.activities.BaseFunctionalExamplePresenter;
import com.tomtom.online.sdk.samples.activities.FunctionalExampleModel;
import com.tomtom.online.sdk.samples.fragments.FunctionalExampleFragment;
import com.tomtom.online.sdk.samples.utils.Locations;

public class MapLanguageParamPresenter extends BaseFunctionalExamplePresenter {

    final static int DEFAULT_MAP_ZOOM_LEVEL_FOR_EXAMPLE = 3;
    final static String BRITISH_ENGLISH_CODE = "en-GB";
    final static String RUSSIAN_CODE = "ru-RU";
    final static String DUTCH_CODE = "nl-NL";

    @Override
    public void bind(final FunctionalExampleFragment view, final TomtomMap map) {
        super.bind(view, map);
        if (!view.isMapRestored()) {
            centerOn(Locations.LODZ_LOCATION, DEFAULT_MAP_ZOOM_LEVEL_FOR_EXAMPLE);
            english();
        }
    }

    @Override
    public FunctionalExampleModel getModel() {
        return new MapLanguageParamFunctionalExample();
    }

    @Override
    public void cleanup() {
        tomtomMap.setLanguage(BRITISH_ENGLISH_CODE);
    }

    public void english() {
        //tag::doc_map_language[]
        //BRITISH_ENGLISH_CODE = "en-GB"
        tomtomMap.setLanguage(BRITISH_ENGLISH_CODE);
        //end::doc_map_language[]
    }

    public void russian() {
        tomtomMap.setLanguage(RUSSIAN_CODE);
    }

    public void dutch() {
        tomtomMap.setLanguage(DUTCH_CODE);
    }

}
