import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-873TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-873TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div height="20px"/>
                    <div>You should not see any selectall box in the list header</div>
                    <div height="20px"/>
                    <listbox multiple="true" checkmark="true" mold="paging" pageSize="5">
                      <custom-attributes org.zkoss.zul.listbox.rod="true"/>
                      <listhead>
                        <listheader label="Name1"/>
                        <listheader label="Address"/>
                      </listhead>
                      <zk forEach="1,2,3,4,5,6,7,8,9">
                        <listitem>
                          <listcell label="Name \${each}"></listcell>
                          <listcell label="Address \${each}"></listcell>
                        </listitem>
                      </zk>
                    </listbox>
                    <listbox multiple="true" checkmark="true" mold="paging" pageSize="10">
                      <custom-attributes org.zkoss.zul.listbox.rod="true"/>
                      <listhead>
                        <listheader label="Name2"/>
                        <listheader label="Address2"/>
                      </listhead>
                      <zk forEach="1,2,3,4,5,6,7,8,9">
                        <listitem>
                          <listcell label="Name \${each}"></listcell>
                          <listcell label="Address \${each}"></listcell>
                        </listitem>
                      </zk>
                    </listbox>
                  </zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-listheader:contains(Name1) .z-listheader-img")[0],
			)(),
		)
		.notOk("should not see any selectall box in the list header");
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-listheader:contains(Name2) .z-listheader-img")[0],
			)(),
		)
		.notOk("should not see any selectall box in the list header");
});
