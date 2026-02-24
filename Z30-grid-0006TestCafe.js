import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-grid-0006TestCafe`
	.page`http://localhost:8080/zktest/test2/Z30-grid-0006.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("Z30-grid-0006TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("$col").outerWidth())(),
		),
		ztl.normalizeText("125"),
		ztl.normalizeText("5"),
	);
	await t.click(Selector(() => jq("$btnWid")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(ztl.normalizeText("125"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq("$col").outerWidth())(),
			),
			"",
		);
	await t
		.expect(ztl.normalizeText("200"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("$col").outerWidth())(),
			),
		);
	await t.click(
		Selector(() => jq("$col")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Apple"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Lemon"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Orange"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Tomato"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$addRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Apple"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Lemon"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Orange"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Tomato"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$insRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Ins1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Apple"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Lemon"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Orange"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Tomato"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(
		Selector(() => jq("$col")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Tomato"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Orange"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Lemon"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Ins1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Apple"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(
		Selector(() => jq("$col")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("A31"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Apple"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Ins1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Lemon"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Orange"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Tomato"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
