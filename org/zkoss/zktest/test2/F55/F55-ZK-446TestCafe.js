import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F55-ZK-446TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F55-ZK-446TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div><![CDATA[
					Test code: 
					<textbox instant="true" constraint="/[a-z]*/" />
				]]></div>
				<div>
					1. The onChange event should be fire upon typing (like onChanging).
				</div>
				<div>
					2. Both values (textbox and event) should be identical to the one in the textbox input.
				</div>
				<div>
					3. Value setting should respect constraint validation.
				</div>
				<div height="30px" />
				Input:
				<textbox id="tbx" instant="true" constraint="/[a-z]*/">
					<attribute name="onChange">
						lb.value = self.value;
						lb2.value = event.value;
						ib.value++;
					</attribute>
				</textbox>
				<div height="30px" />
				<div>
					onChange fired: <intbox id="ib" readonly="true" value="0" />
				</div>
				<div>
					Textbox value: <label id="lb" />
				</div>
				<div>
					Event value: <label id="lb2" />
				</div>
			</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tbx", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tbx", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("a b").wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
			"value should be identical",
		);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("ib", true).$n().value,
				)(),
			),
			"event should be fired if no error",
		);
	await t
		.expect(ztl.normalizeText("false"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-errorbox")[0])(),
			),
		);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tbx", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tbx", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("c d e").wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
			"value should be identical",
		);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("ib", true).$n().value,
				)(),
			),
			"event should be fired if no error",
		);
	await t
		.expect(ztl.normalizeText("false"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-errorbox")[0])(),
			),
		);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tbx", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tbx", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("A").wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
			"value should be identical",
		);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("ib", true).$n().value,
				)(),
			),
			"event should be fired if no error",
		);
	await t
		.expect(ztl.normalizeText("true"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-errorbox")[0])(),
			),
		);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tbx", true).$n().value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tbx", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tbx", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("b c").wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
			"value should be identical",
		);
	await t
		.expect(ztl.normalizeText("3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("ib", true).$n().value,
				)(),
			),
			"event should be fired if no error",
		);
	await t
		.expect(ztl.normalizeText("false"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-errorbox")[0])(),
			),
		);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("tbx", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("tbx", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3").wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb2", true).$n().innerHTML,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
			"value should be identical",
		);
	await t
		.expect(ztl.normalizeText("3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("ib", true).$n().value,
				)(),
			),
			"event should be fired if no error",
		);
	await t
		.expect(ztl.normalizeText("true"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => !!jq(".z-errorbox")[0])(),
			),
		);
});
