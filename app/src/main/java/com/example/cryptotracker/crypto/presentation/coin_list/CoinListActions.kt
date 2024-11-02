package com.example.cryptotracker.crypto.presentation.coin_list

import com.example.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListActions {
    data class OnCoinClick(val coinUi: CoinUi) : CoinListActions
    data object OnRefresh: CoinListActions
}