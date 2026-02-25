import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-522TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-522TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>This page should displaied without any problem.</div>
				<tablelayout columns="3">
					<custom-attributes org.zkoss.zul.image.preload="true"/>
				    <tablechildren rowspan="2">
				        <window width="300px" height="500px" title="test window" border="normal" />
				    </tablechildren>
				    <tablechildren>
				        <listbox height="250px" width="250px">
				        	<listhead>
				        		<listheader label="test listbox" />
				        	</listhead>
				        	<listitem>
				       			<listcell> test listbox</listcell>
				       		</listitem>
				        </listbox>
				    </tablechildren>
				    <tablechildren>
						<groupbox mold="3d" height="250px" width="250px" open="true">
							<caption image="/test2/img/inet.png" label="Testing Group Box" />
							<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
						</groupbox>
				    </tablechildren>
				    <tablechildren colspan="2">
				        <window height="245px" title="test window" border="normal" />
				    </tablechildren>
				</tablelayout>
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listheader:contains(test listbox)")[0],
			)(),
		)
		.ok("The listbox in tablechildren is displayed well");
});
