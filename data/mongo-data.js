db = db.getSiblingDB('bifi');

db.factuur.drop();

db.factuur.insert(
{
	"customerId" : 1,
	"date" : ISODate("2018-05-16T10:23:40.049Z"),
	"invoiceId" : 1,
	"invoiceLines" : [
		{
			"btwCode" : "HIGH",
			"productId" : 1,
			"productName" : "BiFi worstjes voordeelstrip",
			"quantity" : 20,
			"totalPrice" : 30,
			"unit" : "kg"
		}
	],
	"note" : "This invoice is very important!",
	"personId" : 1
});

db.factuur.insert(
{
	"customerId" : 1,
	"date" : ISODate("2018-05-16T10:23:40.049Z"),
	"invoiceId" : 1,
	"invoiceLines" : [
		{
			"btwCode" : "hoog",
			"productId" : 1,
			"productName" : "BiFi worstjes voordeelstrip",
			"quantity" : 20,
			"totalPrice" : 30,
			"unit" : "kg"
		}
	],
	"note" : "This invoice is very important!",
	"personId" : 1
});

db.factuur.insert(
{
	"customerId" : 2,
	"date" : ISODate("2018-05-16T10:23:40.049Z"),
	"invoiceId" : 1,
	"invoiceLines" : [
		{
			"btwCode" : "hoog",
			"productId" : 1,
			"productName" : "BiFi worstjes voordeelstrip",
			"quantity" : 20,
			"totalPrice" : 30,
			"unit" : "kg"
		},
		{
					"btwCode" : "hoog",
					"productId" : 2,
					"productName" : "BiFi worstjes kip",
					"quantity" : 20,
					"totalPrice" : 30,
					"unit" : "kg"
		},
		{
					"btwCode" : "laag",
					"productId" : 3,
					"productName" : "BiFi worstjes extra scherp",
					"quantity" : 30,
					"totalPrice" : 100.22,
					"unit" : "kg"
		},
		{
					"btwCode" : "geen",
					"productId" : 1,
					"productName" : "BiFi worstjes promotiestand",
					"quantity" : -1,
					"totalPrice" : 30.32,
					"unit" : "kg"
		}
	],
	"note" : "This invoice is very important!",
	"personId" : 2
});

db.factuur.insert(
{
	"customerId" : 1,
	"date" : ISODate("2018-05-16T10:23:40.049Z"),
	"invoiceId" : 3,
	"invoiceLines" : [
		{
			"btwCode" : "HIGH",
			"productId" : 1,
			"productName" : "BiFi worstjes voordeelstrip - Terug gestuurd na overleg met Kees en Klaas is er ook van hoogte zie email van 30 april 2018.",
			"quantity" : 20,
			"totalPrice" : -30,
			"unit" : "kg"
		}
	],
	"personId" : 3
});

db.factuur.insert(
{
	"customerId" : 3,
	"date" : ISODate("2018-06-16T10:23:40.049Z"),
	"invoiceId" : 1,
	"invoiceLines" : [
		{
			"btwCode" : "HIGH",
			"productId" : 1,
			"productName" : "BiFi worstjes voordeelstrip",
			"quantity" : 20,
			"totalPrice" : 30,
			"unit" : "kg"
		}
	],
	"personId" : 3
});

db.factuur.insert(
{
	"customerId" : 3,
	"date" : ISODate("2018-05-16T10:23:40.049Z"),
	"invoiceId" : 1,
	"invoiceLines" : [
		{
			"btwCode" : "HIGH",
			"productId" : 1,
			"productName" : "BiFi worstjes voordeelstrip",
			"quantity" : 20,
			"totalPrice" : 30,
			"unit" : "kg"
		}
	],
	"personId" : 3
});

