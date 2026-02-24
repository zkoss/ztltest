import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2859747TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2859747TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please click the "Text" header (it means upon the word.), and it should be sorted as well.
    <grid>
        <columns sizable="true">
            <column sort="auto">
                Text
            </column>
            <column label="Content"/>
        </columns>
        <rows>
            <row>
                <label value="File:"/>
                <textbox width="98%"/>
            </row>
            <row>
                <label value="Type:"/>
                <hbox>
                    <listbox rows="1" mold="select">
                        <listitem label="Java Files,(*.java)"/>
                        <listitem label="All Files,(*.*)"/>
                    </listbox>
                    <button label="Browse..."/>
                </hbox>
            </row>
            <row>
                <label value="Options:"/>
                <textbox rows="3" width="98%"/>
            </row>
        </rows>
    </grid>
</zk>`,
	);
	await t.click(
		Selector(() => jq("@column:eq(0)")[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(0) @label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("File:"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(1) @label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Options:"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row:eq(2) @label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Type:"));
});
