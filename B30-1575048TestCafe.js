import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1575048TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1575048.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1575048TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() =>
			zk.Desktop._dt
				.$f("userList", true)
				.getBodyWidgetIterator()
				.next()
				.$n(),
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("userList", true)
						.getBodyWidgetIterator()
						.next()
						.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("userList", true).paging.getTotalSize(),
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t.click(
		Selector(() =>
			zk.Desktop._dt
				.$f("userList", true)
				.getBodyWidgetIterator()
				.next()
				.$n(),
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("userList", true)
						.getBodyWidgetIterator()
						.next()
						.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("userList", true).paging.getTotalSize(),
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("userList", true).paging).is(":visible"),
			)(),
		)
		.notOk();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("itemId", true).$n()),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("itemName", true).$n()),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("userList", true).paging).find(
					".z-paging-next",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("userList", true).lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("123"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("userList", true).paging.getTotalSize(),
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("userList", true).paging).is(":visible"),
			)(),
		)
		.ok();
});
