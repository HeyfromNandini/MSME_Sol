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
            Tag(name = "Apparel", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fapparel.png?alt=media&token=3ef03d5f-feb1-4ecd-9f07-8ba701f8435d"),
            Tag(name = "Footwear", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffootwear.png?alt=media&token=b9cc82c0-6118-4984-aae2-b5190e626d51"),
            Tag(name = "Accessories", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Faccessories.png?alt=media&token=54eb3600-30c2-4342-b3e1-222fe7454245")
        )
    ),
    Groups(
        name = "Electronics",
        tags = listOf(
            Tag(name = "Consumer Electronics", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fconsumer-electronics.png?alt=media&token=bf2e4eb9-8c16-4b91-8be4-73998c94abd8"),
            Tag(name = "Home Appliances", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fappliances.png?alt=media&token=4d17ba26-30b3-4b92-8799-f25de4df8ca2"),
            Tag(name = "Industrial Electronics", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Felectronic-equipments.png?alt=media&token=b134a599-00d2-491d-9e2e-edd1e5afb083")
        )
    ),
    Groups(
        name = "Furniture",
        tags = listOf(
            Tag(name = "Home Furniture", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffurntiure.png?alt=media&token=7e3b57d9-e8fe-4efd-9309-b4caac9a52b0"),
            Tag(name = "Office Furniture", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Foffice-furniture.png?alt=media&token=bab7202f-4e20-46cd-a384-6a7417183460"),
        )
    ),
    Groups(
        name = "Food & Beverage",
        tags = listOf(
            Tag(name = "Packaged Foods", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fpackaged-foods.png?alt=media&token=06a83672-a5d2-4af4-9766-552583fd42c0"),
            Tag(name = "Beverages", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fbeverages.png?alt=media&token=0663878b-b66c-4919-b666-6581129141e1"),
            Tag(name = "Organic Products", image = "ic_organic_products")
        )
    ),
    Groups(
        name = "Automotive",
        tags = listOf(
            Tag(name = "Auto Parts", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fauto-parts.png?alt=media&token=65c3364a-c23b-4aaf-a65e-671d21f8f61d"),
            Tag(name = "Accessories", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fauto-accessories.png?alt=media&token=3a7dd44b-57e3-41cd-aad6-b41549a1a412")
        )
    ),
    Groups(
        name = "Health & Beauty",
        tags = listOf(
            Tag(name = "Personal Care", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fpersonal-care.png?alt=media&token=66a3a0b3-f850-4d21-92b5-d289e5f1fae5"),
            Tag(name = "Health Products", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fhealth-products.png?alt=media&token=68385e6a-1056-4280-9850-3a7ed7497483"),
            Tag(name = "Cosmetics", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fcosmetics.png?alt=media&token=3af8a717-95a2-44f0-9a54-9efb89e1e235")
        )
    ),
    Groups(
        name = "Construction",
        tags = listOf(
            Tag(name = "Building Materials", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fbuilding-materials.png?alt=media&token=98a29001-ec8f-4b0f-9dfa-b48374f98cb3"),
            Tag(name = "Tools & Equipment", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ftools-and-equipment.png?alt=media&token=bd8ccb6a-146c-49b8-a436-7538cbb1d1e6"),
            Tag(name = "Safety Gear", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fheadgear.png?alt=media&token=8dddeb66-d2a2-44ec-931f-c64a55264e08")
        )
    ),
    Groups(
        name = "Agriculture",
        tags = listOf(
            Tag(name = "Farming Equipment", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffarming-equipment.png?alt=media&token=561ffdc4-38dd-4863-9240-0555b09f0835"),
            Tag(name = "Seeds & Fertilizers", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fseeds-and-fertilizers.png?alt=media&token=760dc9ba-31bc-41dc-99a6-07e707cebe03"),
            Tag(name = "Irrigation Systems", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Firrigation-systems.png?alt=media&token=f9056d0a-64d2-4478-a644-fe1b928a0391")
        )
    ),
    Groups(
        name = "Textiles",
        tags = listOf(
            Tag(name = "Fabrics", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffabrics.png?alt=media&token=de2763ef-4b07-4f03-bb4f-e1daff524ec0"),
            Tag(name = "Yarns", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fyarns.png?alt=media&token=38f31e5c-0783-4e3e-9925-fe277b839748"),
            Tag(name = "Textile Machinery", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ftextile-machinery.png?alt=media&token=0c7394ac-a11a-4cc4-8ea6-06f3d3f10fd7")
        )
    ),
    Groups(
        name = "Jewelry",
        tags = listOf(
            Tag(name = "Gold Jewelry", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fgold-jwellery.png?alt=media&token=6fdb8a3b-dc5d-4e71-945a-f53092ca3b1a"),
            Tag(name = "Precious Stones", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fprecious-stones.png?alt=media&token=d1d7fb6b-88e1-4f1f-9d96-be01c9fb31e5")
        )
    )
)
