package com.kemprze.a30daysofpolishnature.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Animal(@StringRes val name: Int,
                  @StringRes val latinName: Int,
                  @StringRes val description: Int,
                  @StringRes val distribution: Int,
                  @StringRes val status: Int,
                  @DrawableRes val photograph: Int)
