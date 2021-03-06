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
package com.tomtom.online.sdk.samples.cases.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomtom.online.sdk.samples.R;
import com.tomtom.online.sdk.samples.utils.views.RadioModifierView;

public class CategoriesSearchFragment extends SearchFragment {

    public CategoriesSearchFragment() {
        searchPresenter = new CategoriesSearchFragmentPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        searchTextView.setVisibility(View.GONE);

        return view;
    }

    @Override
    protected void initSearchModifiersView(View view) {
        searchModifiersView = view.findViewById(R.id.search_modifier_tabs);
        searchModifiersView.setRadioNames(getString(R.string.parking), getString(R.string.atm), getString(R.string.gas));
        searchModifiersView.setSearchModifiersLViewListener(this);
        searchModifiersView.setFirstMiddleRadioVisible(true);
        searchModifiersView.setSecondMiddleRadioVisible(false);
        searchModifiersView.setEnabled(true);
    }

    @Override
    public void onLeftButtonClicked() {
        disableToggleButtons();
        searchPresenter.performSearch("parking");
    }

    @Override
    public void onRightButtonClicked() {
        disableToggleButtons();
        searchPresenter.performSearch("atm");
    }

    @Override
    public void onFirstMiddleButtonClicked() {
        disableToggleButtons();
        searchPresenter.performSearch("gas");
    }

    @Override
    public void onResume() {
        super.onResume();
        searchPresenter.enableSearchUI();
        //Override default values
        setActionBarSubtitle(R.string.category_search_description);
        setActionBarTitle(R.string.category_search);
    }
}
