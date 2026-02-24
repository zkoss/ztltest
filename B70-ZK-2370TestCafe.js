import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2370TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2370TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<panel title="Caption property ordering issue" border="normal"
	width="300px">
	<caption id="c" label="Caption"
		image="/img/Centigrade-Widget-Icons/ArrowUp-16x16.png"></caption>
	<panelchildren>
		<vlayout>
			If you click the below buttons in turn, the icon in the caption will
			not be updated correctly - it will lag behind by one assignment as it
			seems that if the label is set, the image is only subsequently
			<button label="Bad Left"
				image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png" width="125px"
				onClick=\'this.c.label="Left"; this.c.image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png"\' />
			<button label="Bad Right"
				image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png" 
				width="125px"
				onClick=\'this.c.label="Right"; this.c.image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png"\' />

			However if you click the below buttons in turn, the problem isn\'t
			there. because the image of the caption is being set before the
			label. The buttons above are doing it the other way around.
			<button label="Good Left"
				image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png" width="125px"
				onClick=\'this.c.image="/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png"; this.c.label="Left"\' />
			<button label="Good Right"
				image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png" dir="reverse"
				width="125px"
				onClick=\'this.c.image="/img/Centigrade-Widget-Icons/ArrowRight-16x16.png"; this.c.label="Right"\' />
		</vlayout>
	</panelchildren>
</panel>
<script>
  function checkLeft() {
    return jq(".z-caption-image").attr("src").indexOf("ArrowLeft") > 0
  }
  function checkRight() {
    return jq(".z-caption-image").attr("src").indexOf("ArrowRight") > 0
 }
</script>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Bad Left)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(await ClientFunction(() => checkLeft())()))
		.eql(ztl.normalizeText("true"));
	await t.click(Selector(() => jq(".z-button:contains(Bad Right)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(await ClientFunction(() => checkRight())()))
		.eql(ztl.normalizeText("true"));
});
