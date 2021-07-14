package uk.co.jamiecruwys.compose.playground.extensions

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@ExperimentalUnitApi
@Composable
fun TextUnit.Companion.fromDimensionInSp(@DimenRes id: Int) = TextUnit(
    value = dimensionResource(id).value,
    type = TextUnitType.Sp
)
