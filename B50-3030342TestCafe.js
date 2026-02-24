import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3030342TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3030342TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html>
			<![CDATA[
			<ol>
				<li>Check "David", "Thomas" and "Steven" in the listbox</li>
			</ol>
			]]>
			</html>
				<listbox id="listbox" width="100px">
					<attribute name="onCreate"><![CDATA[
						List list = new ArrayList();
						list.add("David");
						list.add("Thomas");
						list.add("Steven");
						
						listbox.setModel(new ListModelList(list));
					]]></attribute>
				</listbox>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("listbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("David"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("listbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(1)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Thomas"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("listbox", true).$n("rows"))
						.find(".z-listcell")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Steven"), "");
});
