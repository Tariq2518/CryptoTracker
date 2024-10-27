package com.example.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank:Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumbers,
    val priceUsd: DisplayableNumbers,
    val changePercent24Hr: DisplayableNumbers,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumbers(
    val value: Double,
    val formatted: String
)


fun Coin.toCoinUi(): CoinUi{
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd.toDisplayableNumbers(),
        marketCapUsd = marketCapUsd.toDisplayableNumbers(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumbers(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumbers(): DisplayableNumbers{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        minimumFractionDigits = 2
    }

    return DisplayableNumbers(
        value = this,
        formatted = formatter.format(20)

    )

}