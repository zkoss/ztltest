import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z30-listbox-0003TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-listbox-0003TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			Test dynamically select the second listitem.
			<listbox rows="3" width="400px">
				<listhead>
					<listheader label="Population"/>
					<listheader label="Percentage"/>
					<listheader label="Description"/>
				</listhead>
				<listitem id="li0" value="A">
					<listcell label="A. Graduate"/>
					<listcell label="20%"/>
					<listcell label="More or less"/>
				</listitem>
				<listitem id="li1" value="B">
					<listcell label="B. College"/>
					<listcell label="23%"/>
					<listcell label="More or less"/>
				</listitem>
				<listitem value="C" selected="true">
					<listcell label="C. High School"/>
					<listcell label="40%"/>
					<listcell label="More or less"/>
				</listitem>
				<listitem value="D">
					<listcell label="D. Junior High School"/>
					<listcell label="10%"/>
					<listcell label="More or less"/>
				</listitem>
				<listitem value="E">
					<listcell label="F. Others"/>
					<listcell label="17%"/>
					<listcell label="More or less"/>
				</listitem>
			</listbox>
			<button id="btn1" label="Select 2nd" onClick="li1.selected = true"/>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("C. High School"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected .z-listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btn1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("B. College"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem-selected .z-listcell:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
