import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1490TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1490TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="client">
                    <html>
                      Testing instructions: None
		
		Expected results:
                      <ul>
                        <li>No JavaScript exceptions should occur.</li>
                      </ul>
                    </html>
                    <borderlayout height="500px" width="500px">
                      <north>
                        <attribute w:name="onBind">
                          <![CDATA[
				this.setSize(\'20%\');
				zk.log(\'NORTH\', this.getSize());
			]]>
                        </attribute>
                        Hello North
                      </north>
                      <west>
                        <attribute w:name="onBind">
                          <![CDATA[
			  this.setSize(\'20%\');
			  zk.log(\'WEST\', this.getSize());
			]]>
                        </attribute>
                        Hello West
                      </west>
                      <center>Hello Center</center>
                      <east>
                        <attribute w:name="onBind">
                          <![CDATA[
			  this.setSize(\'20%\');
			  zk.log(\'EAST\', this.getSize());
			]]>
                        </attribute>
                        Hello East
                      </east>
                      <south>
                        <attribute w:name="onBind">
                          <![CDATA[
			  this.setSize(\'20%\');
			  zk.log(\'SOUTH\', this.getSize());
			]]>
                        </attribute>
                        Hello South
                      </south>
                    </borderlayout>
                  </zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("No JavaScript exceptions should occur.");
});
