package project.app.msmesol.data

// Subcategory Data Class
data class Tag(
    val name: String,
    val image: String,
    val tips: List<String> = emptyList()
) {
    constructor() : this("", "", emptyList())
}

// Category Data Class
data class Groups(
    val name: String,
    val tags: List<Tag> = emptyList()
) {
    constructor() : this("", emptyList())

    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name,
            "${name.first()} ${tags.joinToString(" ") { it.name }}",
            "${tags.any()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

// Sample Data
val categories = listOf(
    Groups(
        name = "Clothing",
        tags = listOf(
            Tag(name = "Apparel", image = "ic_apparel"),
            Tag(name = "Footwear", image = "ic_footwear"),
            Tag(name = "Accessories", image = "ic_accessories")
        )
    ),
    Groups(
        name = "Electronics",
        tags = listOf(
            Tag(name = "Consumer Electronics", image = "ic_consumer_electronics"),
            Tag(name = "Home Appliances", image = "ic_home_appliances"),
            Tag(name = "Industrial Electronics", image = "ic_industrial_electronics")
        )
    ),
    Groups(
        name = "Furniture",
        tags = listOf(
            Tag(name = "Home Furniture", image = "ic_home_furniture"),
            Tag(name = "Office Furniture", image = "ic_office_furniture"),
            Tag(name = "Outdoor Furniture", image = "ic_outdoor_furniture")
        )
    ),
    Groups(
        name = "Food & Beverage",
        tags = listOf(
            Tag(name = "Packaged Foods", image = "ic_packaged_foods"),
            Tag(name = "Beverages", image = "ic_beverages"),
            Tag(name = "Organic Products", image = "ic_organic_products")
        )
    ),
    Groups(
        name = "Automotive",
        tags = listOf(
            Tag(name = "Auto Parts", image = "ic_auto_parts"),
            Tag(name = "Accessories", image = "ic_auto_accessories")
        )
    ),
    Groups(
        name = "Health & Beauty",
        tags = listOf(
            Tag(name = "Personal Care", image = "ic_personal_care"),
            Tag(name = "Health Products", image = "ic_health_products"),
            Tag(name = "Cosmetics", image = "ic_cosmetics")
        )
    ),
    Groups(
        name = "Construction",
        tags = listOf(
            Tag(name = "Building Materials", image = "ic_building_materials"),
            Tag(name = "Tools & Equipment", image = "ic_tools_equipment"),
            Tag(name = "Safety Gear", image = "ic_safety_gear")
        )
    ),
    Groups(
        name = "Agriculture",
        tags = listOf(
            Tag(name = "Farming Equipment", image = "ic_farming_equipment"),
            Tag(name = "Seeds & Fertilizers", image = "ic_seeds_fertilizers"),
            Tag(name = "Irrigation Systems", image = "ic_irrigation_systems")
        )
    ),
    Groups(
        name = "Textiles",
        tags = listOf(
            Tag(name = "Fabrics", image = "ic_fabrics"),
            Tag(name = "Yarns", image = "ic_yarns"),
            Tag(name = "Textile Machinery", image = "ic_textile_machinery")
        )
    ),
    Groups(
        name = "Jewelry",
        tags = listOf(
            Tag(name = "Gold Jewelry", image = "ic_gold_jewelry"),
            Tag(name = "Precious Stones", image = "ic_precious_stones")
        )
    )
)
