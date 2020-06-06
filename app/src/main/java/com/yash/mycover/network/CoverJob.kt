package com.yash.mycover.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoverJob(
    @Json(name = "CoverJobDetail")
    val coverJobDetail: List<CoverJobDetail?>?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "success")
    val success: String?
) {
    @JsonClass(generateAdapter = true)
    data class CoverJobDetail(
        @Json(name = "CompanyId")
        val companyId: String?,
        @Json(name = "Consignment")
        val consignment: String?,
        @Json(name = "CreatedAt")
        val createdAt: String?,
        @Json(name = "DeliveryInstruction")
        val deliveryInstruction: String?,
        @Json(name = "Distance")
        val distance: String?,
        @Json(name = "DistanceStatus")
        val distanceStatus: String?,
        @Json(name = "DriverId")
        val driverId: Any?,
        @Json(name = "DropoffDetail")
        val dropoffDetail: DropoffDetail?,
        @Json(name = "DropoffDistance")
        val dropoffDistance: Any?,
        @Json(name = "Duration")
        val duration: String?,
        @Json(name = "Enable")
        val enable: String?,
        @Json(name = "Id")
        val id: String?,
        @Json(name = "JobId")
        val jobId: String?,
        @Json(name = "JobStatus")
        val jobStatus: String?,
        @Json(name = "Notes")
        val notes: Any?,
        @Json(name = "PackageDetail")
        val packageDetail: String?,
        @Json(name = "PickupDetail")
        val pickupDetail: PickupDetail?,
        @Json(name = "PickupDistance")
        val pickupDistance: Any?,
        @Json(name = "RejectDriverId")
        val rejectDriverId: Any?,
        @Json(name = "ScheduleJobTime")
        val scheduleJobTime: Any?,
        @Json(name = "TimeZone")
        val timeZone: String?,
        @Json(name = "UpdatedAt")
        val updatedAt: Any?,
        @Json(name = "UserId")
        val userId: String?
    ) {
        @JsonClass(generateAdapter = true)
        data class DropoffDetail(
            @Json(name = "address")
            val address: String?,
            @Json(name = "distance")
            val distance: Any?,
            @Json(name = "dropcity")
            val dropcity: String?,
            @Json(name = "dropcountry")
            val dropcountry: String?,
            @Json(name = "droplat")
            val droplat: String?,
            @Json(name = "droplocality")
            val droplocality: String?,
            @Json(name = "droplong")
            val droplong: String?,
            @Json(name = "DropoffEmail")
            val dropoffEmail: String?,
            @Json(name = "droppostalcode")
            val droppostalcode: String?,
            @Json(name = "dropstate")
            val dropstate: String?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "phone")
            val phone: String?
        )

        @JsonClass(generateAdapter = true)
        data class PickupDetail(
            @Json(name = "address")
            val address: String?,
            @Json(name = "distance")
            val distance: Any?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "phone")
            val phone: String?,
            @Json(name = "pickSuburb")
            val pickSuburb: String?,
            @Json(name = "pickcountry")
            val pickcountry: String?,
            @Json(name = "picklat")
            val picklat: String?,
            @Json(name = "picklocality")
            val picklocality: String?,
            @Json(name = "picklong")
            val picklong: String?,
            @Json(name = "pickpostalcode")
            val pickpostalcode: String?,
            @Json(name = "pickstate")
            val pickstate: String?,
            @Json(name = "pickupemail")
            val pickupemail: String?
        )
    }
}