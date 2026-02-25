import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1812TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1812TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="client">

	<vlayout>
		currently only buttons 1-5 should work as expected (and return the expected data). before the fix 4 and 5 ignore all or parts of event data
		<div>
			1. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f(\'message1\'), \'onFoo\', \'plain string\', {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f(\'message1\'), \'onFoo\', \'plain string\', {toServer:true}));
		</div>
		Expected Result: plain string
		<hlayout>
			Actual Result: <label id="message1" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>
		
		<div>
			2. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f(\'message2\'), \'onFoo\', {\'\' : \'attrValueWithEmptyName\'}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f(\'message2\'), \'onFoo\', {\'\' : \'attrValueWithEmptyName\'}, {toServer:true}));
		</div>
		Expected Result: attrValueWithEmptyName -------------> {\'\' : \'attrValueWithEmptyName\'} is interpreted as plain string
		<hlayout>
			Actual Result: <label id="message2" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>

		<div>
			3. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f(\'message3\'), \'onFoo\', {\'\' : {\'attrName\' : \'attrValue\'}}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f(\'message3\'), \'onFoo\', {\'\' : {\'attrName\' : \'attrValue\'}}, {toServer:true}));
		</div>
		Expected Result: {"attrName" : "attrValue"} -------------> {\'\' : {\'attrName\' : \'attrValue\'}} is interpreted as {\'attrName\' : \'attrValue\'}
		<hlayout>
			Actual Result: <label id="message3" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>
			
		<div>
			4. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f(\'message4\'), \'onFoo\', {\'attrName\' : \'attrValue\'}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f(\'message4\'), \'onFoo\', {\'attrName\' : \'attrValue\'}, {toServer:true}))
		</div>
		Expected Result: {"attrName" : "attrValue"} -------------> should remain unchanged (no ERROR thrown)
		<hlayout>
			Actual Result: <label id="message4" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>

		<div>
			5. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f(\'message5\'), \'onFoo\', {\'\' : \'attrValueWithEmptyName\', \'attrName\' : \'attrValue\'}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f(\'message5\'), \'onFoo\', {\'\' : \'attrValueWithEmptyName\', \'attrName\' : \'attrValue\'}, {toServer:true}));
		</div>
		Expected Result: {"" : "attrValueWithEmptyName", "attrName" : "attrValue"} -------------> should remain unchanged
		<hlayout>
			Actual Result: <label id="message5" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>

	</vlayout>
</zk>`,
	);
	await t.click(
		Selector(() => jq(".z-button:contains(fire event):eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Actual Result)")
						.eq(0)
						.parent()
						.next()
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("plain string"), "");
	await t.click(
		Selector(() => jq(".z-button:contains(fire event):eq(1)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Actual Result)")
						.eq(1)
						.parent()
						.next()
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("attrValueWithEmptyName"), "");
	await t.click(
		Selector(() => jq(".z-button:contains(fire event):eq(2)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Actual Result)")
						.eq(2)
						.parent()
						.next()
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText('{"attrName":"attrValue"}'), "");
	await t.click(
		Selector(() => jq(".z-button:contains(fire event):eq(3)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Actual Result)")
						.eq(3)
						.parent()
						.next()
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText('{"attrName":"attrValue"}'), "");
	await t.click(
		Selector(() => jq(".z-button:contains(fire event):eq(4)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(Actual Result)")
						.eq(4)
						.parent()
						.next()
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText(
				'{"":"attrValueWithEmptyName","attrName":"attrValue"}',
			),
			"",
		);
});
