import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-actionTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-actionTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test of JavaScript Utilities">
<script><![CDATA[
var comm = {
	getData: function (args, start) {
		var len = args.length, data;
		if (len > start) {
			data = [];
			for (var j = start; j < len; ++j)
				data[j - start] = args[j];
		}
		return data;
	},
	sendUser: function (element) {
		zAu.send(new zk.Event(zk.Widget.$(element), \'onUser\', comm.getData(arguments, 1)));
	},
	sendEvent: function (element, evtnm) {
		zAu.send(new zk.Event(zk.Widget.$(element), evtnm, comm.getData(arguments, 2)));
	}
};

]]></script>
	<vbox>
You can click each link, then you should see that the label is the same as that link.
		<html onUser=\'l.value ="onUser "+org.zkoss.lang.Objects.toString(event.data)\'><![CDATA[
			<a id="a1" href="javascript:;" onclick="comm.sendUser(this);">onUser with null</a>
			<a id="a2"  href="javascript:;" onclick="comm.sendUser(this, \'One\');">onUser with One</a>
			<a id="a3" href="javascript:;" onclick="comm.sendUser(this, \'One\', \'Two\');">onUser with [One, Two]</a>
			<a id="a4" href="javascript:;" onclick="comm.sendEvent(this, \'onUser\', \'1\', \'2\');">onUser with [1, 2]</a>
		]]></html>
		<separator/>
		<label id="l"/>
	</vbox>
</window>`,
	);
	await t.click(Selector(() => jq("#a1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("onUser null"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l")).getValue())(),
			),
		);
	await t.click(Selector(() => jq("#a2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("onUser [One]"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l")).getValue())(),
			),
		);
	await t.click(Selector(() => jq("#a3")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("onUser [One, Two]"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l")).getValue())(),
			),
		);
	await t.click(Selector(() => jq("#a4")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("onUser [1, 2]"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l")).getValue())(),
			),
		);
});
