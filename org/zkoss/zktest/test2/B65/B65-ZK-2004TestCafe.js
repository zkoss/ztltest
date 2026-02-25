import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-2004TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2004TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Chosebox model replacement" border="normal" width="350px">
	<zscript><![CDATA[
        int i = 0;
        List list = Arrays.asList(new String[]{"AA", "BB", "CC", "DD", "EE"});
        ListModelList model = new ListModelList(list);
    ]]></zscript>
	<label multiline="true">
		1. Choose "DD", "BB", "EE" in the box.
		2. Click replace button.
		3. The chosenbox should not contain selected items.
	</label>
 	<chosenbox id="box" model="\${model}" width="200px"></chosenbox>
 	<separator/>
    <button label="Replace">
    	<attribute name="onClick"><![CDATA[
			List list = Arrays.asList(new String[]{"AA", "BB", "CC", "DD", "EE", "New" + i});
			i ++;
			box.setModel(new ListModelList(list));
    	]]></attribute>
    </button>
</window>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("pp")).find(
					".z-chosenbox-option:contains(DD)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("pp")).find(
					".z-chosenbox-option:contains(BB)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("pp")).find(
					".z-chosenbox-option:contains(EE)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-chosenbox-item")[0])())
		.notOk("The chosenbox should not contain selected items.");
});
