package project.app.msmesol.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.Chair
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Texture
import androidx.compose.ui.graphics.vector.ImageVector

// Subcategory Data Class
data class Tag(
    val name: String,
    val image: String,
    val tips: List<String> = emptyList(),
    val description: String = ""
) {
    constructor() : this("", "", emptyList(), "")
}

// Category Data Class
data class Groups(
    val name: String,
    val tags: List<Tag> = emptyList(),
    val icon: ImageVector? = null
) {
    constructor() : this("", emptyList(), null)

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
            Tag(
                name = "Apparel",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fapparel.png?alt=media&token=3ef03d5f-feb1-4ecd-9f07-8ba701f8435d",
                description = "Apparel is a term used to describe clothing. It can be made from natural or synthetic fibers and can be worn by people of all ages. Apparel can be used to protect the body from the elements, to provide warmth, or to express personal style."
            ),
            Tag(
                name = "Footwear",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffootwear.png?alt=media&token=b9cc82c0-6118-4984-aae2-b5190e626d51",
                description = "Footwear refers to garments worn on the feet, which originally serves to purpose of protection against adversities of the environment, usually regarding ground textures and temperature. Footwear in the manner of shoes therefore primarily serves the purpose to ease the locomotion and prevent injuries."
            ),
            Tag(
                name = "Accessories",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Faccessories.png?alt=media&token=54eb3600-30c2-4342-b3e1-222fe7454245",
                description = "Accessories are items that are used to complement one's outfit. They can add style, color, and class to an outfit, and they can also serve a practical purpose. Accessories can include jewelry, belts, hats, scarves, gloves, handbags, shoes, and more."
            )
        ),
        icon = Icons.Filled.ShoppingBag
    ),
    Groups(
        name = "Electronics",
        tags = listOf(
            Tag(name = "Consumer Electronics", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fconsumer-electronics.png?alt=media&token=bf2e4eb9-8c16-4b91-8be4-73998c94abd8"),
            Tag(name = "Home Appliances", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fappliances.png?alt=media&token=4d17ba26-30b3-4b92-8799-f25de4df8ca2"),
            Tag(name = "Industrial Electronics", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Felectronic-equipments.png?alt=media&token=b134a599-00d2-491d-9e2e-edd1e5afb083")
        ),
        icon = Icons.Filled.Devices
    ),
    Groups(
        name = "Furniture",
        tags = listOf(
            Tag(name = "Home Furniture", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffurntiure.png?alt=media&token=7e3b57d9-e8fe-4efd-9309-b4caac9a52b0"),
            Tag(name = "Office Furniture", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Foffice-furniture.png?alt=media&token=bab7202f-4e20-46cd-a384-6a7417183460"),
        ),
        icon = Icons.Filled.Chair
    ),
    Groups(
        name = "Food & Beverage",
        tags = listOf(
            Tag(
                name = "Packaged Foods",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fpackaged-foods.png?alt=media&token=06a83672-a5d2-4af4-9766-552583fd42c0",
                description = "Packaged foods are foods that are processed and packaged for convenience. They can be found in grocery stores, convenience stores, and vending machines. Packaged foods can include snacks, frozen meals, canned goods, and more."
            ),
            Tag(
                name = "Beverages",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fbeverages.png?alt=media&token=0663878b-b66c-4919-b666-6581129141e1",
                description = "Beverages are drinks that are consumed to quench thirst or for enjoyment. They can be hot or cold, alcoholic or non-alcoholic, and can be made from a variety of ingredients. Beverages can include water, tea, coffee, soda, juice, and more."
            ),
            Tag(
                name = "Organic Products",
                image = "ic_organic_products",
                description = "Organic products are foods and beverages that are made without the use of synthetic chemicals, pesticides, or fertilizers. They are grown and processed using organic farming methods, which are designed to promote ecological balance and conserve biodiversity."
            )
        ),
        icon = Icons.Filled.Fastfood
    ),
    Groups(
        name = "Automotive",
        tags = listOf(
            Tag(
                name = "Auto Parts",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fauto-parts.png?alt=media&token=65c3364a-c23b-4aaf-a65e-671d21f8f61d",
                description = "Auto parts are components that make up a vehicle. They can include everything from engines and transmissions to brakes and tires. Auto parts can be used to repair or upgrade a vehicle, and they can be purchased from auto parts stores, dealerships, and online retailers."
            ),
            Tag(
                name = "Accessories",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fauto-accessories.png?alt=media&token=3a7dd44b-57e3-41cd-aad6-b41549a1a412",
                description = "Auto accessories are items that are used to enhance the appearance or functionality of a vehicle. They can include everything from seat covers and floor mats to roof racks and bike racks. Auto accessories can be purchased from auto parts stores, dealerships, and online retailers."
            )
        ),
        icon = Icons.Filled.DirectionsCar
    ),
    Groups(
        name = "Health & Beauty",
        tags = listOf(
            Tag(
                name = "Personal Care",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fpersonal-care.png?alt=media&token=66a3a0b3-f850-4d21-92b5-d289e5f1fae5",
                description = "Personal care products are items that are used to maintain personal hygiene and appearance. They can include everything from soap and shampoo to deodorant and toothpaste. Personal care products can be found in grocery stores, drugstores, and specialty beauty stores."
            ),
            Tag(
                name = "Health Products",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fhealth-products.png?alt=media&token=68385e6a-1056-4280-9850-3a7ed7497483",
                description = "Health products are items that are used to promote health and well-being. They can include everything from vitamins and supplements to first aid supplies and medical devices. Health products can be found in pharmacies, health food stores, and online retailers."
            ),
            Tag(
                name = "Cosmetics",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fcosmetics.png?alt=media&token=3af8a717-95a2-44f0-9a54-9efb89e1e235",
                description = "Cosmetics are products that are used to enhance or alter the appearance of the face, body, or hair. They can include everything from makeup and skincare products to hair care and fragrance. Cosmetics can be found in department stores, specialty beauty stores, and online retailers."
            )
        ),
        icon = Icons.Filled.FitnessCenter
    ),
    Groups(
        name = "Construction",
        tags = listOf(
            Tag(
                name = "Building Materials",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fbuilding-materials.png?alt=media&token=98a29001-ec8f-4b0f-9dfa-b48374f98cb3",
                description = "Building materials are materials that are used in the construction of buildings, roads, bridges, and other structures. They can include everything from wood and steel to concrete and glass. Building materials can be purchased from hardware stores, building supply stores, and online retailers."
            ),
            Tag(
                name = "Tools & Equipment",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ftools-and-equipment.png?alt=media&token=bd8ccb6a-146c-49b8-a436-7538cbb1d1e6",
                description = "Tools and equipment are items that are used to perform tasks or work. They can include everything from hand tools and power tools to heavy equipment and machinery. Tools and equipment can be purchased from hardware stores, tool rental shops, and online retailers."
            ),
            Tag(
                name = "Safety Gear",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fheadgear.png?alt=media&token=8dddeb66-d2a2-44ec-931f-c64a55264e08",
                description = "Safety gear is equipment that is used to protect workers from injury or harm. It can include everything from hard hats and safety glasses to gloves and earplugs. Safety gear can be purchased from safety supply stores, industrial suppliers, and online retailers."
            )
        ),
        icon = Icons.Filled.Construction
    ),
    Groups(
        name = "Agriculture",
        tags = listOf(
            Tag(name = "Farming Equipment", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffarming-equipment.png?alt=media&token=561ffdc4-38dd-4863-9240-0555b09f0835"),
            Tag(name = "Seeds & Fertilizers", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fseeds-and-fertilizers.png?alt=media&token=760dc9ba-31bc-41dc-99a6-07e707cebe03"),
            Tag(name = "Irrigation Systems", image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Firrigation-systems.png?alt=media&token=f9056d0a-64d2-4478-a644-fe1b928a0391")
        ),
        icon = Icons.Filled.Agriculture
    ),
    Groups(
        name = "Textiles",
        tags = listOf(
            Tag(
                name = "Fabrics",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ffabrics.png?alt=media&token=de2763ef-4b07-4f03-bb4f-e1daff524ec0",
                description = "Fabrics are materials that are made from fibers or yarns. They can be woven, knitted, or bonded together to create a variety of textures and patterns. Fabrics can be used to make clothing, upholstery, bedding, and more."
            ),
            Tag(
                name = "Yarns",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fyarns.png?alt=media&token=38f31e5c-0783-4e3e-9925-fe277b839748",
                description = "Yarns are strands of fibers that are twisted or spun together to create a continuous length. They can be made from natural or synthetic fibers and can be used to make textiles, clothing, and other products. Yarns can be purchased in a variety of colors, weights, and textures."
            ),
            Tag(
                name = "Textile Machinery",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Ftextile-machinery.png?alt=media&token=0c7394ac-a11a-4cc4-8ea6-06f3d3f10fd7",
                description = "Textile machinery is equipment that is used to process fibers, yarns, and fabrics. It can include everything from spinning machines and weaving looms to dyeing machines and finishing equipment. Textile machinery can be used to produce a wide range of textiles, including clothing, upholstery, and industrial fabrics."
            )
        ),
        icon = Icons.Filled.Texture
    ),
    Groups(
        name = "Jewelry",
        tags = listOf(
            Tag(
                name = "Gold Jewelry",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fgold-jwellery.png?alt=media&token=6fdb8a3b-dc5d-4e71-945a-f53092ca3b1a",
                description = "Gold jewelry is jewelry that is made from gold. It can be pure gold or gold alloyed with other metals to create different colors and properties. Gold jewelry can include rings, necklaces, bracelets, earrings, and more."
            ),
            Tag(
                name = "Precious Stones",
                image = "https://firebasestorage.googleapis.com/v0/b/xpress-bbe8e.appspot.com/o/xpress-categories-icons%2Fprecious-stones.png?alt=media&token=d1d7fb6b-88e1-4f1f-9d96-be01c9fb31e5",
                description = "Precious stones are gemstones that are rare, valuable, and beautiful. They can include diamonds, rubies, sapphires, emeralds, and more. Precious stones can be used to make jewelry, art, and decorative objects."
            )
        ),
        icon = Icons.Filled.Diamond
    )
)
