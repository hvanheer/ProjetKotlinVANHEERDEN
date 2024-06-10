package fr.epf.min2.projetkotlinvanheerden.models

import java.io.Serializable

data class CountryDetails(

    val capital: String,
    val region: String,
    val subregion: String,
    val languages: Map<String, String>,
    val englishTranslation: String,
    val flagPng: String,
    val commonName: String,
    val officialName: String,
    val independent: Boolean,
    val currencyName: String,
    val currencySymbol: String,
    val borders: List<String>,
    val population: Int,
    val timezone: String,
    val googleMapsLink: String
) : Serializable
