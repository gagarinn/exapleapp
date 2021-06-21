package net.demo.ip.api.domain.model

data class IpDetails (
    val query: String,
    val status: String,
    val continent: String,
    val continentCode: String,
    val country: String,
    val countryCode: String,
    val region: String,
    val regionName: String,
    val city: String,
    val district: String,
    val zip: String,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val offset: Long,
    val currency: String,
    val isp: String,
    val org: String,

//    @Json(name = "as")
//    val welcome3As: String,

    val asname: String,
    val mobile: Boolean,
    val proxy: Boolean,
    val hosting: Boolean
)