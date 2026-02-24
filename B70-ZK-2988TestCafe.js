import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2988TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2988TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<grid onCreate=\'Clients.evalJavaScript("done()")\'>
		<columns>
			<column label="Col 1" hflex="min" />
			<column label="Col 2" hflex="1" />
			<column label="Col 3" hflex="1" />
			<column label="Col 4" hflex="1" />
		</columns>
		<rows>
			<row>
				<label value="1" />
				<label value="2" />
				<label value="3" />
				<label value="4" />
			</row>
		</rows>
		<foot>
			<footer label="1" span="2"/>
			<footer label="3" />
			<footer label="4" />
		</foot>
	</grid>
	<script>
		function done() {
			document.body.setAttribute("done", "true");
		}
	</script>
</zk>`,
	);
	let done_cafe = await ClientFunction(() => jq("body").attr("done"))();
	await t.expect(ztl.normalizeText("true")).eql(ztl.normalizeText(done_cafe));
});
