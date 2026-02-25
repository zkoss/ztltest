import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2926939TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2926939TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<html><![CDATA[
						<ol>
							<li>Click page button</li>
							<li>Check the number <b>inside dialog</b>, the left hand side number shall equal to the right hand side number</li>
						</ol>
					]]></html>
					Please check the paging number to see the result that the both number should be the same.
					<paging mold="os" pageSize="10" totalSize="100" onPaging=\'alert(event.getActivePage() + " : " + self.getActivePage());\'/>
				</zk>`,
	);
	await t.click(Selector(() => jq(".z-paging-button:contains(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("1 : 1"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(3)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2 : 2"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(4)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("3 : 3"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(5)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("4 : 4"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(6)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("5 : 5"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(7)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("6 : 6"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(8)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("7 : 7"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(9)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("8 : 8"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-paging-button:contains(10)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("9 : 9"));
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
});
