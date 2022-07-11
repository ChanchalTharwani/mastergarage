package com.vendor.mastergarage.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OngoingResponseModel(

	@field:SerializedName("result")
	val result: ArrayList<ResultItem> = ArrayList(	),

	@field:SerializedName("success")
	val success: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class ResultItem(

	@field:SerializedName("phone_no")
	val phoneNo: String? = null,

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("booking_date")
	val bookingDate: String? = null,

	@field:SerializedName("pin_code")
	val pinCode: Int? = null,

	@field:SerializedName("appointment_date")
	val appointmentDate: String? = null,

	@field:SerializedName("insurance_number")
	val insuranceNumber: String? = null,

	@field:SerializedName("variants")
	val variants: String? = null,

	@field:SerializedName("ownerId")
	val ownerId: Int? = null,

	@field:SerializedName("addressId")
	val addressId: Int? = null,

	@field:SerializedName("imageUri")
	val imageUri: String? = null,

	@field:SerializedName("engine_no")
	val engineNo: String? = null,

	@field:SerializedName("insuranceId")
	val insuranceId: Int? = null,

	@field:SerializedName("company")
	val company: String? = null,

	@field:SerializedName("vehicleId")
	val vehicleId: Int? = null,

	@field:SerializedName("city_owner")
	val cityOwner: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("leadId")
	val leadId: Int? = null,

	@field:SerializedName("appointment_time")
	val appointmentTime: String? = null,

	@field:SerializedName("owner_name")
	val ownerName: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("outletId")
	val outletId: Int? = null,

	@field:SerializedName("booking_time")
	val bookingTime: String? = null,

	@field:SerializedName("manufacturer_name")
	val manufacturerName: String? = null,

	@field:SerializedName("year_of_purchase")
	val yearOfPurchase: String? = null,

	@field:SerializedName("registration_no")
	val registrationNo: String? = null,

	@field:SerializedName("insurance_type")
	val insuranceType: String? = null,

	@field:SerializedName("fuelType")
	val fuelType: String? = null,

	@field:SerializedName("backup_timer")
	val backupTimer: Int? = null,

	@field:SerializedName("v_imageUri")
	val vImageUri: String? = null,

	@field:SerializedName("classic_no")
	val classicNo: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable
