package com.passwordmanager.shared.utils

import com.passwordmanager.shared.BuildConfig

object Constants {

    /**
     * General Constants
     */
    object GeneralConstants {
        const val TOKEN_URL = "integration/customer/token"
        const val BEARER = "Bearer"
        const val AUTHORIZATION = "Authorization"
        const val CURRENCY = "INR"
        const val TITLE_PAYMENT_NAME = "name"
        const val TITLE_PAYMENT_DESCRIPTION = "description"
        const val TITLE_PAYMENT_IMAGE = "image"
        const val TITLE_PAYMENT_CURRENCY = "INR"
        const val TITLE_PAYMENT_ORDER_ID = "order_id"
        const val TITLE_PAYMENT_AMOUNT = "amount"
        const val TITLE_PAYMENT_EMAIL = "email"
        const val TITLE_PAYMENT_CONTACT = "contact"
        const val TITLE_PAYMENT_FILL_INFORMATION = "fillInformation"
        const val EMPTY_STRING = ""
        const val COLUMN_FEATURED_PRO = "featuredpro"
        const val COLUMN_CATEGORY_ID = "category_id"
        const val RESET_PASSWORD_TEMPLATE = "email_reset"
        const val RESET_PASSWORD_WEBSITE_ID = 1
        const val DISCOUNT_CODE = "discount"
        const val REWARD_SPENT_CODE = "mp_reward_spent"
        const val REWARD_EARN_CODE = "mp_reward_earn"
        const val REDEEM_REWARD_RULE_ID = "rate"
        const val SPECIAL_PRICE_CODE = "special_price"
        const val DELIVERY_STATUS_VALUE = "1"
    }

    object Keys {
        const val CUSTOMER_ID = "customer_id"
        const val SUPPORT_NUMBER = "support_number"
        const val CART_ID = "cart_id"
        const val ORDER_ID = "order_id"
        const val RAZOR_ORDER_ID = "razor_order_id"
        const val PAYMENT_ID = "payment_id"
        const val PAYMENT_SIGNATURE = "payment_signature"
        const val LANGUAGE = "language"
        const val IS_USER_DATA_UPDATED = "user_data_updated"
        const val IS_DEFAULT_VEHICLE_DATA_UPDATED = "vehicle_data_updated"
        const val WHATS_APP = "com.whatsapp"
        const val WHATS_APP_URL = "https://api.whatsapp.com/send?phone="
        const val COUNTRY_CODE = "country_code"
        const val COUNTRY_CODE_VALUE = "91"
        const val PHONE_CODE = "mobile_number"
    }

    /**
     * Module URIs
     */
    object ModuleUris {
        const val AUTH = "app://${BuildConfig.ACCOUNT_TYPE}.auth"
    }

    object Uris {

    }

    object EndUrls {
        const val END_URL_ABOUT_US = "about-us-mobile-app"
        const val END_URL_PRIVACY_POLICY = "privacy-policy-mobile-app"
        const val END_URL_TERMS_CONDITIONS = "terms-and-conditions-mobile-app"
    }

    /**
     * Deep link URI
     */
    object DeepLinkUri {
        const val CATEGORY_LIST = "app://com.aatoon.namasthe.product.ui.category.list"
        const val PRODUCT_LIST = "app://com.aatoon.namasthe.product.ui.product.list"
        const val PLAY_STORE_URL = "https://play.google.com/store/apps/details?id="
    }
}
