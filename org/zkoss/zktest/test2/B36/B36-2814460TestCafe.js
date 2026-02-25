import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2814460TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2814460TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
    In opera, you should not see any error.
    <listbox id="box" multiple="true" checkmark="true">
        <listhead>
            <listheader label="Name"/>
            <listheader label="Gender"/>
            <listheader label="Age"/>
            <listheader label="Description"/>
        </listhead>
        <listgroup label="abc" checkable="false"/>
        <listitem>
            <listcell label="Mary"/>
            <listcell label="FEMALE"/>
            <listcell label="18"/>
            <listcell label="A young lady."/>
        </listitem>
        <listitem>
            <listcell label="John"/>
            <listcell label="MALE"/>
            <listcell label="20"/>
            <listcell label="A college student."/>
        </listitem>
        <listitem>
            <listcell label="Jane"/>
            <listcell label="FEMALE"/>
            <listcell label="32"/>
            <listcell label="A remarkable artist."/>
        </listitem>
        <listitem>
            <listcell label="Henry"/>
            <listcell label="MALE"/>
            <listcell label="29"/>
            <listcell label="A graduate."/>
        </listitem>
    </listbox>
</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
