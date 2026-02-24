import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1963607TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1963607TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Load more than one page at a time">
	<paging pageSize="5" id="pg"/>
	<listbox id="l" mold="paging" paginal="\${pg}">
	<listhead/>
	</listbox>
	<button label="Test Listbox">
	 <attribute name="onClick"><![CDATA[
	 for (int i = 0; i < 6; i++)
		 new Listitem("li"+i).setParent(l);
	 ]]></attribute>
	</button>
	<grid mold="paging" pageSize="5">
		<columns/>
		<rows id="rows"/>
	</grid>
	<button label="Test Grid">
	 <attribute name="onClick"><![CDATA[
	 for (int i = 0; i < 6; i++) {
		 Row r= new Row();
		 new Label("r" + i).setParent(r);
		 r.setParent(rows);
	 }
	 ]]></attribute>
	</button>
	
</window>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("span.z-paging-text:first").text().replace(/\s/g, " "),
				)(),
			),
		)
		.notEql(ztl.normalizeText("/ 1"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listitem:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("span.z-paging-text:last").text().replace(/\s/g, " "),
				)(),
			),
		)
		.notEql(ztl.normalizeText("/ 1"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row:visible").length)(),
			),
		)
		.eql(ztl.normalizeText("5"));
});
