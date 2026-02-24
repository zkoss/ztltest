import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2395TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2395.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2395TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.wait(3000);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@tree").eq(0).find("@treecol").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@tree")
						.eq(0)
						.find("@treerow")
						.first()
						.find("@treecell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@tree").eq(1).find("@treecol").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@tree")
						.eq(1)
						.find("@treerow")
						.first()
						.find("@treecell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox").eq(0).find("@listheader").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.first()
						.find("@listcell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox").eq(1).find("@listheader").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.first()
						.find("@listcell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@grid").eq(0).find("@column").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@grid")
						.eq(0)
						.find("@row")
						.first()
						.find(".z-row-inner")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@grid").eq(1).find("@column").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@grid")
						.eq(1)
						.find("@row")
						.first()
						.find(".z-row-inner")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@tree").eq(0).find("@treecol").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@tree")
						.eq(0)
						.find("@treerow")
						.first()
						.find("@treecell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@tree").eq(1).find("@treecol").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@tree")
						.eq(1)
						.find("@treerow")
						.first()
						.find("@treecell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox").eq(0).find("@listheader").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.first()
						.find("@listcell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox").eq(1).find("@listheader").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.first()
						.find("@listcell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@grid").eq(0).find("@column").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@grid")
						.eq(0)
						.find("@row")
						.first()
						.find(".z-row-inner")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@grid").eq(1).find("@column").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@grid")
						.eq(1)
						.find("@row")
						.first()
						.find(".z-row-inner")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(3)[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@tree").eq(0).find("@treecol").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@tree")
						.eq(0)
						.find("@treerow")
						.first()
						.find("@treecell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@tree").eq(1).find("@treecol").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@tree")
						.eq(1)
						.find("@treerow")
						.first()
						.find("@treecell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox").eq(0).find("@listheader").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.first()
						.find("@listcell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox").eq(1).find("@listheader").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.first()
						.find("@listcell")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@grid").eq(0).find("@column").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@grid")
						.eq(0)
						.find("@row")
						.first()
						.find(".z-row-inner")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@grid").eq(1).find("@column").last().offset().left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@grid")
						.eq(1)
						.find("@row")
						.first()
						.find(".z-row-inner")
						.last()
						.offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
});
