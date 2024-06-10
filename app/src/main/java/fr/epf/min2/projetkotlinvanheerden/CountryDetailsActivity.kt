package fr.epf.min2.projetkotlinvanheerden

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import fr.epf.min2.projetkotlinvanheerden.models.CountryDetails

class CountryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val subregionTextView: TextView = findViewById(R.id.subregionTextView)
        val languagesTextView: TextView = findViewById(R.id.languagesTextView)
        val populationTextView: TextView = findViewById(R.id.populationTextView)
        val timezoneTextView: TextView = findViewById(R.id.timezoneTextView)
        val googleMapsLinkTextView: TextView = findViewById(R.id.googleMapsLinkTextView)
        val flagImageView: ImageView = findViewById(R.id.flagImageView)
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val capitalTextView: TextView = findViewById(R.id.capitalTextView)
        val currencyTextView: TextView = findViewById(R.id.currencyTextView)
        val regionTextView: TextView = findViewById(R.id.regionTextView)

        val countryDetails = intent.getSerializableExtra("COUNTRY_DETAILS") as? CountryDetails

        countryDetails?.let {
            nameTextView.text = "${it.commonName} (${it.officialName})"
            capitalTextView.text = "Capital: ${it.capital}"
            currencyTextView.text = "Currency: ${it.currencyName} (${it.currencySymbol})"
            regionTextView.text = "Region: ${it.region}"
            subregionTextView.text = "Subregion: ${it.subregion}"
            languagesTextView.text = "Languages: ${it.languages.values.joinToString(", ")}"
            populationTextView.text = "Population: ${it.population}"
            timezoneTextView.text = "Timezone: ${it.timezone}"
            googleMapsLinkTextView.text = "Google Maps: ${it.googleMapsLink}"
            Picasso.get().load(it.flagPng).into(flagImageView)
        } ?: run {
            nameTextView.text = "Country details not available"
        }
    }
}
