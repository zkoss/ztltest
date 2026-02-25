import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1315TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1315TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      1. Hide \'Title\' column by menupopup.<separator/>
                      2. Click \'Publisher\' column to sort.<separator/>
                      3. Show \'Title\' column by menupopup. \'Title\' column should show correctly.<separator/>
                    </div>
                    <grid sizedByContent="true">
                      <auxhead>
                        <auxheader colspan="4" label="Grid"/>
                      </auxhead>
                      <columns menupopup="auto">
                        <column label="Author" sort="auto"/>
                        <column label="Title" sort="auto"/>
                        <column label="Publisher" sort="auto"/>
                        <column label="Hardcover" sort="auto"/>
                      </columns>
                      <rows>
                        <row>
                          <label value="Philip Hensher"/>
                          <label value="The Northern Clemency"/>
                          <label value="Knopf (October 30, 2008)"/>
                          <label value="608 pages"/>
                        </row>
                        <row>
                          <label value="Philip Hensher"/>
                          <label value="The Fit"/>
                          <label value="HarperPerennial (April 4, 2005)"/>
                          <label value="240 pages"/>
                        </row>
                      </rows>
                    </grid>
                    <listbox sizedByContent="true">
                      <auxhead>
                        <auxheader colspan="4" label="Listbox"/>
                      </auxhead>
                      <listhead menupopup="auto">
                        <listheader label="Author" sort="auto"/>
                        <listheader label="Title" sort="auto"/>
                        <listheader label="Publisher" sort="auto"/>
                        <listheader label="Hardcover" sort="auto"/>
                      </listhead>
                      <listitem>
                        <listcell label="Philip Hensher"/>
                        <listcell label="The Northern Clemency"/>
                        <listcell label="Knopf (October 30, 2008)"/>
                        <listcell label="608 pages"/>
                      </listitem>
                      <listitem>
                        <listcell label="Philip Hensher"/>
                        <listcell label="The Fit"/>
                        <listcell label="HarperPerennial (April 4, 2005)"/>
                        <listcell label="240 pages"/>
                      </listitem>
                    </listbox>
                  </zk>`,
	);
	await t.hover(Selector(() => jq(".z-column")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-column")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:contains(Title):eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-column:contains(Title):eq(0)").is(":visible"),
			)(),
		)
		.ok("Hide 'Title' column by menupopup.");
	await t.click(Selector(() => jq(".z-column:contains(Publisher):eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(
					zk.Widget.$(jq(".z-column:contains(Publisher):eq(0)")).$n(
						"sort-icon",
					),
				).is("[class*=up]"),
			)(),
		)
		.ok("Click 'Publisher' column to sort.");
	await t.hover(Selector(() => jq(".z-column")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-column")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem:contains(Title):eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-column:contains(Title):eq(0)").css("display"),
				)(),
			),
			"Show 'Title' column by menupopup.",
		);
});
