package com.example.app.presentation.screen.start.oauth

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import com.example.app.util.CLIENT_ID
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope

class GoogleOauth(
    private val context: Context,
    private val googleAuthLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    private val googleSignInClient: GoogleSignInClient by lazy { getGoogleClient() }

    fun requestGoogleLogin() {
        googleSignInClient.signOut()
        val signInIntent = googleSignInClient.signInIntent
        googleAuthLauncher.launch(signInIntent)
    }

    private fun getGoogleClient(): GoogleSignInClient {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestServerAuthCode(CLIENT_ID)  // todo : Google Oauth Failed..com.google.android.gms.common.api.ApiException: 10:
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context, googleSignInOption)
    }
}

var content = """
    <!doctype html>
<html lang="en-US" dir="ltr">

<head>
	<base href="https://accounts.google.com/v3/signin/">
	<meta name="referrer" content="origin">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style
		data-href="https://www.gstatic.com/_/mss/boq-identity/_/ss/k=boq-identity.AccountsSignInUi.Yps5vY2VtKQ.L.X.O/am=DoCfiInHBqD8A1gAIABQoAAAAAAAAAAAADSQJQQ/d=1/ed=1/rs=AOaEmlGiep7r8B2bj5kvqy6m0c79-34A1Q/m=identifierview,_b,_tp"
		nonce="2Q2GS9Pqql5ILT5cGsT2qw">
		c-wiz {
			contain: style
		}

		c-wiz>c-data {
			display: none
		}

		c-wiz.rETSD {
			contain: none
		}

		c-wiz.Ubi8Z {
			contain: layout style
		}

		@-webkit-keyframes quantumWizBoxInkSpread {
			0% {
				-webkit-transform: translate(-50%, -50%) scale(0.2);
				-webkit-transform: translate(-50%, -50%) scale(0.2);
				-ms-transform: translate(-50%, -50%) scale(0.2);
				-o-transform: translate(-50%, -50%) scale(0.2);
				transform: translate(-50%, -50%) scale(0.2)
			}

			to {
				-webkit-transform: translate(-50%, -50%) scale(2.2);
				-webkit-transform: translate(-50%, -50%) scale(2.2);
				-ms-transform: translate(-50%, -50%) scale(2.2);
				-o-transform: translate(-50%, -50%) scale(2.2);
				transform: translate(-50%, -50%) scale(2.2)
			}
		}

		@keyframes quantumWizBoxInkSpread {
			0% {
				-webkit-transform: translate(-50%, -50%) scale(0.2);
				-webkit-transform: translate(-50%, -50%) scale(0.2);
				-ms-transform: translate(-50%, -50%) scale(0.2);
				-o-transform: translate(-50%, -50%) scale(0.2);
				transform: translate(-50%, -50%) scale(0.2)
			}

			to {
				-webkit-transform: translate(-50%, -50%) scale(2.2);
				-webkit-transform: translate(-50%, -50%) scale(2.2);
				-ms-transform: translate(-50%, -50%) scale(2.2);
				-o-transform: translate(-50%, -50%) scale(2.2);
				transform: translate(-50%, -50%) scale(2.2)
			}
		}

		@-webkit-keyframes quantumWizIconFocusPulse {
			0% {
				-webkit-transform: translate(-50%, -50%) scale(1.5);
				-webkit-transform: translate(-50%, -50%) scale(1.5);
				-ms-transform: translate(-50%, -50%) scale(1.5);
				-o-transform: translate(-50%, -50%) scale(1.5);
				transform: translate(-50%, -50%) scale(1.5);
				opacity: 0
			}

			to {
				-webkit-transform: translate(-50%, -50%) scale(2);
				-webkit-transform: translate(-50%, -50%) scale(2);
				-ms-transform: translate(-50%, -50%) scale(2);
				-o-transform: translate(-50%, -50%) scale(2);
				transform: translate(-50%, -50%) scale(2);
				opacity: 1
			}
		}

		@keyframes quantumWizIconFocusPulse {
			0% {
				-webkit-transform: translate(-50%, -50%) scale(1.5);
				-webkit-transform: translate(-50%, -50%) scale(1.5);
				-ms-transform: translate(-50%, -50%) scale(1.5);
				-o-transform: translate(-50%, -50%) scale(1.5);
				transform: translate(-50%, -50%) scale(1.5);
				opacity: 0
			}

			to {
				-webkit-transform: translate(-50%, -50%) scale(2);
				-webkit-transform: translate(-50%, -50%) scale(2);
				-ms-transform: translate(-50%, -50%) scale(2);
				-o-transform: translate(-50%, -50%) scale(2);
				transform: translate(-50%, -50%) scale(2);
				opacity: 1
			}
		}

		@-webkit-keyframes quantumWizRadialInkSpread {
			0% {
				-webkit-transform: scale(1.5);
				-webkit-transform: scale(1.5);
				-ms-transform: scale(1.5);
				-o-transform: scale(1.5);
				transform: scale(1.5);
				opacity: 0
			}

			to {
				-webkit-transform: scale(2.5);
				-webkit-transform: scale(2.5);
				-ms-transform: scale(2.5);
				-o-transform: scale(2.5);
				transform: scale(2.5);
				opacity: 1
			}
		}

		@keyframes quantumWizRadialInkSpread {
			0% {
				-webkit-transform: scale(1.5);
				-webkit-transform: scale(1.5);
				-ms-transform: scale(1.5);
				-o-transform: scale(1.5);
				transform: scale(1.5);
				opacity: 0
			}

			to {
				-webkit-transform: scale(2.5);
				-webkit-transform: scale(2.5);
				-ms-transform: scale(2.5);
				-o-transform: scale(2.5);
				transform: scale(2.5);
				opacity: 1
			}
		}

		@-webkit-keyframes quantumWizRadialInkFocusPulse {
			0% {
				-webkit-transform: scale(2);
				-webkit-transform: scale(2);
				-ms-transform: scale(2);
				-o-transform: scale(2);
				transform: scale(2);
				opacity: 0
			}

			to {
				-webkit-transform: scale(2.5);
				-webkit-transform: scale(2.5);
				-ms-transform: scale(2.5);
				-o-transform: scale(2.5);
				transform: scale(2.5);
				opacity: 1
			}
		}

		@keyframes quantumWizRadialInkFocusPulse {
			0% {
				-webkit-transform: scale(2);
				-webkit-transform: scale(2);
				-ms-transform: scale(2);
				-o-transform: scale(2);
				transform: scale(2);
				opacity: 0
			}

			to {
				-webkit-transform: scale(2.5);
				-webkit-transform: scale(2.5);
				-ms-transform: scale(2.5);
				-o-transform: scale(2.5);
				transform: scale(2.5);
				opacity: 1
			}
		}

		.hZUije {
			border: 0
		}

		.hZUije.WS4XDd {
			max-height: 1.3333em;
			padding: 0 2px;
			vertical-align: middle;
			width: auto
		}

		.kHluYc {
			border: 0;
			object-fit: contain
		}

		.kHluYc.WS4XDd {
			max-height: 1.3333em;
			padding: 0 2px;
			vertical-align: middle;
			width: auto
		}

		.JnOM6e {
			background-color: transparent;
			border: none;
			border-radius: 4px;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			display: inline-block;
			font-size: 14px;
			height: 36px;
			letter-spacing: .15px;
			line-height: 34px;
			padding: 0 24px;
			position: relative;
			text-align: center
		}

		.JnOM6e:focus-visible {
			outline: none;
			position: relative
		}

		.JnOM6e:focus-visible::after {
			border: 2px solid rgb(24, 90, 188);
			border-radius: 6px;
			bottom: -4px;
			-webkit-box-shadow: 0 0 0 2px rgb(232, 240, 254);
			box-shadow: 0 0 0 2px rgb(232, 240, 254);
			content: "";
			left: -4px;
			position: absolute;
			right: -4px;
			top: -4px
		}

		.rDisVe:focus:not(:focus-visible),
		.GjFdVe:focus:not(:focus-visible) {
			-webkit-box-shadow: 0 1px 1px 0 rgba(66, 133, 244, .3), 0 1px 3px 1px rgba(66, 133, 244, .15);
			box-shadow: 0 1px 1px 0 rgba(66, 133, 244, .3), 0 1px 3px 1px rgba(66, 133, 244, .15)
		}

		.rDisVe:hover:not(:focus-visible),
		.GjFdVe:hover:not(:focus-visible) {
			-webkit-box-shadow: 0 1px 1px 0 rgba(66, 133, 244, .45), 0 1px 3px 1px rgba(66, 133, 244, .3);
			box-shadow: 0 1px 1px 0 rgba(66, 133, 244, .45), 0 1px 3px 1px rgba(66, 133, 244, .3)
		}

		.JnOM6e:disabled {
			pointer-events: none
		}

		.JnOM6e:hover {
			cursor: pointer
		}

		.JnOM6e.kTeh9 {
			line-height: 36px;
			text-decoration: none
		}

		.JnOM6e.eLNT1d {
			display: none
		}

		.rDisVe {
			background-color: rgb(26, 115, 232);
			color: #fff
		}

		.rDisVe:disabled {
			background-color: rgb(232, 234, 237);
			color: rgb(154, 160, 166)
		}

		.rDisVe:focus,
		.rDisVe:hover {
			background-color: rgb(24, 90, 188)
		}

		.GjFdVe {
			border: 1px solid rgb(218, 220, 224);
			color: rgb(26, 115, 232)
		}

		.GjFdVe:disabled {
			color: rgb(189, 193, 198)
		}

		.GjFdVe:active {
			background-color: rgb(174, 203, 250);
			color: rgb(23, 78, 166)
		}

		.GjFdVe:focus {
			background-color: rgb(232, 240, 254);
			border-color: rgb(24, 90, 188);
			color: rgb(23, 78, 166)
		}

		.GjFdVe:hover {
			background-color: rgb(232, 240, 254);
			color: rgb(23, 78, 166)
		}

		.KXbQ4b {
			color: rgb(26, 115, 232);
			min-width: 0;
			padding-left: 8px;
			padding-right: 8px
		}

		.KXbQ4b:disabled {
			color: rgb(189, 193, 198)
		}

		.KXbQ4b:active,
		.KXbQ4b:hover {
			color: rgb(24, 90, 188)
		}

		.KXbQ4b:active {
			background-color: rgba(26, 115, 232, .12)
		}

		.KXbQ4b:focus,
		.KXbQ4b:hover {
			background-color: rgba(26, 115, 232, .04)
		}

		.aN1Vld {
			margin: 16px 0;
			outline: none
		}

		.aN1Vld+.aN1Vld {
			margin-top: 24px
		}

		.aN1Vld:first-child {
			margin-top: 0
		}

		.aN1Vld:last-child {
			margin-bottom: 0
		}

		.fegW5d {
			border-radius: 8px;
			padding: 16px
		}

		.fegW5d>:first-child {
			margin-top: 0
		}

		.fegW5d>:last-child {
			margin-bottom: 0
		}

		.fegW5d .cySqRb,
		.fegW5d .yOnVIb {
			color: rgb(32, 33, 36)
		}

		.fegW5d.YFdWic .yOnVIb {
			color: rgb(95, 99, 104);
			margin-top: 4px;
			padding: 0
		}

		.fegW5d.YFdWic .wSQNd,
		.fegW5d.YFdWic .yOnVIb {
			margin-left: 64px;
			width: calc(100% - 64px)
		}

		.fegW5d.YFdWic:not(.S7S4N) .wSQNd {
			margin-left: 0;
			width: 0
		}

		.fegW5d:not(.S7S4N)>.yOnVIb {
			margin-top: 0
		}

		.fegW5d.sj692e {
			background: rgb(232, 240, 254)
		}

		.fegW5d.Xq8bDe {
			background: rgb(252, 232, 230)
		}

		.fegW5d.rNe0id {
			background: rgb(254, 247, 224)
		}

		.fegW5d.YFdWic {
			border: 1px solid rgb(218, 220, 224);
			min-height: 80px;
			position: relative
		}

		.fegW5d:not(.S7S4N) {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex
		}

		.aN1Vld.eLNT1d {
			display: none
		}

		.aN1Vld.RDPZE {
			opacity: .5;
			pointer-events: none
		}

		.aN1Vld.RDPZE .aN1Vld.RDPZE {
			opacity: 1
		}

		.wlrzMe {
			border: 1px solid rgb(218, 220, 224);
			border-radius: 8px;
			padding: 16px
		}

		.wlrzMe .EEiyWe {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-pack: end;
			-webkit-justify-content: flex-end;
			justify-content: flex-end;
			margin-top: 16px
		}

		.wlrzMe .EEiyWe .GjFdVe {
			margin-bottom: 0;
			margin-top: 0
		}

		.wSQNd:empty {
			display: none
		}

		.wSQNd>:first-child {
			margin-top: 0;
			padding-top: 0
		}

		.wSQNd>:last-child {
			margin-bottom: 0;
			padding-bottom: 0
		}

		.cySqRb {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			color: rgb(32, 33, 36);
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			font-size: 16px;
			font-weight: 500;
			letter-spacing: .1px;
			line-height: 1.4286;
			margin-bottom: 0;
			margin-top: 0;
			padding: 0
		}

		.zlrrr {
			color: rgb(95, 99, 104);
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			height: 20px;
			margin-right: 16px;
			width: 20px
		}

		.zlrrr .GxLRef {
			height: 100%;
			width: 100%
		}

		.fegW5d .zlrrr {
			margin-top: 0
		}

		.fegW5d.sj692e .zlrrr {
			color: rgb(25, 103, 210)
		}

		.fegW5d.Xq8bDe .zlrrr {
			color: rgb(197, 34, 31)
		}

		.fegW5d.rNe0id .zlrrr {
			color: rgb(234, 134, 0)
		}

		.fegW5d.YFdWic .zlrrr {
			height: 48px;
			left: 16px;
			position: absolute;
			top: 16px;
			width: 48px
		}

		.yOnVIb {
			margin: auto -24px;
			padding-left: 24px;
			padding-right: 24px;
			margin-bottom: 16px;
			margin-top: 10px
		}

		.wlrzMe .yOnVIb {
			margin-bottom: 0;
			margin-top: 16px
		}

		.yOnVIb>:first-child:not(section) {
			margin-top: 0;
			padding-top: 0
		}

		.yOnVIb>:last-child:not(section) {
			margin-bottom: 0;
			padding-bottom: 0
		}

		.wSQNd:empty+.yOnVIb {
			margin-top: 0
		}

		.yOnVIb:only-child {
			margin-bottom: 0;
			margin-top: 0
		}

		*,
		*:before,
		*:after {
			-webkit-box-sizing: inherit;
			box-sizing: inherit
		}

		html {
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			-webkit-tap-highlight-color: transparent
		}

		body,
		input,
		textarea,
		select,
		button {
			color: rgb(32, 33, 36);
			font-family: arial, sans-serif
		}

		body {
			background: #fff;
			direction: ltr;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: column;
			-webkit-flex-direction: column;
			flex-direction: column;
			font-size: 14px;
			line-height: 1.4286;
			margin: 0;
			min-height: 100vh;
			padding: 0;
			position: relative
		}

		@media all and (min-width:601px) {
			body {
				-webkit-justify-content: center;
				justify-content: center
			}
		}

		[data-style="heading"],
		.BDEI9 h2:not(.TrZEUc) {
			color: rgb(32, 33, 36);
			font-size: 16px;
			font-weight: 500;
			letter-spacing: 0.1px;
			line-height: 1.4286
		}

		.BDEI9 .fegW5d a:not(.TrZEUc),
		.BDEI9 .fegW5d button:not(.TrZEUc) {
			color: rgb(25, 103, 210)
		}

		.BDEI9 a {
			text-decoration: none
		}

		.BDEI9 a:not(.TrZEUc) {
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
			color: rgb(26, 115, 232);
			display: inline-block;
			font-weight: 500;
			letter-spacing: 0.25px;
			outline: 0;
			position: relative;
			z-index: 1
		}

		.BDEI9 button:not(.TrZEUc) {
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
			color: rgb(26, 115, 232);
			display: inline-block;
			font-weight: 500;
			letter-spacing: 0.25px;
			outline: 0;
			position: relative;
			z-index: 1;
			background-color: transparent;
			cursor: pointer;
			padding: 0;
			text-align: left;
			border: 0
		}

		.BDEI9 button::-moz-focus-inner {
			border: 0
		}

		.BDEI9 a:not(.TrZEUc):focus::after,
		.BDEI9 a:not(.TrZEUc):active::after,
		.BDEI9 button:not(.TrZEUc):focus::after,
		.BDEI9 button:not(.TrZEUc):active::after {
			background-color: rgba(26, 115, 232, 0.15);
			-webkit-border-radius: 2px;
			-moz-border-radius: 2px;
			border-radius: 2px;
			bottom: -2px;
			content: "";
			left: -3px;
			position: absolute;
			right: -3px;
			top: -2px;
			z-index: -1
		}

		.BDEI9 img:not(.TrZEUc) {
			border: 0;
			max-height: 1.3em;
			vertical-align: middle
		}

		@media all and (min-width:601px) {
			.BDEI9 {
				display: -webkit-box;
				display: -moz-box;
				display: -webkit-flex;
				display: -ms-flexbox;
				display: flex;
				-ms-flex-direction: column;
				-webkit-flex-direction: column;
				flex-direction: column;
				min-height: 100vh;
				position: relative
			}

			.BDEI9:before,
			.BDEI9:after {
				-webkit-box-flex: 1;
				box-flex: 1;
				-ms-flex-positive: 1;
				-webkit-flex-grow: 1;
				flex-grow: 1;
				content: "";
				height: 24px
			}

			.BDEI9:before {
				min-height: 30px
			}

			.BDEI9:after {
				min-height: 24px
			}

			.BDEI9.LZgQXe:after {
				min-height: 63.9996px
			}
		}

		.gEc4r {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			height: 24px;
			-webkit-justify-content: center;
			justify-content: center
		}

		.gEc4r.jlqJKb {
			height: auto;
			min-height: 24px;
			padding-top: 24px
		}

		.BivnM {
			-webkit-align-items: center;
			align-items: center;
			border-bottom: 1px solid #ccc;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			height: 36px;
			left: 0;
			padding: 0 16px;
			position: absolute;
			right: 0;
			top: 0
		}

		.BivnM .ji6sFc {
			height: 14px;
			margin-right: 12px
		}

		.O3jdWc {
			color: rgb(95, 99, 104);
			font-size: 14px;
			height: 14px;
			margin-top: -2px
		}

		.Zwk8S {
			display: block;
			height: 37px;
			width: 37px
		}

		.wFNE4e {
			color: rgb(26, 115, 232)
		}

		:root {
			--wf-tfs: calc(var(--c-tfs, 32)/16*1rem);
			--wf-tfs-bp2: calc(var(--c-tfs, 36)/16*1rem);
			--wf-tfs-bp3: calc(var(--c-tfs, 36)/16*1rem);
			--wf-tfs-bp5: calc(var(--c-tfs, 44)/16*1rem);
			--wf-stfs: calc(var(--c-stfs, 16)/16*1rem);
			--wf-stfs-bp5: calc(var(--c-stfs, 16)/16*1rem)
		}

		.Wf6lSd {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-pack: start;
			-webkit-justify-content: flex-start;
			justify-content: flex-start;
			height: 48px;
			height: var(--c-brsz, 48px)
		}

		.bEbGY {
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center
		}

		.njAxm {
			height: auto;
			padding-top: 24px;
			min-height: 48px;
			min-height: var(--c-brsz, 48px)
		}

		.no7ij {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			border-bottom: 1px solid #ccc;
			height: 36px;
			left: 0;
			padding: 0 16px;
			position: absolute;
			right: 0;
			top: 0
		}

		.WHUyzc {
			color: #444746;
			font-size: 14px;
			height: 14px;
			margin-top: -2px
		}

		.no7ij .PDfDtf {
			height: 14px;
			margin-right: 12px
		}

		.no7ij .th8JXc {
			display: block;
			height: 14px;
			position: relative;
			top: 1px;
			width: 14px
		}

		.D9CCrb {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.Qk3oof.WS4XDd {
			border: 0;
			max-height: 1.42857143em;
			padding: 0 2px;
			vertical-align: middle;
			width: auto
		}

		.uHLU0 {
			border: 0;
			-o-object-fit: contain;
			object-fit: contain
		}

		.uHLU0.WS4XDd {
			border: 0;
			max-height: 1.42857143em;
			padding: 0 2px;
			vertical-align: middle;
			width: auto
		}

		.dJRqtd {
			display: block;
			height: 48px;
			height: var(--c-brsz, 48px);
			width: 48px;
			width: var(--c-brsz, 48px)
		}

		.vOZun,
		.gomQac {
			padding-bottom: 3px;
			padding-top: 9px;
			margin-bottom: 0;
			margin-top: 0
		}

		.gomQac {
			margin: 0
		}

		.vOZun:empty {
			display: none
		}

		.dMNVAe,
		.FSdAW {
			padding-bottom: 3px;
			padding-top: 9px
		}

		.FSdAW {
			margin: 0
		}

		.dMNVAe:empty,
		.FSdAW:empty {
			display: none
		}

		@-webkit-keyframes mdc-ripple-fg-radius-in {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				-webkit-animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				-o-animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				-ms-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				-o-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1)
			}

			to {
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
			}
		}

		@keyframes mdc-ripple-fg-radius-in {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				-webkit-animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				-o-animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				animation-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				-ms-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				-o-transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1);
				transform: translate(var(--mdc-ripple-fg-translate-start, 0)) scale(1)
			}

			to {
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
				transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
			}
		}

		@-webkit-keyframes mdc-ripple-fg-opacity-in {
			0% {
				-webkit-animation-timing-function: linear;
				-webkit-animation-timing-function: linear;
				-o-animation-timing-function: linear;
				animation-timing-function: linear;
				opacity: 0
			}

			to {
				opacity: var(--mdc-ripple-fg-opacity, 0)
			}
		}

		@keyframes mdc-ripple-fg-opacity-in {
			0% {
				-webkit-animation-timing-function: linear;
				-webkit-animation-timing-function: linear;
				-o-animation-timing-function: linear;
				animation-timing-function: linear;
				opacity: 0
			}

			to {
				opacity: var(--mdc-ripple-fg-opacity, 0)
			}
		}

		@-webkit-keyframes mdc-ripple-fg-opacity-out {
			0% {
				-webkit-animation-timing-function: linear;
				-webkit-animation-timing-function: linear;
				-o-animation-timing-function: linear;
				animation-timing-function: linear;
				opacity: var(--mdc-ripple-fg-opacity, 0)
			}

			to {
				opacity: 0
			}
		}

		@keyframes mdc-ripple-fg-opacity-out {
			0% {
				-webkit-animation-timing-function: linear;
				-webkit-animation-timing-function: linear;
				-o-animation-timing-function: linear;
				animation-timing-function: linear;
				opacity: var(--mdc-ripple-fg-opacity, 0)
			}

			to {
				opacity: 0
			}
		}

		.VfPpkd-ksKsZd-XxIAqe {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity;
			position: relative;
			outline: none;
			overflow: hidden
		}

		.VfPpkd-ksKsZd-XxIAqe::before,
		.VfPpkd-ksKsZd-XxIAqe::after {
			position: absolute;
			-webkit-border-radius: 50%;
			-moz-border-radius: 50%;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		.VfPpkd-ksKsZd-XxIAqe::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		.VfPpkd-ksKsZd-XxIAqe::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			-o-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf::after {
			-webkit-animation: mdc-ripple-fg-opacity-out 150ms;
			-webkit-animation: mdc-ripple-fg-opacity-out 150ms;
			-o-animation: mdc-ripple-fg-opacity-out 150ms;
			animation: mdc-ripple-fg-opacity-out 150ms;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-ksKsZd-XxIAqe::before,
		.VfPpkd-ksKsZd-XxIAqe::after {
			top: -webkit-calc(50% - 100%);
			top: -moz-calc(50% - 100%);
			top: calc(50% - 100%);
			left: -webkit-calc(50% - 100%);
			left: -moz-calc(50% - 100%);
			left: calc(50% - 100%);
			width: 200%;
			height: 200%
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-ksKsZd-XxIAqe[data-mdc-ripple-is-unbounded],
		.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd {
			overflow: visible
		}

		.VfPpkd-ksKsZd-XxIAqe[data-mdc-ripple-is-unbounded]::before,
		.VfPpkd-ksKsZd-XxIAqe[data-mdc-ripple-is-unbounded]::after,
		.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd::before,
		.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd::after {
			top: -webkit-calc(50% - 50%);
			top: -moz-calc(50% - 50%);
			top: calc(50% - 50%);
			left: -webkit-calc(50% - 50%);
			left: -moz-calc(50% - 50%);
			left: calc(50% - 50%);
			width: 100%;
			height: 100%
		}

		.VfPpkd-ksKsZd-XxIAqe[data-mdc-ripple-is-unbounded].VfPpkd-ksKsZd-mWPk3d::before,
		.VfPpkd-ksKsZd-XxIAqe[data-mdc-ripple-is-unbounded].VfPpkd-ksKsZd-mWPk3d::after,
		.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd.VfPpkd-ksKsZd-mWPk3d::before,
		.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd.VfPpkd-ksKsZd-mWPk3d::after {
			top: var(--mdc-ripple-top, calc(50% - 50%));
			left: var(--mdc-ripple-left, calc(50% - 50%));
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-ksKsZd-XxIAqe[data-mdc-ripple-is-unbounded].VfPpkd-ksKsZd-mWPk3d::after,
		.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd.VfPpkd-ksKsZd-mWPk3d::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-ksKsZd-XxIAqe::before,
		.VfPpkd-ksKsZd-XxIAqe::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, #000)
		}

		.VfPpkd-ksKsZd-XxIAqe:hover::before,
		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, 0.04)
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe::before,
		.VfPpkd-ksKsZd-XxIAqe:not(.VfPpkd-ksKsZd-mWPk3d):focus::before {
			-webkit-transition-duration: 75ms;
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, 0.12)
		}

		.VfPpkd-ksKsZd-XxIAqe:not(.VfPpkd-ksKsZd-mWPk3d)::after {
			-webkit-transition: opacity 150ms linear;
			-webkit-transition: opacity 150ms linear;
			-o-transition: opacity 150ms linear;
			transition: opacity 150ms linear
		}

		.VfPpkd-ksKsZd-XxIAqe:not(.VfPpkd-ksKsZd-mWPk3d):active::after {
			-webkit-transition-duration: 75ms;
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-ksKsZd-XxIAqe.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-dgl2Hf-ppHlrf-sM5MNb {
			display: inline
		}

		.VfPpkd-Bz112c-LgbsSe {
			font-size: 24px;
			width: 48px;
			height: 48px;
			padding: 12px
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-Bz112c-LgbsSe-OWXEXe-e5LLRc-SxQuSe .VfPpkd-Bz112c-Jh9lGc {
			width: 40px;
			height: 40px;
			margin-top: 4px;
			margin-bottom: 4px;
			margin-right: 4px;
			margin-left: 4px
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-Bz112c-LgbsSe-OWXEXe-e5LLRc-SxQuSe .VfPpkd-Bz112c-J1Ukfc-LhBDec {
			max-height: 40px;
			max-width: 40px
		}

		.VfPpkd-Bz112c-LgbsSe:disabled {
			color: rgba(0, 0, 0, .38);
			color: var(--mdc-theme-text-disabled-on-light, rgba(0, 0, 0, .38))
		}

		.VfPpkd-Bz112c-LgbsSe svg,
		.VfPpkd-Bz112c-LgbsSe img {
			width: 24px;
			height: 24px
		}

		.VfPpkd-Bz112c-LgbsSe {
			display: inline-block;
			position: relative;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			border: none;
			outline: none;
			background-color: transparent;
			fill: currentColor;
			color: inherit;
			text-decoration: none;
			cursor: pointer;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			z-index: 0;
			overflow: visible
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-RLmnJb {
			position: absolute;
			top: 50%;
			height: 48px;
			left: 50%;
			width: 48px;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%)
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Bz112c-J1Ukfc-LhBDec,
			.VfPpkd-Bz112c-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Bz112c-J1Ukfc-LhBDec {
				display: block
			}
		}

		.VfPpkd-Bz112c-LgbsSe:disabled {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-Bz112c-LgbsSe[hidden] {
			display: none
		}

		.VfPpkd-Bz112c-LgbsSe-OWXEXe-KVuj8d-Q3DXx {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center
		}

		.VfPpkd-Bz112c-J1Ukfc-LhBDec {
			pointer-events: none;
			border: 2px solid transparent;
			border-radius: 6px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: 100%;
			width: 100%;
			display: none
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-Bz112c-J1Ukfc-LhBDec {
				border-color: CanvasText
			}
		}

		.VfPpkd-Bz112c-J1Ukfc-LhBDec::after {
			content: "";
			border: 2px solid transparent;
			border-radius: 8px;
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-Bz112c-J1Ukfc-LhBDec::after {
				border-color: CanvasText
			}
		}

		.VfPpkd-Bz112c-kBDsod {
			display: inline-block
		}

		.VfPpkd-Bz112c-kBDsod.VfPpkd-Bz112c-kBDsod-OWXEXe-IT5dJd,
		.VfPpkd-Bz112c-LgbsSe-OWXEXe-IT5dJd .VfPpkd-Bz112c-kBDsod {
			display: none
		}

		.VfPpkd-Bz112c-LgbsSe-OWXEXe-IT5dJd .VfPpkd-Bz112c-kBDsod.VfPpkd-Bz112c-kBDsod-OWXEXe-IT5dJd {
			display: inline-block
		}

		.VfPpkd-Bz112c-mRLv6 {
			height: 100%;
			left: 0;
			outline: none;
			position: absolute;
			top: 0;
			width: 100%
		}

		.VfPpkd-Bz112c-LgbsSe {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Bz112c-Jh9lGc::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Bz112c-Jh9lGc::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-Bz112c-Jh9lGc::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-Bz112c-Jh9lGc::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-Bz112c-Jh9lGc::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::after {
			top: 0;
			left: 0;
			width: 100%;
			height: 100%
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Bz112c-Jh9lGc::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0);
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Bz112c-Jh9lGc::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, #000)
		}

		.VfPpkd-Bz112c-LgbsSe:hover .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Bz112c-Jh9lGc::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Bz112c-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-Bz112c-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Bz112c-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-Bz112c-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Bz112c-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.VfPpkd-Bz112c-LgbsSe.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-Bz112c-LgbsSe:disabled:hover .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Bz112c-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.VfPpkd-Bz112c-LgbsSe:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Bz112c-Jh9lGc::before,
		.VfPpkd-Bz112c-LgbsSe:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Bz112c-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.VfPpkd-Bz112c-LgbsSe:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Bz112c-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-Bz112c-LgbsSe:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Bz112c-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.VfPpkd-Bz112c-LgbsSe:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.VfPpkd-Bz112c-LgbsSe .VfPpkd-Bz112c-Jh9lGc {
			height: 100%;
			left: 0;
			pointer-events: none;
			position: absolute;
			top: 0;
			width: 100%;
			z-index: -1
		}

		.VfPpkd-LgbsSe {
			position: relative;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			min-width: 64px;
			border: none;
			outline: none;
			line-height: inherit;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			-webkit-appearance: none;
			overflow: visible;
			vertical-align: middle;
			background: transparent
		}

		.VfPpkd-LgbsSe .VfPpkd-BFbNVe-bF1uUb {
			width: 100%;
			height: 100%;
			top: 0;
			left: 0
		}

		.VfPpkd-LgbsSe::-moz-focus-inner {
			padding: 0;
			border: 0
		}

		.VfPpkd-LgbsSe:active {
			outline: none
		}

		.VfPpkd-LgbsSe:hover {
			cursor: pointer
		}

		.VfPpkd-LgbsSe:disabled {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-LgbsSe[hidden] {
			display: none
		}

		.VfPpkd-LgbsSe .VfPpkd-kBDsod {
			margin-left: 0;
			margin-right: 8px;
			display: inline-block;
			position: relative;
			vertical-align: top
		}

		[dir=rtl] .VfPpkd-LgbsSe .VfPpkd-kBDsod,
		.VfPpkd-LgbsSe .VfPpkd-kBDsod[dir=rtl] {
			margin-left: 8px;
			margin-right: 0
		}

		.VfPpkd-LgbsSe .VfPpkd-UdE5de-uDEFge {
			font-size: 0;
			position: absolute;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			top: 50%;
			left: 50%;
			line-height: normal
		}

		.VfPpkd-LgbsSe .VfPpkd-vQzf8d {
			position: relative
		}

		.VfPpkd-LgbsSe .VfPpkd-J1Ukfc-LhBDec {
			pointer-events: none;
			border: 2px solid transparent;
			border-radius: 6px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px);
			display: none
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-LgbsSe .VfPpkd-J1Ukfc-LhBDec {
				border-color: CanvasText
			}
		}

		.VfPpkd-LgbsSe .VfPpkd-J1Ukfc-LhBDec::after {
			content: "";
			border: 2px solid transparent;
			border-radius: 8px;
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-LgbsSe .VfPpkd-J1Ukfc-LhBDec::after {
				border-color: CanvasText
			}
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-J1Ukfc-LhBDec,
			.VfPpkd-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-J1Ukfc-LhBDec {
				display: block
			}
		}

		.VfPpkd-LgbsSe .VfPpkd-RLmnJb {
			position: absolute;
			top: 50%;
			height: 48px;
			left: 0;
			right: 0;
			-webkit-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			-o-transform: translateY(-50%);
			transform: translateY(-50%)
		}

		.VfPpkd-vQzf8d+.VfPpkd-kBDsod {
			margin-left: 8px;
			margin-right: 0
		}

		[dir=rtl] .VfPpkd-vQzf8d+.VfPpkd-kBDsod,
		.VfPpkd-vQzf8d+.VfPpkd-kBDsod[dir=rtl] {
			margin-left: 0;
			margin-right: 8px
		}

		svg.VfPpkd-kBDsod {
			fill: currentColor
		}

		.VfPpkd-LgbsSe-OWXEXe-dgl2Hf {
			margin-top: 6px;
			margin-bottom: 6px
		}

		.VfPpkd-LgbsSe {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			text-decoration: none
		}

		.VfPpkd-LgbsSe {
			padding: 0 8px 0 8px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ {
			-webkit-transition: -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: box-shadow .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			padding: 0 16px 0 16px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-Bz112c-UbuQg {
			padding: 0 12px 0 16px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-Bz112c-M1Soyc {
			padding: 0 16px 0 12px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb {
			-webkit-transition: -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: box-shadow .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			padding: 0 16px 0 16px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb.VfPpkd-LgbsSe-OWXEXe-Bz112c-UbuQg {
			padding: 0 12px 0 16px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb.VfPpkd-LgbsSe-OWXEXe-Bz112c-M1Soyc {
			padding: 0 16px 0 12px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc {
			border-style: solid;
			-webkit-transition: border .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: border .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1)
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-Jh9lGc {
			border-style: solid;
			border-color: transparent
		}

		.VfPpkd-LgbsSe {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1
		}

		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::after {
			z-index: 0
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Jh9lGc::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Jh9lGc::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-Jh9lGc::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-Jh9lGc::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-Jh9lGc::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::after {
			top: -50%;
			left: -50%;
			width: 200%;
			height: 200%
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d .VfPpkd-Jh9lGc::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-Jh9lGc {
			position: absolute;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			overflow: hidden;
			z-index: 0;
			top: 0;
			left: 0;
			bottom: 0;
			right: 0
		}

		.VfPpkd-LgbsSe {
			font-family: Roboto, sans-serif;
			font-size: .875rem;
			letter-spacing: .0892857143em;
			font-weight: 500;
			text-transform: uppercase;
			height: 36px;
			border-radius: 4px
		}

		.VfPpkd-LgbsSe:not(:disabled) {
			color: #6200ee
		}

		.VfPpkd-LgbsSe:disabled {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-LgbsSe .VfPpkd-kBDsod {
			font-size: 1.125rem;
			width: 1.125rem;
			height: 1.125rem
		}

		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc::after {
			background-color: #6200ee
		}

		.VfPpkd-LgbsSe:hover .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12
		}

		.VfPpkd-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-LgbsSe:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12
		}

		.VfPpkd-LgbsSe.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-text-button-pressed-state-layer-opacity, 0.12)
		}

		.VfPpkd-LgbsSe .VfPpkd-Jh9lGc {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe .VfPpkd-J1Ukfc-LhBDec {
			border-radius: 2px
		}

		.VfPpkd-LgbsSe .VfPpkd-J1Ukfc-LhBDec::after {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ {
			font-family: Roboto, sans-serif;
			font-size: .875rem;
			letter-spacing: .0892857143em;
			font-weight: 500;
			text-transform: uppercase;
			height: 36px;
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:not(:disabled) {
			background-color: #6200ee
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:disabled {
			background-color: rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:not(:disabled) {
			color: #fff
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:disabled {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ .VfPpkd-kBDsod {
			font-size: 1.125rem;
			width: 1.125rem;
			height: 1.125rem
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-k8QpJ .VfPpkd-Jh9lGc::after {
			background-color: #fff
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:hover .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .08
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-filled-button-pressed-state-layer-opacity, 0.24)
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ .VfPpkd-Jh9lGc {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ .VfPpkd-J1Ukfc-LhBDec {
			border-radius: 2px
		}

		.VfPpkd-LgbsSe-OWXEXe-k8QpJ .VfPpkd-J1Ukfc-LhBDec::after {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb {
			font-family: Roboto, sans-serif;
			font-size: .875rem;
			letter-spacing: .0892857143em;
			font-weight: 500;
			text-transform: uppercase;
			height: 36px;
			border-radius: 4px;
			-webkit-box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .2), 0 2px 2px 0 rgba(0, 0, 0, .14), 0 1px 5px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .2), 0 2px 2px 0 rgba(0, 0, 0, .14), 0 1px 5px 0 rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(:disabled) {
			background-color: #6200ee
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:disabled {
			background-color: rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(:disabled) {
			color: #fff
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:disabled {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb .VfPpkd-kBDsod {
			font-size: 1.125rem;
			width: 1.125rem;
			height: 1.125rem
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-MV7yeb .VfPpkd-Jh9lGc::after {
			background-color: #fff
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:hover .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-MV7yeb.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .08
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-protected-button-pressed-state-layer-opacity, 0.24)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb .VfPpkd-Jh9lGc {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb .VfPpkd-J1Ukfc-LhBDec {
			border-radius: 2px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb .VfPpkd-J1Ukfc-LhBDec::after {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe,
		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(.VfPpkd-ksKsZd-mWPk3d):focus {
			-webkit-box-shadow: 0 2px 4px -1px rgba(0, 0, 0, .2), 0 4px 5px 0 rgba(0, 0, 0, .14), 0 1px 10px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 2px 4px -1px rgba(0, 0, 0, .2), 0 4px 5px 0 rgba(0, 0, 0, .14), 0 1px 10px 0 rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:hover {
			-webkit-box-shadow: 0 2px 4px -1px rgba(0, 0, 0, .2), 0 4px 5px 0 rgba(0, 0, 0, .14), 0 1px 10px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 2px 4px -1px rgba(0, 0, 0, .2), 0 4px 5px 0 rgba(0, 0, 0, .14), 0 1px 10px 0 rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:not(:disabled):active {
			-webkit-box-shadow: 0 5px 5px -3px rgba(0, 0, 0, .2), 0 8px 10px 1px rgba(0, 0, 0, .14), 0 3px 14px 2px rgba(0, 0, 0, .12);
			box-shadow: 0 5px 5px -3px rgba(0, 0, 0, .2), 0 8px 10px 1px rgba(0, 0, 0, .14), 0 3px 14px 2px rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-MV7yeb:disabled {
			-webkit-box-shadow: 0 0 0 0 rgba(0, 0, 0, .2), 0 0 0 0 rgba(0, 0, 0, .14), 0 0 0 0 rgba(0, 0, 0, .12);
			box-shadow: 0 0 0 0 rgba(0, 0, 0, .2), 0 0 0 0 rgba(0, 0, 0, .14), 0 0 0 0 rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc {
			font-family: Roboto, sans-serif;
			font-size: .875rem;
			letter-spacing: .0892857143em;
			font-weight: 500;
			text-transform: uppercase;
			height: 36px;
			border-radius: 4px;
			padding: 0 15px 0 15px;
			border-width: 1px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:not(:disabled) {
			color: #6200ee
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:disabled {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-kBDsod {
			font-size: 1.125rem;
			width: 1.125rem;
			height: 1.125rem
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-Jh9lGc::after {
			background-color: #6200ee
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:hover .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-INsAgc.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.VfPpkd-LgbsSe-OWXEXe-INsAgc:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-outlined-button-pressed-state-layer-opacity, 0.12)
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-Jh9lGc {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-J1Ukfc-LhBDec {
			border-radius: 2px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-J1Ukfc-LhBDec::after {
			border-radius: 4px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:not(:disabled) {
			border-color: rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc:disabled {
			border-color: rgba(0, 0, 0, .12)
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc.VfPpkd-LgbsSe-OWXEXe-Bz112c-UbuQg {
			padding: 0 11px 0 15px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc.VfPpkd-LgbsSe-OWXEXe-Bz112c-M1Soyc {
			padding: 0 15px 0 11px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-Jh9lGc {
			top: -1px;
			left: -1px;
			bottom: -1px;
			right: -1px;
			border-width: 1px
		}

		.VfPpkd-LgbsSe-OWXEXe-INsAgc .VfPpkd-RLmnJb {
			left: -1px;
			width: calc(100% + 2px)
		}

		.nCP5yc {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			font-size: .875rem;
			letter-spacing: .0107142857em;
			font-weight: 500;
			text-transform: none;
			-webkit-transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.nCP5yc .VfPpkd-Jh9lGc {
			height: 100%;
			position: absolute;
			overflow: hidden;
			width: 100%;
			z-index: 0
		}

		.nCP5yc:not(:disabled) {
			background-color: rgb(26, 115, 232);
			background-color: var(--gm-fillbutton-container-color, rgb(26, 115, 232))
		}

		.nCP5yc:not(:disabled) {
			color: #fff;
			color: var(--gm-fillbutton-ink-color, #fff)
		}

		.nCP5yc:disabled {
			background-color: rgba(60, 64, 67, .12);
			background-color: var(--gm-fillbutton-disabled-container-color, rgba(60, 64, 67, .12))
		}

		.nCP5yc:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-fillbutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.nCP5yc .VfPpkd-Jh9lGc::before,
		.nCP5yc .VfPpkd-Jh9lGc::after {
			background-color: rgb(32, 33, 36);
			background-color: var(--gm-fillbutton-state-color, rgb(32, 33, 36))
		}

		.nCP5yc:hover .VfPpkd-Jh9lGc::before,
		.nCP5yc.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .16;
			opacity: var(--mdc-ripple-hover-opacity, .16)
		}

		.nCP5yc.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.nCP5yc:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-focus-opacity, .24)
		}

		.nCP5yc:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.nCP5yc:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-press-opacity, .2)
		}

		.nCP5yc.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.2)
		}

		.nCP5yc .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.nCP5yc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.nCP5yc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #fff
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.nCP5yc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.nCP5yc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.nCP5yc:hover {
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			-webkit-box-shadow: 0 1px 2px 0 var(--gm-fillbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 1px 3px 1px var(--gm-fillbutton-ambientshadow-color, rgba(60, 64, 67, .15));
			box-shadow: 0 1px 2px 0 var(--gm-fillbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 1px 3px 1px var(--gm-fillbutton-ambientshadow-color, rgba(60, 64, 67, .15))
		}

		.nCP5yc:hover .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.nCP5yc:active {
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 2px 6px 2px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 2px 6px 2px rgba(60, 64, 67, .15);
			-webkit-box-shadow: 0 1px 2px 0 var(--gm-fillbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 2px 6px 2px var(--gm-fillbutton-ambientshadow-color, rgba(60, 64, 67, .15));
			box-shadow: 0 1px 2px 0 var(--gm-fillbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 2px 6px 2px var(--gm-fillbutton-ambientshadow-color, rgba(60, 64, 67, .15))
		}

		.nCP5yc:active .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.nCP5yc:disabled {
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.nCP5yc:disabled:hover .VfPpkd-Jh9lGc::before,
		.nCP5yc:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.nCP5yc:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.nCP5yc:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.nCP5yc:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.nCP5yc:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.nCP5yc:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.nCP5yc:disabled .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.Rj2Mlf {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			font-size: .875rem;
			letter-spacing: .0107142857em;
			font-weight: 500;
			text-transform: none;
			-webkit-transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.Rj2Mlf .VfPpkd-Jh9lGc {
			height: 100%;
			position: absolute;
			overflow: hidden;
			width: 100%;
			z-index: 0
		}

		.Rj2Mlf:not(:disabled) {
			color: rgb(26, 115, 232);
			color: var(--gm-hairlinebutton-ink-color, rgb(26, 115, 232))
		}

		.Rj2Mlf:not(:disabled) {
			border-color: rgb(218, 220, 224);
			border-color: var(--gm-hairlinebutton-outline-color, rgb(218, 220, 224))
		}

		.Rj2Mlf:not(:disabled):hover {
			border-color: rgb(218, 220, 224);
			border-color: var(--gm-hairlinebutton-outline-color, rgb(218, 220, 224))
		}

		.Rj2Mlf:not(:disabled).VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe,
		.Rj2Mlf:not(:disabled):not(.VfPpkd-ksKsZd-mWPk3d):focus {
			border-color: rgb(23, 78, 166);
			border-color: var(--gm-hairlinebutton-outline-color--stateful, rgb(23, 78, 166))
		}

		.Rj2Mlf:not(:disabled):active,
		.Rj2Mlf:not(:disabled):focus:active {
			border-color: rgb(218, 220, 224);
			border-color: var(--gm-hairlinebutton-outline-color, rgb(218, 220, 224))
		}

		.Rj2Mlf:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-hairlinebutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.Rj2Mlf:disabled {
			border-color: rgba(60, 64, 67, .12);
			border-color: var(--gm-hairlinebutton-disabled-outline-color, rgba(60, 64, 67, .12))
		}

		.Rj2Mlf:hover:not(:disabled),
		.Rj2Mlf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe:not(:disabled),
		.Rj2Mlf:not(.VfPpkd-ksKsZd-mWPk3d):focus:not(:disabled),
		.Rj2Mlf:active:not(:disabled) {
			color: rgb(23, 78, 166);
			color: var(--gm-hairlinebutton-ink-color--stateful, rgb(23, 78, 166))
		}

		.Rj2Mlf .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.Rj2Mlf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.Rj2Mlf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: rgb(26, 115, 232)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.Rj2Mlf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.Rj2Mlf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.Rj2Mlf .VfPpkd-Jh9lGc::before,
		.Rj2Mlf .VfPpkd-Jh9lGc::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--gm-hairlinebutton-state-color, rgb(26, 115, 232))
		}

		.Rj2Mlf:hover .VfPpkd-Jh9lGc::before,
		.Rj2Mlf.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.Rj2Mlf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.Rj2Mlf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.Rj2Mlf:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.Rj2Mlf:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.Rj2Mlf.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.Rj2Mlf:disabled:hover .VfPpkd-Jh9lGc::before,
		.Rj2Mlf:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.Rj2Mlf:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.Rj2Mlf:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.Rj2Mlf:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.Rj2Mlf:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.Rj2Mlf:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.b9hyVd {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			font-size: .875rem;
			letter-spacing: .0107142857em;
			font-weight: 500;
			text-transform: none;
			-webkit-transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			border-width: 0;
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			-webkit-box-shadow: 0 1px 2px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 1px 3px 1px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15));
			box-shadow: 0 1px 2px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 1px 3px 1px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15))
		}

		.b9hyVd .VfPpkd-Jh9lGc {
			height: 100%;
			position: absolute;
			overflow: hidden;
			width: 100%;
			z-index: 0
		}

		.b9hyVd:not(:disabled) {
			background-color: #fff;
			background-color: var(--gm-protectedbutton-container-color, #fff)
		}

		.b9hyVd:not(:disabled) {
			color: rgb(26, 115, 232);
			color: var(--gm-protectedbutton-ink-color, rgb(26, 115, 232))
		}

		.b9hyVd:disabled {
			background-color: rgba(60, 64, 67, .12);
			background-color: var(--gm-protectedbutton-disabled-container-color, rgba(60, 64, 67, .12))
		}

		.b9hyVd:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-protectedbutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.b9hyVd:hover:not(:disabled),
		.b9hyVd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe:not(:disabled),
		.b9hyVd:not(.VfPpkd-ksKsZd-mWPk3d):focus:not(:disabled),
		.b9hyVd:active:not(:disabled) {
			color: rgb(23, 78, 166);
			color: var(--gm-protectedbutton-ink-color--stateful, rgb(23, 78, 166))
		}

		.b9hyVd .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.b9hyVd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.b9hyVd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: rgb(26, 115, 232)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.b9hyVd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.b9hyVd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.b9hyVd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe,
		.b9hyVd:not(.VfPpkd-ksKsZd-mWPk3d):focus {
			border-width: 0;
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			-webkit-box-shadow: 0 1px 2px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 1px 3px 1px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15));
			box-shadow: 0 1px 2px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 1px 3px 1px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15))
		}

		.b9hyVd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-BFbNVe-bF1uUb,
		.b9hyVd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.b9hyVd:hover {
			border-width: 0;
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 2px 6px 2px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 2px 6px 2px rgba(60, 64, 67, .15);
			-webkit-box-shadow: 0 1px 2px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 2px 6px 2px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15));
			box-shadow: 0 1px 2px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 2px 6px 2px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15))
		}

		.b9hyVd:hover .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.b9hyVd:not(:disabled):active {
			border-width: 0;
			-webkit-box-shadow: 0 1px 3px 0 rgba(60, 64, 67, .3), 0 4px 8px 3px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 3px 0 rgba(60, 64, 67, .3), 0 4px 8px 3px rgba(60, 64, 67, .15);
			-webkit-box-shadow: 0 1px 3px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 4px 8px 3px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15));
			box-shadow: 0 1px 3px 0 var(--gm-protectedbutton-keyshadow-color, rgba(60, 64, 67, .3)), 0 4px 8px 3px var(--gm-protectedbutton-ambientshadow-color, rgba(60, 64, 67, .15))
		}

		.b9hyVd:not(:disabled):active .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.b9hyVd .VfPpkd-Jh9lGc::before,
		.b9hyVd .VfPpkd-Jh9lGc::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--gm-protectedbutton-state-color, rgb(26, 115, 232))
		}

		.b9hyVd:hover .VfPpkd-Jh9lGc::before,
		.b9hyVd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.b9hyVd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.b9hyVd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.b9hyVd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.b9hyVd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.b9hyVd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.b9hyVd:disabled {
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.b9hyVd:disabled .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.b9hyVd:disabled:hover .VfPpkd-Jh9lGc::before,
		.b9hyVd:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.b9hyVd:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.b9hyVd:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.b9hyVd:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.b9hyVd:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.b9hyVd:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.Kjnxrf {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			font-size: .875rem;
			letter-spacing: .0107142857em;
			font-weight: 500;
			text-transform: none;
			-webkit-transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			transition: border .28s cubic-bezier(.4, 0, .2, 1), box-shadow .28s cubic-bezier(.4, 0, .2, 1), -webkit-box-shadow .28s cubic-bezier(.4, 0, .2, 1);
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.Kjnxrf .VfPpkd-Jh9lGc {
			height: 100%;
			position: absolute;
			overflow: hidden;
			width: 100%;
			z-index: 0
		}

		.Kjnxrf:not(:disabled) {
			background-color: rgb(232, 240, 254)
		}

		.Kjnxrf:not(:disabled) {
			color: rgb(25, 103, 210)
		}

		.Kjnxrf:disabled {
			background-color: rgba(60, 64, 67, .12)
		}

		.Kjnxrf:disabled {
			color: rgba(60, 64, 67, .38)
		}

		.Kjnxrf:hover:not(:disabled),
		.Kjnxrf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe:not(:disabled),
		.Kjnxrf:not(.VfPpkd-ksKsZd-mWPk3d):focus:not(:disabled),
		.Kjnxrf:active:not(:disabled) {
			color: rgb(23, 78, 166)
		}

		.Kjnxrf .VfPpkd-Jh9lGc::before,
		.Kjnxrf .VfPpkd-Jh9lGc::after {
			background-color: rgb(25, 103, 210);
			background-color: var(--mdc-ripple-color, rgb(25, 103, 210))
		}

		.Kjnxrf:hover .VfPpkd-Jh9lGc::before,
		.Kjnxrf.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.Kjnxrf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.Kjnxrf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.Kjnxrf:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.Kjnxrf:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.Kjnxrf.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		.Kjnxrf .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.Kjnxrf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.Kjnxrf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: rgb(25, 103, 210)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.Kjnxrf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.Kjnxrf .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.Kjnxrf:hover {
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 1px 3px 1px rgba(60, 64, 67, .15)
		}

		.Kjnxrf:hover .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.Kjnxrf:not(:disabled):active {
			-webkit-box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 2px 6px 2px rgba(60, 64, 67, .15);
			box-shadow: 0 1px 2px 0 rgba(60, 64, 67, .3), 0 2px 6px 2px rgba(60, 64, 67, .15)
		}

		.Kjnxrf:not(:disabled):active .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.Kjnxrf:disabled {
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.Kjnxrf:disabled .VfPpkd-BFbNVe-bF1uUb {
			opacity: 0
		}

		.Kjnxrf:disabled:hover .VfPpkd-Jh9lGc::before,
		.Kjnxrf:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.Kjnxrf:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.Kjnxrf:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.Kjnxrf:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.Kjnxrf:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.Kjnxrf:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.ksBjEc {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			font-size: .875rem;
			letter-spacing: .0107142857em;
			font-weight: 500;
			text-transform: none
		}

		.ksBjEc .VfPpkd-Jh9lGc {
			height: 100%;
			position: absolute;
			overflow: hidden;
			width: 100%;
			z-index: 0
		}

		.ksBjEc:not(:disabled) {
			background-color: transparent
		}

		.ksBjEc:not(:disabled) {
			color: rgb(26, 115, 232);
			color: var(--gm-colortextbutton-ink-color, rgb(26, 115, 232))
		}

		.ksBjEc:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-colortextbutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.ksBjEc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.ksBjEc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: rgb(26, 115, 232)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.ksBjEc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.ksBjEc .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.ksBjEc:hover:not(:disabled),
		.ksBjEc.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe:not(:disabled),
		.ksBjEc:not(.VfPpkd-ksKsZd-mWPk3d):focus:not(:disabled),
		.ksBjEc:active:not(:disabled) {
			color: rgb(23, 78, 166);
			color: var(--gm-colortextbutton-ink-color--stateful, rgb(23, 78, 166))
		}

		.ksBjEc .VfPpkd-Jh9lGc::before,
		.ksBjEc .VfPpkd-Jh9lGc::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--gm-colortextbutton-state-color, rgb(26, 115, 232))
		}

		.ksBjEc:hover .VfPpkd-Jh9lGc::before,
		.ksBjEc.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.ksBjEc.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.ksBjEc:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.ksBjEc:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.ksBjEc:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.ksBjEc.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.ksBjEc:disabled:hover .VfPpkd-Jh9lGc::before,
		.ksBjEc:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.ksBjEc:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.ksBjEc:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.ksBjEc:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.ksBjEc:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.ksBjEc:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.LjDxcd {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			font-size: .875rem;
			letter-spacing: .0107142857em;
			font-weight: 500;
			text-transform: none
		}

		.LjDxcd .VfPpkd-Jh9lGc {
			height: 100%;
			position: absolute;
			overflow: hidden;
			width: 100%;
			z-index: 0
		}

		.LjDxcd:not(:disabled) {
			color: rgb(95, 99, 104);
			color: var(--gm-neutraltextbutton-ink-color, rgb(95, 99, 104))
		}

		.LjDxcd:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-neutraltextbutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.LjDxcd:hover:not(:disabled),
		.LjDxcd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe:not(:disabled),
		.LjDxcd:not(.VfPpkd-ksKsZd-mWPk3d):focus:not(:disabled),
		.LjDxcd:active:not(:disabled) {
			color: rgb(32, 33, 36);
			color: var(--gm-neutraltextbutton-ink-color--stateful, rgb(32, 33, 36))
		}

		.LjDxcd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.LjDxcd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: rgb(95, 99, 104)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.LjDxcd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.LjDxcd .VfPpkd-UdE5de-uDEFge .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.LjDxcd .VfPpkd-Jh9lGc::before,
		.LjDxcd .VfPpkd-Jh9lGc::after {
			background-color: rgb(95, 99, 104);
			background-color: var(--gm-neutraltextbutton-state-color, rgb(95, 99, 104))
		}

		.LjDxcd:hover .VfPpkd-Jh9lGc::before,
		.LjDxcd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.LjDxcd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.LjDxcd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.LjDxcd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.LjDxcd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.LjDxcd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.LjDxcd:disabled:hover .VfPpkd-Jh9lGc::before,
		.LjDxcd:disabled.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-Jh9lGc::before {
			opacity: 0;
			opacity: var(--mdc-ripple-hover-opacity, 0)
		}

		.LjDxcd:disabled.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-Jh9lGc::before,
		.LjDxcd:disabled:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-Jh9lGc::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-focus-opacity, 0)
		}

		.LjDxcd:disabled:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-Jh9lGc::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.LjDxcd:disabled:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-Jh9lGc::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: 0;
			opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.LjDxcd:disabled.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0)
		}

		.DuMIQc {
			padding: 0 24px 0 24px
		}

		.P62QJc {
			padding: 0 23px 0 23px;
			border-width: 1px
		}

		.P62QJc.VfPpkd-LgbsSe-OWXEXe-Bz112c-UbuQg {
			padding: 0 11px 0 23px
		}

		.P62QJc.VfPpkd-LgbsSe-OWXEXe-Bz112c-M1Soyc {
			padding: 0 23px 0 11px
		}

		.P62QJc .VfPpkd-Jh9lGc {
			top: -1px;
			left: -1px;
			bottom: -1px;
			right: -1px;
			border-width: 1px
		}

		.P62QJc .VfPpkd-RLmnJb {
			left: -1px;
			width: calc(100% + 2px)
		}

		.yHy1rc {
			z-index: 0
		}

		.yHy1rc .VfPpkd-Bz112c-Jh9lGc::before,
		.yHy1rc .VfPpkd-Bz112c-Jh9lGc::after {
			z-index: -1
		}

		.yHy1rc:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-iconbutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.fzRBVc {
			z-index: 0
		}

		.fzRBVc .VfPpkd-Bz112c-Jh9lGc::before,
		.fzRBVc .VfPpkd-Bz112c-Jh9lGc::after {
			z-index: -1
		}

		.fzRBVc:disabled {
			color: rgba(60, 64, 67, .38);
			color: var(--gm-iconbutton-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.WpHeLc {
			height: 100%;
			left: 0;
			position: absolute;
			top: 0;
			width: 100%;
			outline: none
		}

		[dir=rtl] .HDnnrf .VfPpkd-kBDsod,
		.HDnnrf .VfPpkd-kBDsod[dir=rtl] {
			-webkit-transform: scaleX(-1);
			-ms-transform: scaleX(-1);
			-o-transform: scaleX(-1);
			transform: scaleX(-1)
		}

		[dir=rtl] .QDwDD,
		.QDwDD[dir=rtl] {
			-webkit-transform: scaleX(-1);
			-ms-transform: scaleX(-1);
			-o-transform: scaleX(-1);
			transform: scaleX(-1)
		}

		.PDpWxe {
			will-change: unset
		}

		.LQeN7 .VfPpkd-J1Ukfc-LhBDec {
			pointer-events: none;
			border: 2px solid rgb(24, 90, 188);
			border-radius: 6px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {
			.LQeN7 .VfPpkd-J1Ukfc-LhBDec {
				border-color: CanvasText
			}
		}

		.LQeN7 .VfPpkd-J1Ukfc-LhBDec::after {
			content: "";
			border: 2px solid rgb(232, 240, 254);
			border-radius: 8px;
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {
			.LQeN7 .VfPpkd-J1Ukfc-LhBDec::after {
				border-color: CanvasText
			}
		}

		.LQeN7.gmghec .VfPpkd-J1Ukfc-LhBDec {
			display: inline-block
		}

		@media (-ms-high-contrast:active),
		(-ms-high-contrast:none) {
			.LQeN7.gmghec .VfPpkd-J1Ukfc-LhBDec {
				display: none
			}
		}

		.mN1ivc .VfPpkd-Bz112c-J1Ukfc-LhBDec {
			pointer-events: none;
			border: 2px solid rgb(24, 90, 188);
			border-radius: 6px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: 100%;
			width: 100%
		}

		@media screen and (forced-colors:active) {
			.mN1ivc .VfPpkd-Bz112c-J1Ukfc-LhBDec {
				border-color: CanvasText
			}
		}

		.mN1ivc .VfPpkd-Bz112c-J1Ukfc-LhBDec::after {
			content: "";
			border: 2px solid rgb(232, 240, 254);
			border-radius: 8px;
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {
			.mN1ivc .VfPpkd-Bz112c-J1Ukfc-LhBDec::after {
				border-color: CanvasText
			}
		}

		.mN1ivc.gmghec .VfPpkd-Bz112c-J1Ukfc-LhBDec {
			display: inline-block
		}

		@media (-ms-high-contrast:active),
		(-ms-high-contrast:none) {
			.mN1ivc.gmghec .VfPpkd-Bz112c-J1Ukfc-LhBDec {
				display: none
			}
		}

		.MyRpB .VfPpkd-kBDsod,
		.MyRpB .VfPpkd-vQzf8d {
			opacity: 0
		}

		[data-tooltip-enabled=true]:disabled,
		.VfPpkd-Bz112c-LgbsSe[data-tooltip-enabled=true]:disabled .VfPpkd-Bz112c-Jh9lGc {
			pointer-events: auto
		}

		.VfPpkd-xl07Ob-XxIAqe {
			display: none;
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			margin: 0;
			padding: 0;
			-webkit-transform: scale(1);
			-ms-transform: scale(1);
			-o-transform: scale(1);
			transform: scale(1);
			-webkit-transform-origin: top left;
			-ms-transform-origin: top left;
			-o-transform-origin: top left;
			transform-origin: top left;
			opacity: 0;
			overflow: auto;
			will-change: transform, opacity;
			-webkit-box-shadow: 0 5px 5px -3px rgba(0, 0, 0, .2), 0 8px 10px 1px rgba(0, 0, 0, .14), 0 3px 14px 2px rgba(0, 0, 0, .12);
			box-shadow: 0 5px 5px -3px rgba(0, 0, 0, .2), 0 8px 10px 1px rgba(0, 0, 0, .14), 0 3px 14px 2px rgba(0, 0, 0, .12);
			transform-origin-left: top left;
			transform-origin-right: top right
		}

		.VfPpkd-xl07Ob-XxIAqe:focus {
			outline: none
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-oT9UPb-FNFY6c {
			display: inline-block;
			-webkit-transform: scale(.8);
			-ms-transform: scale(.8);
			-o-transform: scale(.8);
			transform: scale(.8);
			opacity: 0
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-FNFY6c {
			display: inline-block;
			-webkit-transform: scale(1);
			-ms-transform: scale(1);
			-o-transform: scale(1);
			transform: scale(1);
			opacity: 1
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-oT9UPb-xTMeO {
			display: inline-block;
			opacity: 0
		}

		[dir=rtl] .VfPpkd-xl07Ob-XxIAqe,
		.VfPpkd-xl07Ob-XxIAqe[dir=rtl] {
			transform-origin-left: top right;
			transform-origin-right: top left
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-oYxtQd {
			position: relative;
			overflow: visible
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-qbOKL {
			position: fixed
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-tsQazb {
			width: 100%
		}

		.VfPpkd-xl07Ob-XxIAqe {
			max-width: calc(100vw - 32px);
			max-width: var(--mdc-menu-max-width, calc(100vw - 32px));
			max-height: calc(100vh - 32px);
			max-height: var(--mdc-menu-max-height, calc(100vh - 32px));
			z-index: 8;
			-webkit-transition: opacity .03s linear, height .25s cubic-bezier(0, 0, .2, 1), -webkit-transform .12s cubic-bezier(0, 0, .2, 1);
			transition: opacity .03s linear, height .25s cubic-bezier(0, 0, .2, 1), -webkit-transform .12s cubic-bezier(0, 0, .2, 1);
			-o-transition: opacity .03s linear, height .25s cubic-bezier(0, 0, .2, 1), -o-transform .12s cubic-bezier(0, 0, .2, 1);
			transition: opacity .03s linear, transform .12s cubic-bezier(0, 0, .2, 1), height .25s cubic-bezier(0, 0, .2, 1);
			transition: opacity .03s linear, transform .12s cubic-bezier(0, 0, .2, 1), height .25s cubic-bezier(0, 0, .2, 1), -webkit-transform .12s cubic-bezier(0, 0, .2, 1), -o-transform .12s cubic-bezier(0, 0, .2, 1);
			background-color: #fff;
			background-color: var(--mdc-theme-surface, #fff);
			color: #000;
			color: var(--mdc-theme-on-surface, #000);
			border-radius: 4px;
			border-radius: var(--mdc-shape-medium, 4px)
		}

		.VfPpkd-xl07Ob-XxIAqe-OWXEXe-oT9UPb-xTMeO {
			-webkit-transition: opacity 75ms linear;
			-o-transition: opacity 75ms linear;
			transition: opacity 75ms linear
		}

		.VfPpkd-StrnGf-rymPhb {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			line-height: 1.75rem;
			line-height: var(--mdc-typography-subtitle1-line-height, 1.75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit);
			line-height: 1.5rem;
			margin: 0;
			padding: 8px 0;
			list-style-type: none;
			color: rgba(0, 0, 0, .87);
			color: var(--mdc-theme-text-primary-on-background, rgba(0, 0, 0, .87))
		}

		.VfPpkd-StrnGf-rymPhb:focus {
			outline: none
		}

		.VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			color: rgba(0, 0, 0, .54);
			color: var(--mdc-theme-text-secondary-on-background, rgba(0, 0, 0, .54))
		}

		.VfPpkd-StrnGf-rymPhb-f7MjDc {
			background-color: transparent
		}

		.VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: rgba(0, 0, 0, .38);
			color: var(--mdc-theme-text-icon-on-background, rgba(0, 0, 0, .38))
		}

		.VfPpkd-StrnGf-rymPhb-IhFlZd {
			color: rgba(0, 0, 0, .38);
			color: var(--mdc-theme-text-hint-on-background, rgba(0, 0, 0, .38))
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
			opacity: .38
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b {
			color: #6200ee;
			color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: #6200ee;
			color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc {
			padding-top: 4px;
			padding-bottom: 4px;
			font-size: .812rem
		}

		.VfPpkd-StrnGf-rymPhb-Tkg0ld {
			display: block
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			position: relative;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: start;
			-webkit-justify-content: flex-start;
			justify-content: flex-start;
			overflow: hidden;
			padding: 0;
			padding-left: 16px;
			padding-right: 16px;
			height: 48px
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b:focus {
			outline: none
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd):focus::before,
		.VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 1px solid transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd):focus::before,
			.VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe::before {
				border-color: CanvasText
			}
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 3px double transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd::before {
				border-color: CanvasText
			}
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 16px;
			padding-right: 16px;
			height: 56px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 16px;
			padding-right: 16px;
			height: 56px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 16px;
			padding-right: 16px;
			height: 56px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 16px;
			padding-right: 16px;
			height: 72px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: 16px;
			height: 72px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px;
			width: 20px;
			height: 20px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-f7MjDc {
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			fill: currentColor;
			-o-object-fit: cover;
			object-fit: cover;
			margin-left: 0;
			margin-right: 32px;
			width: 24px;
			height: 24px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 32px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 32px;
			width: 24px;
			height: 24px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 32px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px;
			width: 40px;
			height: 40px;
			border-radius: 50%
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px;
			width: 40px;
			height: 40px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px;
			width: 56px;
			height: 56px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px;
			width: 100px;
			height: 56px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex
		}

		.VfPpkd-StrnGf-rymPhb-IhFlZd {
			margin-left: auto;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-IhFlZd:not(.HzV7m-fuEl3d) {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-caption-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .75rem;
			font-size: var(--mdc-typography-caption-font-size, .75rem);
			line-height: 1.25rem;
			line-height: var(--mdc-typography-caption-line-height, 1.25rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-caption-font-weight, 400);
			letter-spacing: .0333333333em;
			letter-spacing: var(--mdc-typography-caption-letter-spacing, .0333333333em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-caption-text-transform, inherit)
		}

		.VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] .VfPpkd-StrnGf-rymPhb-IhFlZd,
		[dir=rtl] .VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-IhFlZd {
			margin-left: 0;
			margin-right: auto
		}

		.VfPpkd-StrnGf-rymPhb-b9t22c {
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden
		}

		.VfPpkd-StrnGf-rymPhb-b9t22c[for] {
			pointer-events: none
		}

		.VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS {
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 24px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-body2-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .875rem;
			font-size: var(--mdc-typography-body2-font-size, .875rem);
			line-height: 1.25rem;
			line-height: var(--mdc-typography-body2-line-height, 1.25rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-body2-font-weight, 400);
			letter-spacing: .0178571429em;
			letter-spacing: var(--mdc-typography-body2-letter-spacing, .0178571429em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-body2-text-decoration, inherit);
			text-decoration: var(--mdc-typography-body2-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-body2-text-transform, inherit);
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			font-size: inherit
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-ibnC6b {
			height: 40px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc .VfPpkd-StrnGf-rymPhb-b9t22c {
			-webkit-align-self: flex-start;
			align-self: flex-start
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc .VfPpkd-StrnGf-rymPhb-ibnC6b {
			height: 64px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b {
			height: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aSi1db-RWgCYc.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-ibnC6b {
			height: 60px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px;
			width: 36px;
			height: 36px
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb.VfPpkd-StrnGf-rymPhb-OWXEXe-EzIYc .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b {
			cursor: pointer
		}

		a.VfPpkd-StrnGf-rymPhb-ibnC6b {
			color: inherit;
			text-decoration: none
		}

		.VfPpkd-StrnGf-rymPhb-clz4Ic {
			height: 0;
			margin: 0;
			border: none;
			border-bottom-width: 1px;
			border-bottom-style: solid
		}

		.VfPpkd-StrnGf-rymPhb-clz4Ic {
			border-bottom-color: rgba(0, 0, 0, .12)
		}

		.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-nNtqDd {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-nNtqDd,
		.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-nNtqDd[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 72px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe,
		.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-nNtqDd {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 88px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-nNtqDd,
		.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-nNtqDd[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 72px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 88px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-Bz112c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 72px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 88px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-YLEF4c-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 72px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 72px;
			margin-right: 0;
			width: calc(100% - 88px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 72px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-JUCs7e-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 88px;
			margin-right: 0;
			width: calc(100% - 88px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 88px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 88px;
			margin-right: 0;
			width: calc(100% - 104px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 88px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-HiaYvf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 116px;
			margin-right: 0;
			width: calc(100% - 116px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 116px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 116px;
			margin-right: 0;
			width: calc(100% - 132px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 116px
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 0;
			margin-right: 0;
			width: 100%
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 0;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.VfPpkd-StrnGf-rymPhb-OWXEXe-aTv5jf-rymPhb .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 0
		}

		.VfPpkd-StrnGf-rymPhb-JNdkSc .VfPpkd-StrnGf-rymPhb {
			padding: 0
		}

		.VfPpkd-StrnGf-rymPhb-oT7voc {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			line-height: 1.75rem;
			line-height: var(--mdc-typography-subtitle1-line-height, 1.75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit);
			margin: .75rem 16px
		}

		.VfPpkd-rymPhb-fpDzbe-fmcmS {
			color: rgba(0, 0, 0, .87);
			color: var(--mdc-theme-text-primary-on-background, rgba(0, 0, 0, .87))
		}

		.VfPpkd-rymPhb-L8ivfd-fmcmS {
			color: rgba(0, 0, 0, .54);
			color: var(--mdc-theme-text-secondary-on-background, rgba(0, 0, 0, .54))
		}

		.VfPpkd-rymPhb-bC5pod-fmcmS {
			color: rgba(0, 0, 0, .38);
			color: var(--mdc-theme-text-hint-on-background, rgba(0, 0, 0, .38))
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e {
			background-color: transparent
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e {
			color: rgba(0, 0, 0, .38);
			color: var(--mdc-theme-text-icon-on-background, rgba(0, 0, 0, .38))
		}

		.VfPpkd-rymPhb-JMEf7e {
			color: rgba(0, 0, 0, .38);
			color: var(--mdc-theme-text-hint-on-background, rgba(0, 0, 0, .38))
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-Gtdoyb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-JMEf7e {
			opacity: .38
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-fpDzbe-fmcmS {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-L8ivfd-fmcmS {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-bC5pod-fmcmS {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-fpDzbe-fmcmS {
			color: #6200ee;
			color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			color: #6200ee;
			color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-StrnGf-rymPhb-oT7voc {
			color: rgba(0, 0, 0, .87);
			color: var(--mdc-theme-text-primary-on-background, rgba(0, 0, 0, .87))
		}

		.VfPpkd-rymPhb-clz4Ic::after {
			border-bottom-color: white
		}

		.VfPpkd-rymPhb {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			line-height: 1.75rem;
			line-height: var(--mdc-typography-subtitle1-line-height, 1.75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit);
			line-height: 1.5rem
		}

		.VfPpkd-rymPhb-fpDzbe-fmcmS {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			line-height: 1.75rem;
			line-height: var(--mdc-typography-subtitle1-line-height, 1.75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit)
		}

		.VfPpkd-rymPhb-L8ivfd-fmcmS {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-body2-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .875rem;
			font-size: var(--mdc-typography-body2-font-size, .875rem);
			line-height: 1.25rem;
			line-height: var(--mdc-typography-body2-line-height, 1.25rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-body2-font-weight, 400);
			letter-spacing: .0178571429em;
			letter-spacing: var(--mdc-typography-body2-letter-spacing, .0178571429em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-body2-text-decoration, inherit);
			text-decoration: var(--mdc-typography-body2-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-body2-text-transform, inherit)
		}

		.VfPpkd-rymPhb-bC5pod-fmcmS {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-overline-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .75rem;
			font-size: var(--mdc-typography-overline-font-size, .75rem);
			line-height: 2rem;
			line-height: var(--mdc-typography-overline-line-height, 2rem);
			font-weight: 500;
			font-weight: var(--mdc-typography-overline-font-weight, 500);
			letter-spacing: .1666666667em;
			letter-spacing: var(--mdc-typography-overline-letter-spacing, .1666666667em);
			text-decoration: none;
			-webkit-text-decoration: var(--mdc-typography-overline-text-decoration, none);
			text-decoration: var(--mdc-typography-overline-text-decoration, none);
			text-transform: uppercase;
			text-transform: var(--mdc-typography-overline-text-transform, uppercase)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c .VfPpkd-rymPhb-KkROqb {
			width: 40px;
			height: 40px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			width: 24px;
			height: 24px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e .VfPpkd-rymPhb-KkROqb {
			width: 40px;
			height: 40px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf .VfPpkd-rymPhb-KkROqb {
			width: 56px;
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf .VfPpkd-rymPhb-KkROqb {
			width: 100px;
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b .VfPpkd-rymPhb-KkROqb {
			width: 40px;
			height: 40px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc .VfPpkd-rymPhb-KkROqb {
			width: 36px;
			height: 20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e {
			width: 24px;
			height: 24px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b .VfPpkd-rymPhb-JMEf7e {
			width: 40px;
			height: 40px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc .VfPpkd-rymPhb-JMEf7e {
			width: 36px;
			height: 20px
		}

		.VfPpkd-rymPhb-oT7voc {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			line-height: 1.75rem;
			line-height: var(--mdc-typography-subtitle1-line-height, 1.75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit)
		}

		.VfPpkd-rymPhb-clz4Ic {
			background-color: rgba(0, 0, 0, .12)
		}

		.VfPpkd-rymPhb-clz4Ic {
			height: 1px
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {
			.VfPpkd-rymPhb-clz4Ic::after {
				content: "";
				display: block;
				border-bottom-width: 1px;
				border-bottom-style: solid
			}
		}

		.VfPpkd-rymPhb {
			margin: 0;
			padding: 8px 0;
			list-style-type: none
		}

		.VfPpkd-rymPhb:focus {
			outline: none
		}

		.VfPpkd-rymPhb-Tkg0ld {
			display: block
		}

		.VfPpkd-rymPhb-ibnC6b {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			position: relative;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: start;
			-webkit-justify-content: flex-start;
			justify-content: flex-start;
			overflow: hidden;
			padding: 0;
			-webkit-box-align: stretch;
			-webkit-align-items: stretch;
			align-items: stretch;
			cursor: pointer
		}

		.VfPpkd-rymPhb-ibnC6b:focus {
			outline: none
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 48px
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 64px
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb {
			height: 88px
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: center;
			align-self: center;
			margin-top: 0
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 16px
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			-webkit-align-self: center;
			align-self: center;
			margin-top: 0
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 16px
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me,
		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-tPcied-hXIJHe {
			cursor: auto
		}

		.VfPpkd-rymPhb-ibnC6b:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd):focus::before,
		.VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 1px solid transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-rymPhb-ibnC6b:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd):focus::before,
			.VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe::before {
				border-color: CanvasText
			}
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 3px double transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd::before {
				border-color: CanvasText
			}
		}

		.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:focus::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 3px solid transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:focus::before {
				border-color: CanvasText
			}
		}

		a.VfPpkd-rymPhb-ibnC6b {
			color: inherit;
			text-decoration: none
		}

		.VfPpkd-rymPhb-KkROqb {
			fill: currentColor;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			pointer-events: none
		}

		.VfPpkd-rymPhb-JMEf7e {
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			pointer-events: none
		}

		.VfPpkd-rymPhb-Gtdoyb {
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
			-webkit-align-self: center;
			align-self: center;
			-webkit-box-flex: 1;
			-webkit-flex: 1;
			flex: 1;
			pointer-events: none
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-Gtdoyb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-Gtdoyb {
			-webkit-align-self: stretch;
			align-self: stretch
		}

		.VfPpkd-rymPhb-Gtdoyb[for] {
			pointer-events: none
		}

		.VfPpkd-rymPhb-fpDzbe-fmcmS {
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-L8ivfd-fmcmS {
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-L8ivfd-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-L8ivfd-fmcmS {
			white-space: normal;
			line-height: 20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-BYmFj .VfPpkd-rymPhb-L8ivfd-fmcmS {
			white-space: nowrap;
			line-height: auto
		}

		.VfPpkd-rymPhb-bC5pod-fmcmS {
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 24px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c .VfPpkd-rymPhb-KkROqb {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-YLEF4c .VfPpkd-rymPhb-KkROqb {
			border-radius: 50%
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			margin-left: 16px;
			margin-right: 32px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 32px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e .VfPpkd-rymPhb-KkROqb {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf .VfPpkd-rymPhb-KkROqb {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf .VfPpkd-rymPhb-KkROqb {
			margin-left: 0;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c .VfPpkd-rymPhb-KkROqb {
			margin-left: 8px;
			margin-right: 24px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 24px;
			margin-right: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b .VfPpkd-rymPhb-KkROqb {
			margin-left: 8px;
			margin-right: 24px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 24px;
			margin-right: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc .VfPpkd-rymPhb-KkROqb {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-bC5pod-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 32px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 72px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			margin-left: 28px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 16px;
			margin-right: 28px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-caption-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .75rem;
			font-size: var(--mdc-typography-caption-font-size, .75rem);
			line-height: 1.25rem;
			line-height: var(--mdc-typography-caption-line-height, 1.25rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-caption-font-weight, 400);
			letter-spacing: .0333333333em;
			letter-spacing: var(--mdc-typography-caption-letter-spacing, .0333333333em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-caption-text-transform, inherit)
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c .VfPpkd-rymPhb-JMEf7e {
			margin-left: 24px;
			margin-right: 8px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 8px;
			margin-right: 24px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-MPu53c.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b .VfPpkd-rymPhb-JMEf7e {
			margin-left: 24px;
			margin-right: 8px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 8px;
			margin-right: 24px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-GCYh9b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc .VfPpkd-rymPhb-JMEf7e {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-scr2fc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-JMEf7e {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 16px
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-BYmFj.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-BYmFj.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-BYmFj.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-BYmFj.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-vfifzc-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-rymPhb-ibnC6b {
			padding-left: 16px;
			padding-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-rymPhb-JNdkSc .VfPpkd-StrnGf-rymPhb {
			padding: 0
		}

		.VfPpkd-rymPhb-oT7voc {
			margin: .75rem 16px
		}

		.VfPpkd-rymPhb-clz4Ic {
			padding: 0;
			background-clip: content-box
		}

		.VfPpkd-rymPhb-clz4Ic.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-fmcmS.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe {
			padding-left: 16px;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-clz4Ic.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-fmcmS.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-fmcmS.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl] {
			padding-left: auto;
			padding-right: 16px
		}

		.VfPpkd-rymPhb-clz4Ic.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-fmcmS.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe {
			padding-left: auto;
			padding-right: 16px
		}

		[dir=rtl] .VfPpkd-rymPhb-clz4Ic.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-fmcmS.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.VfPpkd-rymPhb-clz4Ic.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-fmcmS.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-JUCs7e.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YLEF4c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-MPu53c.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-scr2fc.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl],
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-GCYh9b.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl] {
			padding-left: 16px;
			padding-right: auto
		}

		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-rymPhb-clz4Ic,
		.VfPpkd-rymPhb-clz4Ic[dir=rtl] {
			padding: 0
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-rymPhb-pZXsl::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-rymPhb-pZXsl::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-rymPhb-pZXsl::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-rymPhb-pZXsl::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			top: -50%;
			left: -50%;
			width: 200%;
			height: 200%
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			top: -50%;
			left: -50%;
			width: 200%;
			height: 200%
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-rymPhb-pZXsl::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, #000)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, #000)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:hover .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .12;
			opacity: var(--mdc-ripple-activated-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: #6200ee;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-primary, #6200ee))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .16;
			opacity: var(--mdc-ripple-hover-opacity, .16)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-focus-opacity, .24)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-press-opacity, .24)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-pZXsl::before {
			opacity: .12;
			opacity: var(--mdc-ripple-activated-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-pZXsl::after {
			background-color: #6200ee;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-primary, #6200ee))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:hover .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .16;
			opacity: var(--mdc-ripple-hover-opacity, .16)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-focus-opacity, .24)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-press-opacity, .24)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.24)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .08;
			opacity: var(--mdc-ripple-selected-opacity, .08)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: #6200ee;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-primary, #6200ee))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .12;
			opacity: var(--mdc-ripple-hover-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-focus-opacity, .2)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-press-opacity, .2)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before {
			opacity: .08;
			opacity: var(--mdc-ripple-selected-opacity, .08)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after {
			background-color: #6200ee;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-primary, #6200ee))
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .12;
			opacity: var(--mdc-ripple-hover-opacity, .12)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-focus-opacity, .2)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-press-opacity, .2)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.2)
		}

		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-pZXsl,
		:not(.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			pointer-events: none
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-rymPhb-pZXsl::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-rymPhb-pZXsl::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-rymPhb-pZXsl::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-rymPhb-pZXsl::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			top: -50%;
			left: -50%;
			width: 200%;
			height: 200%
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-rymPhb-pZXsl::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, #000)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b:hover .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-pZXsl::before {
			opacity: .12;
			opacity: var(--mdc-ripple-activated-opacity, .12)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-pZXsl::after {
			background-color: #6200ee;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-primary, #6200ee))
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b:hover .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .16;
			opacity: var(--mdc-ripple-hover-opacity, .16)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-focus-opacity, .24)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .24;
			opacity: var(--mdc-ripple-press-opacity, .24)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.24)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before {
			opacity: .08;
			opacity: var(--mdc-ripple-selected-opacity, .08)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after {
			background-color: #6200ee;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-primary, #6200ee))
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .12;
			opacity: var(--mdc-ripple-hover-opacity, .12)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-focus-opacity, .2)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .2;
			opacity: var(--mdc-ripple-press-opacity, .2)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.2)
		}

		:not(.VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me).VfPpkd-rymPhb-ibnC6b .VfPpkd-rymPhb-pZXsl {
			position: relative;
			outline: none;
			overflow: hidden;
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			pointer-events: none
		}

		.VfPpkd-xl07Ob {
			min-width: 112px;
			min-width: var(--mdc-menu-min-width, 112px)
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: rgba(0, 0, 0, .87)
		}

		.VfPpkd-xl07Ob .VfPpkd-xl07Ob-ibnC6b-OWXEXe-eKm5Fc-FNFY6c .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04
		}

		.VfPpkd-xl07Ob .VfPpkd-xl07Ob-ibnC6b-OWXEXe-eKm5Fc-FNFY6c .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb {
			color: rgba(0, 0, 0, .87)
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb,
		.VfPpkd-xl07Ob .VfPpkd-rymPhb {
			position: relative
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb .VfPpkd-BFbNVe-bF1uUb,
		.VfPpkd-xl07Ob .VfPpkd-rymPhb .VfPpkd-BFbNVe-bF1uUb {
			width: 100%;
			height: 100%;
			top: 0;
			left: 0
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb::before,
		.VfPpkd-xl07Ob .VfPpkd-rymPhb::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 1px solid transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb::before,
			.VfPpkd-xl07Ob .VfPpkd-rymPhb::before {
				border-color: CanvasText
			}
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb-clz4Ic {
			margin: 8px 0
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb-ibnC6b {
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none
		}

		.VfPpkd-xl07Ob .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me {
			cursor: auto
		}

		.VfPpkd-xl07Ob a.VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-b9t22c,
		.VfPpkd-xl07Ob a.VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			pointer-events: none
		}

		.VfPpkd-qPzbhe-JNdkSc {
			padding: 0;
			fill: currentColor
		}

		.VfPpkd-qPzbhe-JNdkSc .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 56px;
			padding-right: 16px
		}

		[dir=rtl] .VfPpkd-qPzbhe-JNdkSc .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-qPzbhe-JNdkSc .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 56px
		}

		.VfPpkd-qPzbhe-JNdkSc .VfPpkd-qPzbhe-JNdkSc-Bz112c {
			left: 16px;
			right: auto;
			visibility: hidden;
			position: absolute;
			top: 50%;
			-webkit-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			-o-transform: translateY(-50%);
			transform: translateY(-50%);
			-webkit-transition-property: visibility;
			-o-transition-property: visibility;
			transition-property: visibility;
			-webkit-transition-delay: 75ms;
			-o-transition-delay: 75ms;
			transition-delay: 75ms
		}

		[dir=rtl] .VfPpkd-qPzbhe-JNdkSc .VfPpkd-qPzbhe-JNdkSc-Bz112c,
		.VfPpkd-qPzbhe-JNdkSc .VfPpkd-qPzbhe-JNdkSc-Bz112c[dir=rtl] {
			left: auto;
			right: 16px
		}

		.VfPpkd-xl07Ob-ibnC6b-OWXEXe-gk6SMd .VfPpkd-qPzbhe-JNdkSc-Bz112c {
			display: inline;
			visibility: visible
		}

		.P2Hi5d,
		.mkMxfe,
		.OBi8lb,
		.P9QRxe,
		.vqjb4e,
		.y8Rdrf,
		.DMZ54e {
			font-family: Roboto, Arial, sans-serif;
			line-height: 1.5rem;
			font-size: 1rem;
			letter-spacing: .00625em;
			font-weight: 400;
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-IhFlZd,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-IhFlZd {
			color: rgb(95, 99, 104)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			color: rgb(60, 64, 67)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
			opacity: .38
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: 0
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd {
			background-color: rgb(232, 240, 254)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--mdc-ripple-color, rgb(26, 115, 232))
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
			.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
			.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
			.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
			.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
			.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS,
			.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
				color: GrayText
			}

			.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.OBi8lb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.P9QRxe .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.vqjb4e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.y8Rdrf .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.DMZ54e .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
				opacity: 1
			}
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 24px;
			padding-right: 16px
		}

		[dir=rtl] .P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 24px
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 24px;
			margin-right: 0;
			width: calc(100% - 24px)
		}

		[dir=rtl] .P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 24px
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 24px;
			margin-right: 0;
			width: calc(100% - 40px)
		}

		[dir=rtl] .P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 24px
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 24px;
			margin-right: 0;
			width: calc(100% - 24px)
		}

		[dir=rtl] .P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 24px
		}

		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 24px;
			margin-right: 0;
			width: calc(100% - 40px)
		}

		[dir=rtl] .P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.P2Hi5d .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 24px
		}

		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 16px
		}

		[dir=rtl] .mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-ibnC6b .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 16px;
			margin-right: 0
		}

		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc {
			margin-left: 56px;
			margin-right: 0;
			width: calc(100% - 56px)
		}

		[dir=rtl] .mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc[dir=rtl] {
			margin-left: 0;
			margin-right: 56px
		}

		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			width: calc(100% - 16px)
		}

		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg {
			margin-left: 56px;
			margin-right: 0;
			width: calc(100% - 72px)
		}

		[dir=rtl] .mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg[dir=rtl] {
			margin-left: 0;
			margin-right: 56px
		}

		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 16px)
		}

		[dir=rtl] .mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2 {
			margin-left: 16px;
			margin-right: 0;
			width: calc(100% - 32px)
		}

		[dir=rtl] .mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2,
		.mkMxfe .VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-M1Soyc.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-UbuQg.VfPpkd-StrnGf-rymPhb-clz4Ic-OWXEXe-YbohUe-QFlW2[dir=rtl] {
			margin-left: 0;
			margin-right: 16px
		}

		.r6B9Fd {
			font-family: Roboto, Arial, sans-serif;
			line-height: 1.5rem;
			font-size: 1rem;
			letter-spacing: .00625em;
			font-weight: 400
		}

		.r6B9Fd .VfPpkd-rymPhb-fpDzbe-fmcmS {
			color: rgb(60, 64, 67)
		}

		.r6B9Fd .VfPpkd-rymPhb-L8ivfd-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-bC5pod-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-JMEf7e {
			color: rgb(95, 99, 104)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-L8ivfd-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-bC5pod-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			color: rgb(60, 64, 67)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-KkROqb,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-Gtdoyb,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-JMEf7e {
			opacity: .38
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			color: rgb(60, 64, 67)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before {
			opacity: 0
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd {
			background-color: rgb(232, 240, 254)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--mdc-ripple-color, rgb(26, 115, 232))
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.r6B9Fd .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		@media screen and (forced-colors:active) {

			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-fpDzbe-fmcmS,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-L8ivfd-fmcmS,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-bC5pod-fmcmS,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
				color: GrayText
			}

			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-KkROqb,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-Gtdoyb,
			.r6B9Fd .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-JMEf7e {
				opacity: 1
			}
		}

		.uTZ9Lb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb,
		.FvXOfd.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb,
		.QrsYgb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb,
		.gfwIBd.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: center;
			align-self: center;
			margin-top: 0
		}

		.HiC7Nc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 56px
		}

		.HiC7Nc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-HiaYvf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc,
		.HiC7Nc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-aTv5jf.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 72px
		}

		.UbEQCe.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .UbEQCe.VfPpkd-rymPhb-ibnC6b,
		.UbEQCe.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.UbEQCe .VfPpkd-rymPhb-KkROqb {
			margin-left: 16px;
			margin-right: 16px
		}

		[dir=rtl] .UbEQCe .VfPpkd-rymPhb-KkROqb,
		.UbEQCe .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.rKASPc.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .rKASPc.VfPpkd-rymPhb-ibnC6b,
		.rKASPc.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.rKASPc .VfPpkd-rymPhb-KkROqb {
			margin-left: 8px;
			margin-right: 8px
		}

		[dir=rtl] .rKASPc .VfPpkd-rymPhb-KkROqb,
		.rKASPc .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 8px;
			margin-right: 8px
		}

		.rKASPc.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.U5k4Fd.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .U5k4Fd.VfPpkd-rymPhb-ibnC6b,
		.U5k4Fd.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.U5k4Fd .VfPpkd-rymPhb-KkROqb {
			margin-left: 8px;
			margin-right: 8px
		}

		[dir=rtl] .U5k4Fd .VfPpkd-rymPhb-KkROqb,
		.U5k4Fd .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 8px;
			margin-right: 8px
		}

		.U5k4Fd.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.ifEyr.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .ifEyr.VfPpkd-rymPhb-ibnC6b,
		.ifEyr.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.ifEyr .VfPpkd-rymPhb-KkROqb {
			margin-left: 8px;
			margin-right: 8px
		}

		[dir=rtl] .ifEyr .VfPpkd-rymPhb-KkROqb,
		.ifEyr .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 8px;
			margin-right: 8px
		}

		.ifEyr.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			margin-top: 8px
		}

		.SNowt.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .SNowt.VfPpkd-rymPhb-ibnC6b,
		.SNowt.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.SNowt .VfPpkd-rymPhb-JMEf7e {
			margin-left: 8px;
			margin-right: 16px
		}

		[dir=rtl] .SNowt .VfPpkd-rymPhb-JMEf7e,
		.SNowt .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 16px;
			margin-right: 8px
		}

		.tfmWAf.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .tfmWAf.VfPpkd-rymPhb-ibnC6b,
		.tfmWAf.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.tfmWAf .VfPpkd-rymPhb-JMEf7e {
			margin-left: 8px;
			margin-right: 16px
		}

		[dir=rtl] .tfmWAf .VfPpkd-rymPhb-JMEf7e,
		.tfmWAf .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 16px;
			margin-right: 8px
		}

		.axtYbd.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .axtYbd.VfPpkd-rymPhb-ibnC6b,
		.axtYbd.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.axtYbd .VfPpkd-rymPhb-JMEf7e {
			margin-left: 16px;
			margin-right: 24px
		}

		[dir=rtl] .axtYbd .VfPpkd-rymPhb-JMEf7e,
		.axtYbd .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 24px;
			margin-right: 16px
		}

		.aopLEb.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .aopLEb.VfPpkd-rymPhb-ibnC6b,
		.aopLEb.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.aopLEb .VfPpkd-rymPhb-JMEf7e {
			margin-left: 16px;
			margin-right: 24px
		}

		[dir=rtl] .aopLEb .VfPpkd-rymPhb-JMEf7e,
		.aopLEb .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 24px;
			margin-right: 16px
		}

		.zlqiud.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .zlqiud.VfPpkd-rymPhb-ibnC6b,
		.zlqiud.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.zlqiud .VfPpkd-rymPhb-JMEf7e {
			margin-left: 16px;
			margin-right: 24px
		}

		[dir=rtl] .zlqiud .VfPpkd-rymPhb-JMEf7e,
		.zlqiud .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 24px;
			margin-right: 16px
		}

		.isC8Y.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe {
			padding-left: 24px;
			padding-right: auto
		}

		[dir=rtl] .isC8Y.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe,
		.isC8Y.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-M1Soyc-YbohUe[dir=rtl] {
			padding-left: auto;
			padding-right: 24px
		}

		.MCs1Pd {
			padding-left: 24px;
			padding-right: 24px
		}

		[dir=rtl] .MCs1Pd,
		.MCs1Pd[dir=rtl] {
			padding-left: 24px;
			padding-right: 24px
		}

		.e6pQl.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe {
			padding-left: auto;
			padding-right: 24px
		}

		[dir=rtl] .e6pQl.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe,
		.e6pQl.VfPpkd-rymPhb-clz4Ic-OWXEXe-SfQLQb-UbuQg-YbohUe[dir=rtl] {
			padding-left: 24px;
			padding-right: auto
		}

		[dir=rtl] .e6pQl,
		.e6pQl[dir=rtl] {
			padding: 0
		}

		.UQ5E0 {
			-webkit-box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12)
		}

		.q6oraf {
			-webkit-box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb {
			font-family: Roboto, Arial, sans-serif;
			line-height: 1.5rem;
			font-size: 1rem;
			letter-spacing: .00625em;
			font-weight: 400;
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-IhFlZd {
			color: rgb(95, 99, 104)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			color: rgb(60, 64, 67)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
			opacity: .38
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: 0
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd {
			background-color: rgb(232, 240, 254)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--mdc-ripple-color, rgb(26, 115, 232))
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
				color: GrayText
			}

			.q6oraf .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
				opacity: 1
			}
		}

		.VfPpkd-JGcpL-uI4vCe-LkdAo,
		.VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #6200ee;
			stroke: var(--mdc-theme-primary, #6200ee)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.VfPpkd-JGcpL-uI4vCe-LkdAo,
			.VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.VfPpkd-JGcpL-uI4vCe-u014N {
			stroke: transparent
		}

		@-webkit-keyframes mdc-circular-progress-container-rotate {
			to {
				-webkit-transform: rotate(1turn);
				transform: rotate(1turn)
			}
		}

		@keyframes mdc-circular-progress-container-rotate {
			to {
				-webkit-transform: rotate(1turn);
				-o-transform: rotate(1turn);
				transform: rotate(1turn)
			}
		}

		@-webkit-keyframes mdc-circular-progress-spinner-layer-rotate {
			12.5% {
				-webkit-transform: rotate(135deg);
				transform: rotate(135deg)
			}

			25% {
				-webkit-transform: rotate(270deg);
				transform: rotate(270deg)
			}

			37.5% {
				-webkit-transform: rotate(405deg);
				transform: rotate(405deg)
			}

			50% {
				-webkit-transform: rotate(540deg);
				transform: rotate(540deg)
			}

			62.5% {
				-webkit-transform: rotate(675deg);
				transform: rotate(675deg)
			}

			75% {
				-webkit-transform: rotate(810deg);
				transform: rotate(810deg)
			}

			87.5% {
				-webkit-transform: rotate(945deg);
				transform: rotate(945deg)
			}

			100% {
				-webkit-transform: rotate(3turn);
				transform: rotate(3turn)
			}
		}

		@keyframes mdc-circular-progress-spinner-layer-rotate {
			12.5% {
				-webkit-transform: rotate(135deg);
				-o-transform: rotate(135deg);
				transform: rotate(135deg)
			}

			25% {
				-webkit-transform: rotate(270deg);
				-o-transform: rotate(270deg);
				transform: rotate(270deg)
			}

			37.5% {
				-webkit-transform: rotate(405deg);
				-o-transform: rotate(405deg);
				transform: rotate(405deg)
			}

			50% {
				-webkit-transform: rotate(540deg);
				-o-transform: rotate(540deg);
				transform: rotate(540deg)
			}

			62.5% {
				-webkit-transform: rotate(675deg);
				-o-transform: rotate(675deg);
				transform: rotate(675deg)
			}

			75% {
				-webkit-transform: rotate(810deg);
				-o-transform: rotate(810deg);
				transform: rotate(810deg)
			}

			87.5% {
				-webkit-transform: rotate(945deg);
				-o-transform: rotate(945deg);
				transform: rotate(945deg)
			}

			100% {
				-webkit-transform: rotate(3turn);
				-o-transform: rotate(3turn);
				transform: rotate(3turn)
			}
		}

		@-webkit-keyframes mdc-circular-progress-color-1-fade-in-out {
			from {
				opacity: .99
			}

			25% {
				opacity: .99
			}

			26% {
				opacity: 0
			}

			89% {
				opacity: 0
			}

			90% {
				opacity: .99
			}

			to {
				opacity: .99
			}
		}

		@keyframes mdc-circular-progress-color-1-fade-in-out {
			from {
				opacity: .99
			}

			25% {
				opacity: .99
			}

			26% {
				opacity: 0
			}

			89% {
				opacity: 0
			}

			90% {
				opacity: .99
			}

			to {
				opacity: .99
			}
		}

		@-webkit-keyframes mdc-circular-progress-color-2-fade-in-out {
			from {
				opacity: 0
			}

			15% {
				opacity: 0
			}

			25% {
				opacity: .99
			}

			50% {
				opacity: .99
			}

			51% {
				opacity: 0
			}

			to {
				opacity: 0
			}
		}

		@keyframes mdc-circular-progress-color-2-fade-in-out {
			from {
				opacity: 0
			}

			15% {
				opacity: 0
			}

			25% {
				opacity: .99
			}

			50% {
				opacity: .99
			}

			51% {
				opacity: 0
			}

			to {
				opacity: 0
			}
		}

		@-webkit-keyframes mdc-circular-progress-color-3-fade-in-out {
			from {
				opacity: 0
			}

			40% {
				opacity: 0
			}

			50% {
				opacity: .99
			}

			75% {
				opacity: .99
			}

			76% {
				opacity: 0
			}

			to {
				opacity: 0
			}
		}

		@keyframes mdc-circular-progress-color-3-fade-in-out {
			from {
				opacity: 0
			}

			40% {
				opacity: 0
			}

			50% {
				opacity: .99
			}

			75% {
				opacity: .99
			}

			76% {
				opacity: 0
			}

			to {
				opacity: 0
			}
		}

		@-webkit-keyframes mdc-circular-progress-color-4-fade-in-out {
			from {
				opacity: 0
			}

			65% {
				opacity: 0
			}

			75% {
				opacity: .99
			}

			90% {
				opacity: .99
			}

			to {
				opacity: 0
			}
		}

		@keyframes mdc-circular-progress-color-4-fade-in-out {
			from {
				opacity: 0
			}

			65% {
				opacity: 0
			}

			75% {
				opacity: .99
			}

			90% {
				opacity: .99
			}

			to {
				opacity: 0
			}
		}

		@-webkit-keyframes mdc-circular-progress-left-spin {
			from {
				-webkit-transform: rotate(265deg);
				transform: rotate(265deg)
			}

			50% {
				-webkit-transform: rotate(130deg);
				transform: rotate(130deg)
			}

			to {
				-webkit-transform: rotate(265deg);
				transform: rotate(265deg)
			}
		}

		@keyframes mdc-circular-progress-left-spin {
			from {
				-webkit-transform: rotate(265deg);
				-o-transform: rotate(265deg);
				transform: rotate(265deg)
			}

			50% {
				-webkit-transform: rotate(130deg);
				-o-transform: rotate(130deg);
				transform: rotate(130deg)
			}

			to {
				-webkit-transform: rotate(265deg);
				-o-transform: rotate(265deg);
				transform: rotate(265deg)
			}
		}

		@-webkit-keyframes mdc-circular-progress-right-spin {
			from {
				-webkit-transform: rotate(-265deg);
				transform: rotate(-265deg)
			}

			50% {
				-webkit-transform: rotate(-130deg);
				transform: rotate(-130deg)
			}

			to {
				-webkit-transform: rotate(-265deg);
				transform: rotate(-265deg)
			}
		}

		@keyframes mdc-circular-progress-right-spin {
			from {
				-webkit-transform: rotate(-265deg);
				-o-transform: rotate(-265deg);
				transform: rotate(-265deg)
			}

			50% {
				-webkit-transform: rotate(-130deg);
				-o-transform: rotate(-130deg);
				transform: rotate(-130deg)
			}

			to {
				-webkit-transform: rotate(-265deg);
				-o-transform: rotate(-265deg);
				transform: rotate(-265deg)
			}
		}

		.VfPpkd-JGcpL-P1ekSe {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			position: relative;
			direction: ltr;
			line-height: 0;
			-webkit-transition: opacity .25s 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: opacity .25s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity .25s 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-JGcpL-uI4vCe-haAclf,
		.VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G,
		.VfPpkd-JGcpL-IdXvz-haAclf,
		.VfPpkd-JGcpL-QYI5B-pbTTYe {
			position: absolute;
			width: 100%;
			height: 100%
		}

		.VfPpkd-JGcpL-uI4vCe-haAclf {
			-webkit-transform: rotate(-90deg);
			-ms-transform: rotate(-90deg);
			-o-transform: rotate(-90deg);
			transform: rotate(-90deg)
		}

		.VfPpkd-JGcpL-IdXvz-haAclf {
			font-size: 0;
			letter-spacing: 0;
			white-space: nowrap;
			opacity: 0
		}

		.VfPpkd-JGcpL-uI4vCe-LkdAo-Bd00G,
		.VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			fill: transparent
		}

		.VfPpkd-JGcpL-uI4vCe-LkdAo {
			-webkit-transition: stroke-dashoffset .5s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: stroke-dashoffset .5s 0ms cubic-bezier(0, 0, .2, 1);
			transition: stroke-dashoffset .5s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-JGcpL-OcUoKf-TpMipd {
			position: absolute;
			top: 0;
			left: 47.5%;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 5%;
			height: 100%;
			overflow: hidden
		}

		.VfPpkd-JGcpL-OcUoKf-TpMipd .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			left: -900%;
			width: 2000%;
			-webkit-transform: rotate(180deg);
			-ms-transform: rotate(180deg);
			-o-transform: rotate(180deg);
			transform: rotate(180deg)
		}

		.VfPpkd-JGcpL-lLvYUc-e9ayKc {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			position: relative;
			width: 50%;
			height: 100%;
			overflow: hidden
		}

		.VfPpkd-JGcpL-lLvYUc-e9ayKc .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			width: 200%
		}

		.VfPpkd-JGcpL-lLvYUc-qwU8Me .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			left: -100%
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-uI4vCe-haAclf {
			opacity: 0
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-IdXvz-haAclf {
			opacity: 1
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-IdXvz-haAclf {
			-webkit-animation: mdc-circular-progress-container-rotate 1.5682352941176s linear infinite;
			animation: mdc-circular-progress-container-rotate 1.5682352941176s linear infinite
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-QYI5B-pbTTYe {
			-webkit-animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-Ydhldb-R6PoUb {
			-webkit-animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-1-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-1-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-Ydhldb-ibL1re {
			-webkit-animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-2-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-2-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-Ydhldb-c5RTEf {
			-webkit-animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-3-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-3-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-Ydhldb-II5mzb {
			-webkit-animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-4-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-spinner-layer-rotate 5332ms cubic-bezier(.4, 0, .2, 1) infinite both, mdc-circular-progress-color-4-fade-in-out 5332ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-lLvYUc-LK5yu .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			-webkit-animation: mdc-circular-progress-left-spin 1333ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-left-spin 1333ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-A9y3zc .VfPpkd-JGcpL-lLvYUc-qwU8Me .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			-webkit-animation: mdc-circular-progress-right-spin 1333ms cubic-bezier(.4, 0, .2, 1) infinite both;
			animation: mdc-circular-progress-right-spin 1333ms cubic-bezier(.4, 0, .2, 1) infinite both
		}

		.VfPpkd-JGcpL-P1ekSe-OWXEXe-xTMeO {
			opacity: 0
		}

		.DU29of {
			position: relative
		}

		.DU29of .VfPpkd-JGcpL-uI4vCe-LkdAo,
		.DU29of .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #4285f4
		}

		@media screen and (forced-colors:active),
		(-ms-high-contrast:active) {

			.DU29of .VfPpkd-JGcpL-uI4vCe-LkdAo,
			.DU29of .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.DU29of .VfPpkd-JGcpL-Ydhldb-R6PoUb .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #4285f4
		}

		@media screen and (forced-colors:active),
		(-ms-high-contrast:active) {
			.DU29of .VfPpkd-JGcpL-Ydhldb-R6PoUb .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.DU29of .VfPpkd-JGcpL-Ydhldb-ibL1re .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #ea4335
		}

		@media screen and (forced-colors:active),
		(-ms-high-contrast:active) {
			.DU29of .VfPpkd-JGcpL-Ydhldb-ibL1re .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.DU29of .VfPpkd-JGcpL-Ydhldb-c5RTEf .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #fbbc04
		}

		@media screen and (forced-colors:active),
		(-ms-high-contrast:active) {
			.DU29of .VfPpkd-JGcpL-Ydhldb-c5RTEf .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.DU29of .VfPpkd-JGcpL-Ydhldb-II5mzb .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
			stroke: #34a853
		}

		@media screen and (forced-colors:active),
		(-ms-high-contrast:active) {
			.DU29of .VfPpkd-JGcpL-Ydhldb-II5mzb .VfPpkd-JGcpL-IdXvz-LkdAo-Bd00G {
				stroke: CanvasText
			}
		}

		.DU29of .VfPpkd-JGcpL-Mr8B3-V67aGc {
			height: 100%;
			width: 100%;
			position: absolute;
			opacity: 0;
			overflow: hidden;
			z-index: -1
		}

		.VfPpkd-BFbNVe-bF1uUb {
			position: absolute;
			border-radius: inherit;
			pointer-events: none;
			opacity: 0;
			opacity: var(--mdc-elevation-overlay-opacity, 0);
			-webkit-transition: opacity .28s cubic-bezier(.4, 0, .2, 1);
			-o-transition: opacity .28s cubic-bezier(.4, 0, .2, 1);
			transition: opacity .28s cubic-bezier(.4, 0, .2, 1);
			background-color: #fff;
			background-color: var(--mdc-elevation-overlay-color, #fff)
		}

		.NZp2ef {
			background-color: #e8eaed
		}

		.VfPpkd-z59Tgd {
			border-radius: 4px;
			border-radius: var(--mdc-shape-small, 4px)
		}

		.VfPpkd-Djsh7e-XxIAqe-ma6Yeb,
		.VfPpkd-Djsh7e-XxIAqe-cGMI2b {
			border-radius: 4px;
			border-radius: var(--mdc-shape-small, 4px)
		}

		.VfPpkd-z59Tgd {
			color: white;
			color: var(--mdc-theme-text-primary-on-dark, white)
		}

		.VfPpkd-z59Tgd {
			background-color: rgba(0, 0, 0, .6)
		}

		.VfPpkd-MlC99b {
			color: rgba(0, 0, 0, .87);
			color: var(--mdc-theme-text-primary-on-light, rgba(0, 0, 0, .87))
		}

		.VfPpkd-IqDDtd {
			color: rgba(0, 0, 0, .6)
		}

		.VfPpkd-IqDDtd-hSRGPd {
			color: #6200ee;
			color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-suEOdc.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd,
		.VfPpkd-suEOdc.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-Djsh7e-XxIAqe-ma6Yeb,
		.VfPpkd-suEOdc.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-Djsh7e-XxIAqe-cGMI2b {
			background-color: #fff
		}

		.VfPpkd-z59Tgd {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-caption-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .75rem;
			font-size: var(--mdc-typography-caption-font-size, .75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-caption-font-weight, 400);
			letter-spacing: .0333333333em;
			letter-spacing: var(--mdc-typography-caption-letter-spacing, .0333333333em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-caption-text-transform, inherit)
		}

		.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd {
			-webkit-box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .2), 0 2px 2px 0 rgba(0, 0, 0, .14), 0 1px 5px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .2), 0 2px 2px 0 rgba(0, 0, 0, .14), 0 1px 5px 0 rgba(0, 0, 0, .12);
			border-radius: 4px;
			line-height: 20px
		}

		.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd .VfPpkd-BFbNVe-bF1uUb {
			width: 100%;
			height: 100%;
			top: 0;
			left: 0
		}

		.VfPpkd-z59Tgd .VfPpkd-MlC99b {
			display: block;
			margin-top: 0;
			line-height: 20px;
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle2-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .875rem;
			font-size: var(--mdc-typography-subtitle2-font-size, .875rem);
			line-height: 1.375rem;
			line-height: var(--mdc-typography-subtitle2-line-height, 1.375rem);
			font-weight: 500;
			font-weight: var(--mdc-typography-subtitle2-font-weight, 500);
			letter-spacing: .0071428571em;
			letter-spacing: var(--mdc-typography-subtitle2-letter-spacing, .0071428571em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle2-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle2-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle2-text-transform, inherit)
		}

		.VfPpkd-z59Tgd .VfPpkd-MlC99b::before {
			display: inline-block;
			width: 0;
			height: 24px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-z59Tgd .VfPpkd-IqDDtd {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-body2-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .875rem;
			font-size: var(--mdc-typography-body2-font-size, .875rem);
			line-height: 1.25rem;
			line-height: var(--mdc-typography-body2-line-height, 1.25rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-body2-font-weight, 400);
			letter-spacing: .0178571429em;
			letter-spacing: var(--mdc-typography-body2-letter-spacing, .0178571429em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-body2-text-decoration, inherit);
			text-decoration: var(--mdc-typography-body2-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-body2-text-transform, inherit)
		}

		.VfPpkd-z59Tgd {
			word-break: break-all;
			word-break: var(--mdc-tooltip-word-break, normal);
			overflow-wrap: anywhere
		}

		.VfPpkd-suEOdc-OWXEXe-eo9XGd-RCfa3e .VfPpkd-z59Tgd-OiiCO {
			-webkit-transition: opacity .15s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .15s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .15s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .15s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: opacity .15s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .15s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .15s 0ms cubic-bezier(0, 0, .2, 1), transform .15s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .15s 0ms cubic-bezier(0, 0, .2, 1), transform .15s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .15s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .15s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-suEOdc-OWXEXe-ZYIfFd-RCfa3e .VfPpkd-z59Tgd-OiiCO {
			-webkit-transition: opacity 75ms 0ms cubic-bezier(.4, 0, 1, 1);
			-o-transition: opacity 75ms 0ms cubic-bezier(.4, 0, 1, 1);
			transition: opacity 75ms 0ms cubic-bezier(.4, 0, 1, 1)
		}

		.VfPpkd-suEOdc {
			position: fixed;
			display: none;
			z-index: 9
		}

		.VfPpkd-suEOdc-sM5MNb-OWXEXe-nzrxxc {
			position: relative
		}

		.VfPpkd-suEOdc-OWXEXe-TSZdd,
		.VfPpkd-suEOdc-OWXEXe-eo9XGd,
		.VfPpkd-suEOdc-OWXEXe-ZYIfFd {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex
		}

		.VfPpkd-suEOdc-OWXEXe-TSZdd.VfPpkd-suEOdc-OWXEXe-nzrxxc,
		.VfPpkd-suEOdc-OWXEXe-eo9XGd.VfPpkd-suEOdc-OWXEXe-nzrxxc,
		.VfPpkd-suEOdc-OWXEXe-ZYIfFd.VfPpkd-suEOdc-OWXEXe-nzrxxc {
			display: inline-block;
			left: -320px;
			position: absolute
		}

		.VfPpkd-z59Tgd {
			line-height: 16px;
			padding: 4px 8px;
			min-width: 40px;
			max-width: 200px;
			min-height: 24px;
			max-height: 40vh;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			overflow: hidden;
			text-align: center
		}

		.VfPpkd-z59Tgd::before {
			position: absolute;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			border: 1px solid transparent;
			border-radius: inherit;
			content: "";
			pointer-events: none
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-z59Tgd::before {
				border-color: CanvasText
			}
		}

		.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd {
			-webkit-box-align: start;
			-webkit-align-items: flex-start;
			align-items: flex-start;
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-orient: vertical;
			-webkit-box-direction: normal;
			-webkit-flex-direction: column;
			flex-direction: column;
			min-height: 24px;
			min-width: 40px;
			max-width: 320px;
			position: relative
		}

		.VfPpkd-suEOdc-OWXEXe-LlMNQd .VfPpkd-z59Tgd {
			text-align: left
		}

		[dir=rtl] .VfPpkd-suEOdc-OWXEXe-LlMNQd .VfPpkd-z59Tgd,
		.VfPpkd-suEOdc-OWXEXe-LlMNQd .VfPpkd-z59Tgd[dir=rtl] {
			text-align: right
		}

		.VfPpkd-z59Tgd .VfPpkd-MlC99b {
			margin: 0 8px
		}

		.VfPpkd-z59Tgd .VfPpkd-IqDDtd {
			max-width: 184px;
			margin: 8px;
			text-align: left
		}

		[dir=rtl] .VfPpkd-z59Tgd .VfPpkd-IqDDtd,
		.VfPpkd-z59Tgd .VfPpkd-IqDDtd[dir=rtl] {
			text-align: right
		}

		.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd .VfPpkd-IqDDtd {
			max-width: 304px;
			-webkit-align-self: stretch;
			align-self: stretch
		}

		.VfPpkd-z59Tgd .VfPpkd-IqDDtd-hSRGPd {
			text-decoration: none
		}

		.VfPpkd-suEOdc-OWXEXe-nzrxxc-LQLjdd,
		.VfPpkd-IqDDtd,
		.VfPpkd-MlC99b {
			z-index: 1
		}

		.VfPpkd-z59Tgd-OiiCO {
			opacity: 0;
			-webkit-transform: scale(.8);
			-ms-transform: scale(.8);
			-o-transform: scale(.8);
			transform: scale(.8);
			will-change: transform, opacity
		}

		.VfPpkd-suEOdc-OWXEXe-TSZdd .VfPpkd-z59Tgd-OiiCO {
			-webkit-transform: scale(1);
			-ms-transform: scale(1);
			-o-transform: scale(1);
			transform: scale(1);
			opacity: 1
		}

		.VfPpkd-suEOdc-OWXEXe-ZYIfFd .VfPpkd-z59Tgd-OiiCO {
			-webkit-transform: scale(1);
			-ms-transform: scale(1);
			-o-transform: scale(1);
			transform: scale(1)
		}

		.VfPpkd-Djsh7e-XxIAqe-ma6Yeb,
		.VfPpkd-Djsh7e-XxIAqe-cGMI2b {
			position: absolute;
			height: 24px;
			width: 24px;
			-webkit-transform: rotate(35deg) skewY(20deg) scaleX(.9396926208);
			-ms-transform: rotate(35deg) skewY(20deg) scaleX(.9396926208);
			-o-transform: rotate(35deg) skewY(20deg) scaleX(.9396926208);
			transform: rotate(35deg) skewY(20deg) scaleX(.9396926208)
		}

		.VfPpkd-Djsh7e-XxIAqe-ma6Yeb .VfPpkd-BFbNVe-bF1uUb,
		.VfPpkd-Djsh7e-XxIAqe-cGMI2b .VfPpkd-BFbNVe-bF1uUb {
			width: 100%;
			height: 100%;
			top: 0;
			left: 0
		}

		.VfPpkd-Djsh7e-XxIAqe-cGMI2b {
			-webkit-box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .2), 0 2px 2px 0 rgba(0, 0, 0, .14), 0 1px 5px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 3px 1px -2px rgba(0, 0, 0, .2), 0 2px 2px 0 rgba(0, 0, 0, .14), 0 1px 5px 0 rgba(0, 0, 0, .12);
			outline: 1px solid transparent;
			z-index: -1
		}

		@media screen and (forced-colors:active) {
			.VfPpkd-Djsh7e-XxIAqe-cGMI2b {
				outline-color: CanvasText
			}
		}

		.EY8ABd {
			z-index: 2101
		}

		.EY8ABd .VfPpkd-z59Tgd {
			background-color: #3c4043;
			color: #e8eaed
		}

		.EY8ABd .VfPpkd-MlC99b,
		.EY8ABd .VfPpkd-IqDDtd {
			color: #3c4043
		}

		.EY8ABd .VfPpkd-IqDDtd-hSRGPd {
			color: #1a73e8
		}

		.EY8ABd.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd,
		.EY8ABd.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-Djsh7e-XxIAqe-ma6Yeb,
		.EY8ABd.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-Djsh7e-XxIAqe-cGMI2b {
			background-color: #fff
		}

		.EY8ABd.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-MlC99b {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			line-height: 1.25rem;
			font-size: .875rem;
			letter-spacing: .0178571429em;
			font-weight: 500
		}

		.EY8ABd.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd {
			-webkit-border-radius: 8px;
			-moz-border-radius: 8px;
			border-radius: 8px
		}

		.ziykHb {
			z-index: 2101
		}

		.ziykHb .VfPpkd-z59Tgd {
			background-color: #3c4043;
			color: #e8eaed
		}

		.ziykHb .VfPpkd-MlC99b,
		.ziykHb .VfPpkd-IqDDtd {
			color: #3c4043
		}

		.ziykHb .VfPpkd-IqDDtd-hSRGPd {
			color: #1a73e8
		}

		.ziykHb.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd,
		.ziykHb.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-Djsh7e-XxIAqe-ma6Yeb,
		.ziykHb.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-Djsh7e-XxIAqe-cGMI2b {
			background-color: #fff
		}

		.ziykHb.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-MlC99b {
			font-family: "Google Sans", Roboto, Arial, sans-serif;
			line-height: 1.25rem;
			font-size: .875rem;
			letter-spacing: .0178571429em;
			font-weight: 500
		}

		.ziykHb.VfPpkd-suEOdc-OWXEXe-nzrxxc .VfPpkd-z59Tgd {
			-webkit-border-radius: 8px;
			-moz-border-radius: 8px;
			border-radius: 8px
		}

		.EY8ABd-OWXEXe-TAWMXe {
			position: absolute;
			left: -10000px;
			top: auto;
			width: 1px;
			height: 1px;
			overflow: hidden;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none
		}

		html[dir=rtl] .giSqbe {
			-webkit-transform: scaleX(-1);
			-webkit-transform: scaleX(-1);
			-ms-transform: scaleX(-1);
			-o-transform: scaleX(-1);
			transform: scaleX(-1)
		}

		.XjS9D {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex
		}

		.XjS9D .VfPpkd-J1Ukfc-LhBDec {
			border-radius: 22px
		}

		.XjS9D .VfPpkd-J1Ukfc-LhBDec::after {
			border-radius: 24px
		}

		.XjS9D.eLNT1d {
			display: none
		}

		.XjS9D .TrZEUc .WpHeLc {
			position: absolute
		}

		.XjS9D .q6oraf .DMZ54e,
		.XjS9D .BqKGqe {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.875rem;
			font-weight: 500;
			letter-spacing: 0rem;
			line-height: 1.42857143
		}

		.BqKGqe,
		.BqKGqe .VfPpkd-Jh9lGc {
			border-radius: 20px
		}

		.XjS9D .VfPpkd-LgbsSe {
			height: 40px
		}

		@media (orientation:landscape) {
			.XjS9D .VfPpkd-LgbsSe {
				height: 40px
			}
		}

		.Jskylb:not(:disabled) {
			background: #0b57d0;
			background: var(--gm3-sys-color-primary, #0b57d0);
			color: #fff;
			color: var(--gm3-sys-color-on-primary, #fff)
		}

		.pIzcPc:not(:disabled),
		.eR0mzb:not(:disabled) {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.AnSR9d:not(:disabled).VfPpkd-LgbsSe {
			background: #c2e7ff;
			background: var(--gm3-sys-color-secondary-container, #c2e7ff);
			color: #001d35;
			color: var(--gm3-sys-color-on-secondary-container, #001d35)
		}

		.AnSR9d:not(:disabled).VfPpkd-LgbsSe:focus {
			color: var(--gm3-sys-color-on-secondary-container, #001d35)
		}

		.eR0mzb.VfPpkd-LgbsSe {
			min-width: 0
		}

		.eR0mzb.VfPpkd-LgbsSe {
			padding-left: 16px;
			padding-right: 16px
		}

		.H76ePc {
			margin: auto;
			max-width: 380px;
			overflow: hidden;
			position: relative
		}

		.H76ePc .LbOduc {
			position: relative;
			text-align: center
		}

		.JQ5tlb {
			border-radius: 50%;
			color: #444746;
			overflow: hidden
		}

		.pGzURd {
			line-height: 1.42857143
		}

		.lPxAeb {
			width: 100%
		}

		.lPxAeb .JQ5tlb {
			-webkit-box-flex: 0;
			-webkit-flex: none;
			flex: none;
			height: 28px;
			margin-right: 12px;
			width: 28px
		}

		.lPxAeb .LbOduc,
		.VUfHYd .LbOduc {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center
		}

		.lPxAeb .LbOduc {
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center
		}

		.H76ePc .JQ5tlb {
			height: 64px;
			margin: 0 auto 8px;
			width: 64px
		}

		.MnFlu {
			border-radius: 50%;
			display: block
		}

		.lPxAeb .MnFlu,
		.lPxAeb .Qk3oof,
		.lPxAeb .uHLU0 {
			max-height: 100%;
			max-width: 100%
		}

		.H76ePc .MnFlu,
		.H76ePc .Qk3oof,
		.H76ePc .uHLU0 {
			height: 64px;
			width: 64px
		}

		.VUfHYd {
			height: 24px
		}

		.VUfHYd .JQ5tlb {
			margin-right: 8px;
			height: 24px;
			min-width: 24px
		}

		.VUfHYd .MnFlu,
		.VUfHYd .Qk3oof,
		.VUfHYd .uHLU0 {
			color: #444746;
			height: 24px;
			width: 24px
		}

		.VUfHYd .DOLDDf {
			overflow: hidden
		}

		.lPxAeb .DOLDDf {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.lPxAeb .pGzURd {
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 1rem;
			font-weight: 500;
			letter-spacing: 0rem;
			line-height: 1.5
		}

		.H76ePc .pGzURd {
			color: #1f1f1f;
			font-size: 0.875rem
		}

		.yAlK0b,
		.VhdzSd,
		.H2oig {
			direction: ltr;
			font-size: 0.875rem;
			line-height: 1.42857143;
			text-align: left;
			word-break: break-all
		}

		.yAlK0b {
			text-decoration: none
		}

		.lPxAeb .yAlK0b,
		.lPxAeb .VhdzSd,
		.lPxAeb .H2oig {
			font-size: 0.875rem;
			font-weight: 400;
			letter-spacing: 0rem;
			line-height: 1.42857143
		}

		.H2oig {
			color: #444746
		}

		.VUfHYd .yAlK0b {
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.875rem;
			font-weight: 500;
			letter-spacing: 0rem;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap
		}

		.lPxAeb .VhdzSd,
		.lPxAeb .yAlK0b {
			color: #444746
		}

		.lPxAeb .yAlK0b[data-email${'$'}="@glimitedaccount.com"] {
			display: none
		}

		.H76ePc .yAlK0b {
			color: #444746
		}

		.lrLKwc {
			color: #444746;
			font-size: 0.875rem
		}

		.lPxAeb .lrLKwc {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			-webkit-box-flex: 0;
			-webkit-flex: none;
			flex: none;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem;
			line-height: 1.33333333
		}

		.Ahygpe {
			-webkit-align-items: center;
			align-items: center;
			background: #fff;
			border: 1px solid #747775;
			color: #1f1f1f;
			cursor: pointer;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: -ms-inline-flexbox;
			display: inline-flex;
			font-size: 0.875rem;
			font-weight: 500;
			letter-spacing: 0.25px;
			max-width: 100%;
			position: relative
		}

		.Ahygpe:after {
			bottom: -1px;
			border: 1px solid transparent;
			content: "";
			left: -1px;
			position: absolute;
			right: -1px;
			top: -1px
		}

		.Ahygpe:focus,
		.Ahygpe.u3bW4e {
			outline: none
		}

		.Ahygpe:focus-visible::after {
			bottom: -5px;
			border: 2px solid;
			border-radius: 26px;
			content: "";
			left: -5px;
			position: absolute;
			right: -5px;
			top: -5px;
			border-color: #0b57d0;
			border-color: var(--gm3-sys-color-primary, #0b57d0);
			box-shadow: 0 0 0 2px #d3e3fd;
			box-shadow: 0 0 0 2px var(--gm3-sys-color-primary-container, #d3e3fd)
		}

		.Ahygpe:focus,
		.Ahygpe.u3bW4e {
			background: rgba(60, 64, 67, 0.122)
		}

		.Ahygpe:hover {
			background: rgba(60, 64, 67, 0.039)
		}

		.Ahygpe.u3bW4e {
			border-color: #747775
		}

		.Ahygpe.qs41qe {
			color: #1f1f1f;
			background: rgba(60, 64, 67, 0.122);
			border-color: #3c4043
		}

		.Zjyti {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0);
			font-size: 0.75rem
		}

		.m8wwGd {
			-webkit-border-radius: 16px;
			-moz-border-radius: 16px;
			border-radius: 16px;
			padding: 0 15px 0 15px
		}

		.m8wwGd.Zjyti {
			-webkit-border-radius: 12px;
			-moz-border-radius: 12px;
			border-radius: 12px;
			padding: 0 10px 0 10px
		}

		.m8wwGd.EPPJc {
			padding-right: 8px
		}

		.m8wwGd.cd29Sd {
			padding-left: 3px
		}

		.m8wwGd.Zjyti.EPPJc {
			padding-right: 8px
		}

		.m8wwGd.Zjyti.cd29Sd {
			padding-left: 2px
		}

		.m8wwGd:after {
			-webkit-border-radius: 16px;
			-moz-border-radius: 16px;
			border-radius: 16px
		}

		.m8wwGd.Zjyti:after {
			-webkit-border-radius: 12px;
			-moz-border-radius: 12px;
			border-radius: 12px
		}

		.HOE91e {
			-webkit-border-radius: 12px;
			-moz-border-radius: 12px;
			border-radius: 12px;
			height: 24px;
			margin-right: 8px
		}

		.HOE91e .MnFlu,
		.HOE91e .Qk3oof,
		.HOE91e .uHLU0 {
			-webkit-border-radius: 50%;
			-moz-border-radius: 50%;
			border-radius: 50%;
			color: #444746;
			display: block;
			height: 24px;
			width: 24px
		}

		.IxcUte {
			direction: ltr;
			text-align: left;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap
		}

		.m8wwGd .IxcUte {
			line-height: 30px
		}

		.m8wwGd.xNLKcb .IxcUte {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.875rem;
			font-weight: 500;
			letter-spacing: 0rem;
			text-decoration: none
		}

		.m8wwGd.Zjyti .IxcUte {
			line-height: 22px
		}

		.JCl8ie {
			color: #1f1f1f;
			-ms-flex-negative: 0;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			height: 20px;
			margin-left: 5px;
			width: 20px;
			-webkit-transition: transform 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			-o-transition: transform 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			transition: transform 0.2s cubic-bezier(0.4, 0, 0.2, 1)
		}

		.Ahygpe.sMVRZe .JCl8ie {
			-webkit-transform: rotate(180deg);
			-ms-transform: rotate(180deg);
			-o-transform: rotate(180deg);
			transform: rotate(180deg)
		}

		.Zjyti .JCl8ie {
			height: 16px;
			width: 16px
		}

		.u4TTuf {
			display: block;
			height: 100%;
			width: 100%
		}

		.Dzz9Db,
		.GpMPBe {
			height: 25vh;
			position: relative
		}

		@media (min-width:600px) {

			.Dzz9Db,
			.GpMPBe {
				height: 150px
			}
		}

		.Dzz9Db.Irjbwb {
			height: auto
		}

		.GpMPBe {
			margin: 0;
			overflow: hidden
		}

		.UFQPDd,
		.JNOvdd {
			display: block;
			height: 100%;
			margin: 0 auto;
			-o-object-fit: contain;
			object-fit: contain;
			width: 100%
		}

		.f4ZpM {
			display: block;
			height: 100%;
			max-width: 100%;
			min-height: 110px;
			position: relative;
			-webkit-transform: translate(-43%, -3%);
			-ms-transform: translate(-43%, -3%);
			-o-transform: translate(-43%, -3%);
			transform: translate(-43%, -3%);
			width: auto;
			z-index: 3
		}

		.wsArZ[data-ss-mode="1"] .Dzz9Db,
		.wsArZ[data-ss-mode="1"] .f4ZpM {
			height: auto;
			width: 100%
		}

		.wsArZ[data-ss-mode="1"] .f4ZpM {
			max-width: 400px
		}

		@media (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {

			.NQ5OL .Dzz9Db,
			.NQ5OL .f4ZpM {
				height: auto;
				width: 100%
			}

			.NQ5OL .f4ZpM {
				max-width: 400px
			}
		}

		.Dzz9Db.utFBGf,
		.Dzz9Db.utFBGf .f4ZpM {
			height: auto
		}

		.Dzz9Db.utFBGf .f4ZpM {
			height: auto;
			max-width: 312px;
			width: 100%
		}

		.Dzz9Db.utFBGf.zpCp3 .f4ZpM {
			max-width: unset
		}

		.Dzz9Db.IiQozc .f4ZpM {
			margin: 0 auto;
			-webkit-transform: none;
			-ms-transform: none;
			-o-transform: none;
			transform: none
		}

		.Dzz9Db.Irjbwb .f4ZpM {
			height: auto;
			width: 100%
		}

		.nPt1pc {
			background-image: -webkit-gradient(linear, left top, left bottom, from(rgba(233, 233, 233, 0)), color-stop(62.22%, rgba(233, 233, 233, 0)), color-stop(40.22%, rgb(233, 233, 233)), to(rgba(233, 233, 233, 0)));
			background-image: -webkit-linear-gradient(top, rgba(233, 233, 233, 0) 0, rgba(233, 233, 233, 0) 62.22%, rgb(233, 233, 233) 40.22%, rgba(233, 233, 233, 0) 100%);
			background-image: linear-gradient(to bottom, rgba(233, 233, 233, 0) 0, rgba(233, 233, 233, 0) 62.22%, rgb(233, 233, 233) 40.22%, rgba(233, 233, 233, 0) 100%);
			height: 100%;
			left: 0;
			overflow: hidden;
			position: absolute;
			right: 0;
			top: 0;
			z-index: 2
		}

		.nPt1pc:after,
		.nPt1pc:before {
			content: "";
			display: block;
			height: 100%;
			min-width: 110px;
			position: absolute;
			right: -10%;
			-webkit-transform: rotate(-104deg);
			-ms-transform: rotate(-104deg);
			-o-transform: rotate(-104deg);
			transform: rotate(-104deg);
			width: 25vh;
			z-index: 2
		}

		@media (min-width:600px) {

			.nPt1pc:after,
			.nPt1pc:before {
				width: 150px
			}
		}

		.nPt1pc:before {
			background-image: -webkit-gradient(linear, left top, left bottom, from(rgba(243, 243, 243, 0)), to(rgba(243, 243, 243, .9)));
			background-image: -webkit-linear-gradient(top, rgba(243, 243, 243, 0) 0, rgba(243, 243, 243, .9) 100%);
			background-image: linear-gradient(to bottom, rgba(243, 243, 243, 0) 0, rgba(243, 243, 243, .9) 100%);
			bottom: -10%
		}

		.nPt1pc:after {
			background-image: -webkit-gradient(linear, left top, left bottom, from(rgba(255, 255, 255, 0)), to(rgba(255, 255, 255, .9)));
			background-image: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 0, rgba(255, 255, 255, .9) 100%);
			background-image: linear-gradient(to bottom, rgba(255, 255, 255, 0) 0, rgba(255, 255, 255, .9) 100%);
			bottom: -80%
		}

		.wsArZ[data-ss-mode="1"] .nPt1pc~.f4ZpM {
			width: auto
		}

		@media (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .nPt1pc~.f4ZpM {
				width: auto
			}
		}

		.ZS7CGc {
			height: auto
		}

		.qiRZ5e {
			-webkit-transform: translate(-9%, -3%);
			-ms-transform: translate(-9%, -3%);
			-o-transform: translate(-9%, -3%);
			transform: translate(-9%, -3%)
		}

		.vIv7Gf {
			left: -40%;
			margin: auto;
			max-height: 230px;
			right: 0;
			top: -3%;
			-webkit-transform: none;
			-ms-transform: none;
			-o-transform: none;
			transform: none
		}

		.nvYXVd {
			-webkit-transform: translate(9%, -3%);
			-ms-transform: translate(9%, -3%);
			-o-transform: translate(9%, -3%);
			transform: translate(9%, -3%)
		}

		.uOhnzd {
			-webkit-transform: translate(24px, 0);
			-ms-transform: translate(24px, 0);
			-o-transform: translate(24px, 0);
			transform: translate(24px, 0)
		}

		.MsYMaf {
			-webkit-transform: translate(0, 0);
			-ms-transform: translate(0, 0);
			-o-transform: translate(0, 0);
			transform: translate(0, 0)
		}

		.Dzz9Db.YIi9qf {
			height: 15vh;
			max-height: 137px;
			min-height: 112px;
			padding-bottom: 12px
		}

		.Dzz9Db.YIi9qf .f4ZpM {
			min-height: 100%
		}

		.QG3Xbe {
			max-width: 300px
		}

		.F6gtje {
			-webkit-transform: none;
			-ms-transform: none;
			-o-transform: none;
			transform: none
		}

		.rFrNMe {
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			-webkit-tap-highlight-color: transparent;
			display: inline-block;
			outline: none;
			padding-bottom: 8px;
			width: 200px
		}

		.aCsJod {
			height: 40px;
			position: relative;
			vertical-align: top
		}

		.aXBtI {
			display: -webkit-box;
			display: -webkit-flex;
			display: -moz-box;
			display: -ms-flexbox;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			position: relative;
			top: 14px
		}

		.Xb9hP {
			display: -webkit-box;
			display: -webkit-flex;
			display: -moz-box;
			display: -ms-flexbox;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			-moz-box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			-webkit-flex-shrink: 1;
			-ms-flex-negative: 1;
			-ms-flex-negative: 1;
			-webkit-flex-shrink: 1;
			flex-shrink: 1;
			min-width: 0%;
			position: relative
		}

		.A37UZe {
			-moz-box-sizing: border-box;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			height: 24px;
			line-height: 24px;
			position: relative
		}

		.qgcB3c:not(:empty) {
			padding-right: 12px
		}

		.sxyYjd:not(:empty) {
			padding-left: 12px
		}

		.whsOnd {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			-moz-box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			-webkit-flex-shrink: 1;
			-ms-flex-negative: 1;
			-ms-flex-negative: 1;
			-webkit-flex-shrink: 1;
			flex-shrink: 1;
			background-color: transparent;
			border: none;
			display: block;
			font: 400 16px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			height: 24px;
			line-height: 24px;
			margin: 0;
			min-width: 0%;
			outline: none;
			padding: 0;
			z-index: 0
		}

		.rFrNMe.dm7YTc .whsOnd {
			color: #fff
		}

		.whsOnd:invalid,
		.whsOnd:-moz-submit-invalid,
		.whsOnd:-moz-ui-invalid {
			-webkit-box-shadow: none;
			-moz-box-shadow: none;
			box-shadow: none
		}

		.I0VJ4d>.whsOnd::-ms-clear,
		.I0VJ4d>.whsOnd::-ms-reveal {
			display: none
		}

		.i9lrp {
			background-color: rgba(0, 0, 0, .12);
			bottom: -2px;
			height: 1px;
			left: 0;
			margin: 0;
			padding: 0;
			position: absolute;
			width: 100%
		}

		.i9lrp:before {
			content: "";
			position: absolute;
			top: 0;
			bottom: -2px;
			left: 0;
			right: 0;
			border-bottom: 1px solid rgba(0, 0, 0, 0);
			pointer-events: none
		}

		.rFrNMe.dm7YTc .i9lrp {
			background-color: rgba(255, 255, 255, .7)
		}

		.OabDMe {
			-webkit-transform: scaleX(0);
			-webkit-transform: scaleX(0);
			-ms-transform: scaleX(0);
			-o-transform: scaleX(0);
			transform: scaleX(0);
			background-color: #4285f4;
			bottom: -2px;
			height: 2px;
			left: 0;
			margin: 0;
			padding: 0;
			position: absolute;
			width: 100%
		}

		.rFrNMe.dm7YTc .OabDMe {
			background-color: #a1c2fa
		}

		.rFrNMe.k0tWj .i9lrp,
		.rFrNMe.k0tWj .OabDMe {
			background-color: #d50000;
			height: 2px
		}

		.rFrNMe.k0tWj.dm7YTc .i9lrp,
		.rFrNMe.k0tWj.dm7YTc .OabDMe {
			background-color: #e06055
		}

		.whsOnd[disabled] {
			color: rgba(0, 0, 0, .38)
		}

		.rFrNMe.dm7YTc .whsOnd[disabled] {
			color: rgba(255, 255, 255, .5)
		}

		.whsOnd[disabled]~.i9lrp {
			background: none;
			border-bottom: 1px dotted rgba(0, 0, 0, .38)
		}

		.OabDMe.Y2Zypf {
			-webkit-animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-o-animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1)
		}

		.rFrNMe.u3bW4e .OabDMe {
			-webkit-animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-o-animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-transform: scaleX(1);
			-webkit-transform: scaleX(1);
			-ms-transform: scaleX(1);
			-o-transform: scaleX(1);
			transform: scaleX(1)
		}

		.rFrNMe.sdJrJc>.aCsJod {
			padding-top: 24px
		}

		.AxOyFc {
			-webkit-transform-origin: bottom left;
			-webkit-transform-origin: bottom left;
			-ms-transform-origin: bottom left;
			-o-transform-origin: bottom left;
			transform-origin: bottom left;
			-webkit-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			-o-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-transition-property: color, bottom, -webkit-transform;
			-webkit-transition-property: color, bottom, -webkit-transform;
			-o-transition-property: color, bottom, -webkit-transform;
			transition-property: color, bottom, -webkit-transform;
			-webkit-transition-property: color, bottom, transform;
			-o-transition-property: color, bottom, transform;
			transition-property: color, bottom, transform;
			-webkit-transition-property: color, bottom, transform, -webkit-transform;
			-o-transition-property: color, bottom, transform, -webkit-transform;
			transition-property: color, bottom, transform, -webkit-transform;
			color: rgba(0, 0, 0, .38);
			font: 400 16px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			font-size: 16px;
			pointer-events: none;
			position: absolute;
			bottom: 3px;
			left: 0;
			width: 100%
		}

		.whsOnd:not([disabled]):focus~.AxOyFc,
		.whsOnd[badinput=true]~.AxOyFc,
		.rFrNMe.CDELXb .AxOyFc,
		.rFrNMe.dLgj8b .AxOyFc {
			-webkit-transform: scale(0.75) translateY(-39px);
			-webkit-transform: scale(0.75) translateY(-39px);
			-ms-transform: scale(0.75) translateY(-39px);
			-o-transform: scale(0.75) translateY(-39px);
			transform: scale(0.75) translateY(-39px)
		}

		.whsOnd:not([disabled]):focus~.AxOyFc {
			color: #3367d6
		}

		.rFrNMe.dm7YTc .whsOnd:not([disabled]):focus~.AxOyFc {
			color: #a1c2fa
		}

		.rFrNMe.k0tWj .whsOnd:not([disabled]):focus~.AxOyFc {
			color: #d50000
		}

		.ndJi5d {
			color: rgba(0, 0, 0, .38);
			font: 400 16px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			max-width: 100%;
			overflow: hidden;
			pointer-events: none;
			position: absolute;
			text-overflow: ellipsis;
			top: 2px;
			left: 0;
			white-space: nowrap
		}

		.rFrNMe.CDELXb .ndJi5d {
			display: none
		}

		.K0Y8Se {
			-webkit-tap-highlight-color: transparent;
			font: 400 12px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			height: 16px;
			margin-left: auto;
			padding-left: 16px;
			padding-top: 8px;
			pointer-events: none;
			opacity: .3;
			white-space: nowrap
		}

		.rFrNMe.dm7YTc .AxOyFc,
		.rFrNMe.dm7YTc .K0Y8Se,
		.rFrNMe.dm7YTc .ndJi5d {
			color: rgba(255, 255, 255, .7)
		}

		.rFrNMe.Tyc9J {
			padding-bottom: 4px
		}

		.dEOOab,
		.ovnfwe:not(:empty) {
			-webkit-tap-highlight-color: transparent;
			-webkit-box-flex: 1;
			-webkit-flex: 1 1 auto;
			-moz-box-flex: 1;
			-ms-flex: 1 1 auto;
			-webkit-box-flex: 1 1 auto;
			-moz-box-flex: 1 1 auto;
			-ms-flex: 1 1 auto;
			-webkit-flex: 1 1 auto;
			flex: 1 1 auto;
			font: 400 12px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			min-height: 16px;
			padding-top: 8px
		}

		.LXRPh {
			display: -webkit-box;
			display: -webkit-flex;
			display: -moz-box;
			display: -ms-flexbox;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex
		}

		.ovnfwe {
			pointer-events: none
		}

		.dEOOab {
			color: #d50000
		}

		.rFrNMe.dm7YTc .dEOOab,
		.rFrNMe.dm7YTc.k0tWj .whsOnd:not([disabled]):focus~.AxOyFc {
			color: #e06055
		}

		.ovnfwe {
			opacity: .3
		}

		.rFrNMe.dm7YTc .ovnfwe {
			color: rgba(255, 255, 255, .7);
			opacity: 1
		}

		.rFrNMe.k0tWj .ovnfwe,
		.rFrNMe:not(.k0tWj) .ovnfwe:not(:empty)+.dEOOab {
			display: none
		}

		@-webkit-keyframes quantumWizPaperInputRemoveUnderline {
			0% {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 1
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 0
			}
		}

		@keyframes quantumWizPaperInputRemoveUnderline {
			0% {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 1
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 0
			}
		}

		@-webkit-keyframes quantumWizPaperInputAddUnderline {
			0% {
				-webkit-transform: scaleX(0);
				-webkit-transform: scaleX(0);
				-ms-transform: scaleX(0);
				-o-transform: scaleX(0);
				transform: scaleX(0)
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1)
			}
		}

		@keyframes quantumWizPaperInputAddUnderline {
			0% {
				-webkit-transform: scaleX(0);
				-webkit-transform: scaleX(0);
				-ms-transform: scaleX(0);
				-o-transform: scaleX(0);
				transform: scaleX(0)
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1)
			}
		}

		@media all and (min-width:600px) {
			.njnYzb.DbQnIe .YqLCIe {
				display: flex;
				justify-content: space-between
			}
		}

		.njnYzb:first-child .H2p7Gf:first-child .i79UJc {
			padding-top: 8px
		}

		@media all and (min-width:600px) {
			.njnYzb.DbQnIe:first-child .H2p7Gf .i79UJc {
				padding-top: 8px
			}

			.njnYzb.DbQnIe .H2p7Gf {
				-webkit-box-flex: 1;
				box-flex: 1;
				-ms-flex-positive: 1;
				-webkit-flex-grow: 1;
				flex-grow: 1;
				margin-right: 8px;
				width: 0
			}

			.njnYzb.DbQnIe .H2p7Gf:last-child {
				margin-right: 0
			}
		}

		.i79UJc.i79UJc {
			-webkit-box-sizing: content-box;
			box-sizing: content-box
		}

		.i79UJc {
			padding-bottom: 0;
			padding-top: 24px;
			width: 100%
		}

		.i79UJc .oJeWuf.oJeWuf {
			height: 56px;
			padding-top: 0
		}

		.i79UJc.OcVpRe .oJeWuf.oJeWuf {
			height: 36px
		}

		.i79UJc .Wic03c {
			-webkit-align-items: center;
			align-items: center;
			position: static
		}

		.i79UJc .snByac {
			background-color: transparent;
			bottom: 18px;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			color: #444746;
			font-size: 16px;
			font-weight: 400;
			left: 8px;
			max-width: -webkit-calc(100% - (2*8px));
			max-width: -moz-calc(100% - (2*8px));
			max-width: calc(100% - (2*8px));
			overflow: hidden;
			padding: 0 8px;
			text-overflow: ellipsis;
			-webkit-transition: transform .15s cubic-bezier(.4, 0, .2, 1), opacity .15s cubic-bezier(.4, 0, .2, 1), background-color .15s cubic-bezier(.4, 0, .2, 1);
			-o-transition: transform .15s cubic-bezier(.4, 0, .2, 1), opacity .15s cubic-bezier(.4, 0, .2, 1), background-color .15s cubic-bezier(.4, 0, .2, 1);
			transition: transform .15s cubic-bezier(.4, 0, .2, 1), opacity .15s cubic-bezier(.4, 0, .2, 1), background-color .15s cubic-bezier(.4, 0, .2, 1);
			white-space: nowrap;
			width: auto;
			z-index: 1
		}

		.i79UJc.OcVpRe .snByac {
			bottom: 10px;
			color: #444746;
			font-size: 14px;
			left: 4px;
			line-height: 16px;
			padding: 0 6px
		}

		.i79UJc.u3bW4e .snByac.snByac,
		.i79UJc.CDELXb .snByac.snByac {
			background-color: #fff;
			-webkit-transform: scale(.75) translatey(-41px);
			-ms-transform: scale(.75) translatey(-41px);
			-o-transform: scale(.75) translatey(-41px);
			transform: scale(.75) translatey(-41px)
		}

		.i79UJc.OcVpRe.u3bW4e .snByac,
		.i79UJc.OcVpRe.CDELXb .snByac {
			-webkit-transform: scale(.75) translatey(-165%);
			-ms-transform: scale(.75) translatey(-165%);
			-o-transform: scale(.75) translatey(-165%);
			transform: scale(.75) translatey(-165%)
		}

		.i79UJc .zHQkBf:not([disabled]):focus~.snByac {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.i79UJc.IYewr.u3bW4e .zHQkBf:not([disabled])~.snByac,
		.i79UJc.IYewr.CDELXb .zHQkBf:not([disabled])~.snByac {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.i79UJc .zHQkBf {
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 16px;
			height: 28px;
			margin: 2px;
			padding: 12px 14px;
			z-index: 1
		}

		.i79UJc.OcVpRe .zHQkBf {
			font-size: 14px;
			height: 20px;
			padding: 6px 8px
		}

		.i79UJc.YKooDc .zHQkBf,
		.i79UJc.YKooDc .MQL3Ob {
			direction: ltr;
			text-align: left
		}

		.i79UJc .iHd5yb {
			padding-left: 14px
		}

		.i79UJc.OcVpRe .iHd5yb {
			padding-left: 8px
		}

		.i79UJc .MQL3Ob {
			padding-right: 14px;
			z-index: 1
		}

		.i79UJc.OcVpRe .MQL3Ob {
			padding-right: 8px
		}

		.i79UJc .mIZh1c,
		.i79UJc .cXrdqd {
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
			-webkit-box-sizing: border-box;
			box-sizing: border-box
		}

		.i79UJc .mIZh1c,
		.i79UJc .cXrdqd,
		.i79UJc.IYewr .mIZh1c,
		.i79UJc.IYewr .cXrdqd {
			background-color: transparent;
			bottom: 0;
			height: auto;
			top: 0
		}

		.i79UJc .mIZh1c {
			border: 1px solid #747775;
			padding: 1px
		}

		.i79UJc .cXrdqd {
			border: 1px solid;
			border-color: #0b57d0;
			border-color: var(--gm3-sys-color-primary, #0b57d0);
			opacity: 0;
			-webkit-transform: none;
			-ms-transform: none;
			-o-transform: none;
			transform: none;
			-webkit-transition: opacity .15s cubic-bezier(.4, 0, .2, 1);
			-o-transition: opacity .15s cubic-bezier(.4, 0, .2, 1);
			transition: opacity .15s cubic-bezier(.4, 0, .2, 1)
		}

		.i79UJc.u3bW4e .cXrdqd {
			border-width: 2px;
			-webkit-animation: none;
			-o-animation: none;
			animation: none;
			opacity: 1
		}

		.i79UJc.IYewr .cXrdqd {
			-webkit-animation: none;
			-o-animation: none;
			animation: none;
			opacity: 1;
			border-color: #b3261e;
			border-color: var(--gm3-sys-color-error, #b3261e)
		}

		.i79UJc .ndJi5d,
		.i79UJc .ovnfwe {
			pointer-events: auto
		}

		.i79UJc .RxsGPe,
		.i79UJc .Is7Fhb {
			display: none
		}

		.Ly8vae {
			color: #444746;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem;
			line-height: 1.33333333
		}

		.Ly8vae:empty,
		.NdBX9e:empty {
			display: none
		}

		.njnYzb.Jj6Lae .Ly8vae {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.jEOsLc {
			display: none;
			margin-right: 8px
		}

		.JPqhye {
			height: 16px;
			width: 16px
		}

		.njnYzb.Jj6Lae .jEOsLc {
			display: block
		}

		.njnYzb .Ly8vae {
			color: #444746;
			margin-top: 4px
		}

		.njnYzb .YQOsOe {
			margin-left: 16px
		}

		.njnYzb.OcVpRe .YQOsOe {
			margin-left: 10px
		}

		.Ekjuhf {
			-webkit-align-items: flex-start;
			align-items: flex-start;
			color: #444746;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem;
			line-height: 1.33333333;
			margin-top: 2px
		}

		.Ekjuhf.Jj6Lae {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.AfGCob {
			margin-right: 8px;
			margin-top: -2px
		}

		.xTjuxe {
			display: block;
			height: 16px;
			width: 16px
		}

		.edhGSc {
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			-webkit-tap-highlight-color: transparent;
			display: inline-block;
			outline: none;
			padding-bottom: 8px
		}

		.RpC4Ne {
			min-height: 1.5em;
			position: relative;
			vertical-align: top
		}

		.Pc9Gce {
			display: -webkit-box;
			display: -webkit-flex;
			display: -moz-box;
			display: -ms-flexbox;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			position: relative;
			padding-top: 14px
		}

		.KHxj8b {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			-moz-box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			-webkit-flex-shrink: 1;
			-ms-flex-negative: 1;
			-ms-flex-negative: 1;
			-webkit-flex-shrink: 1;
			flex-shrink: 1;
			background-color: transparent;
			border: none;
			display: block;
			font: 400 16px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			height: 24px;
			min-height: 24px;
			line-height: 24px;
			margin: 0;
			outline: none;
			padding: 0;
			resize: none;
			white-space: pre-wrap;
			word-wrap: break-word;
			z-index: 0;
			overflow-y: visible;
			overflow-x: hidden
		}

		.KHxj8b.VhWN2c {
			text-align: center
		}

		.edhGSc.dm7YTc .KHxj8b {
			color: rgba(255, 255, 255, .87)
		}

		.edhGSc.u3bW4e.dm7YTc .KHxj8b {
			color: #fff
		}

		.z0oSpf {
			background-color: rgba(0, 0, 0, .12);
			height: 1px;
			left: 0;
			margin: 0;
			padding: 0;
			position: absolute;
			width: 100%
		}

		.edhGSc.dm7YTc>.RpC4Ne>.z0oSpf {
			background-color: rgba(255, 255, 255, .12)
		}

		.Bfurwb {
			-webkit-transform: scaleX(0);
			-webkit-transform: scaleX(0);
			-ms-transform: scaleX(0);
			-o-transform: scaleX(0);
			transform: scaleX(0);
			background-color: #4285f4;
			height: 2px;
			left: 0;
			margin: 0;
			padding: 0;
			position: absolute;
			width: 100%
		}

		.edhGSc.k0tWj>.RpC4Ne>.z0oSpf,
		.edhGSc.k0tWj>.RpC4Ne>.Bfurwb {
			background-color: #d50000;
			height: 2px
		}

		.edhGSc.k0tWj.dm7YTc>.RpC4Ne>.z0oSpf,
		.edhGSc.k0tWj.dm7YTc>.RpC4Ne>.Bfurwb {
			background-color: #ff6e6e
		}

		.edhGSc.RDPZE .KHxj8b {
			color: rgba(0, 0, 0, .38)
		}

		.edhGSc.RDPZE>.RpC4Ne>.z0oSpf {
			background: none;
			border-bottom: 1px dotted rgba(0, 0, 0, .38)
		}

		.Bfurwb.Y2Zypf {
			-webkit-animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-o-animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			animation: quantumWizPaperInputRemoveUnderline .3s cubic-bezier(0.4, 0, 0.2, 1)
		}

		.edhGSc.u3bW4e>.RpC4Ne>.Bfurwb {
			-webkit-animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-o-animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			animation: quantumWizPaperInputAddUnderline .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-transform: scaleX(1);
			-webkit-transform: scaleX(1);
			-ms-transform: scaleX(1);
			-o-transform: scaleX(1);
			transform: scaleX(1)
		}

		.edhGSc.FPYHkb>.RpC4Ne {
			padding-top: 24px
		}

		.fqp6hd {
			-webkit-transform-origin: top left;
			-webkit-transform-origin: top left;
			-ms-transform-origin: top left;
			-o-transform-origin: top left;
			transform-origin: top left;
			-webkit-transform: translate(0, -22px);
			-webkit-transform: translate(0, -22px);
			-ms-transform: translate(0, -22px);
			-o-transform: translate(0, -22px);
			transform: translate(0, -22px);
			-webkit-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			-o-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
			-webkit-transition-property: color, top, -webkit-transform;
			-webkit-transition-property: color, top, -webkit-transform;
			-o-transition-property: color, top, -webkit-transform;
			transition-property: color, top, -webkit-transform;
			-webkit-transition-property: color, top, transform;
			-o-transition-property: color, top, transform;
			transition-property: color, top, transform;
			-webkit-transition-property: color, top, transform, -webkit-transform;
			-o-transition-property: color, top, transform, -webkit-transform;
			transition-property: color, top, transform, -webkit-transform;
			color: rgba(0, 0, 0, .38);
			font: 400 16px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			font-size: 16px;
			pointer-events: none;
			position: absolute;
			top: 100%;
			width: 100%
		}

		.edhGSc.u3bW4e>.RpC4Ne>.fqp6hd,
		.edhGSc.CDELXb>.RpC4Ne>.fqp6hd,
		.edhGSc.LydCob .fqp6hd {
			-webkit-transform: scale(0.75);
			-webkit-transform: scale(0.75);
			-ms-transform: scale(0.75);
			-o-transform: scale(0.75);
			transform: scale(0.75);
			top: 16px
		}

		.edhGSc.dm7YTc>.RpC4Ne>.fqp6hd {
			color: rgba(255, 255, 255, .38)
		}

		.edhGSc.u3bW4e>.RpC4Ne>.fqp6hd,
		.edhGSc.u3bW4e.dm7YTc>.RpC4Ne>.fqp6hd {
			color: #4285f4
		}

		.F1pOBe {
			color: rgba(0, 0, 0, .38);
			font: 400 16px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			max-width: 100%;
			overflow: hidden;
			pointer-events: none;
			position: absolute;
			bottom: 3px;
			text-overflow: ellipsis;
			white-space: nowrap
		}

		.edhGSc.dm7YTc .F1pOBe {
			color: rgba(255, 255, 255, .38)
		}

		.edhGSc.CDELXb>.RpC4Ne>.F1pOBe {
			display: none
		}

		.S1BUyf {
			-webkit-tap-highlight-color: transparent;
			font: 400 12px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			height: 16px;
			margin-left: auto;
			padding-left: 16px;
			padding-top: 8px;
			pointer-events: none;
			text-align: right;
			color: rgba(0, 0, 0, .38);
			white-space: nowrap
		}

		.edhGSc.dm7YTc>.S1BUyf {
			color: rgba(255, 255, 255, .38)
		}

		.edhGSc.wrxyb {
			padding-bottom: 4px
		}

		.v6odTb,
		.YElZX:not(:empty) {
			-webkit-tap-highlight-color: transparent;
			-webkit-box-flex: 1;
			-webkit-flex: 1 1 auto;
			-moz-box-flex: 1;
			-ms-flex: 1 1 auto;
			-webkit-box-flex: 1 1 auto;
			-moz-box-flex: 1 1 auto;
			-ms-flex: 1 1 auto;
			-webkit-flex: 1 1 auto;
			flex: 1 1 auto;
			font: 400 12px Roboto, RobotoDraft, Helvetica, Arial, sans-serif;
			min-height: 16px;
			padding-top: 8px
		}

		.edhGSc.wrxyb .jE8NUc {
			display: -webkit-box;
			display: -webkit-flex;
			display: -moz-box;
			display: -ms-flexbox;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex
		}

		.YElZX {
			pointer-events: none
		}

		.v6odTb {
			color: #d50000
		}

		.edhGSc.dm7YTc .v6odTb {
			color: #ff6e6e
		}

		.YElZX {
			opacity: .3
		}

		.edhGSc.k0tWj .YElZX,
		.edhGSc:not(.k0tWj) .YElZX:not(:empty)+.v6odTb {
			display: none
		}

		@-webkit-keyframes quantumWizPaperInputRemoveUnderline {
			0% {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 1
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 0
			}
		}

		@keyframes quantumWizPaperInputRemoveUnderline {
			0% {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 1
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 0
			}
		}

		@-webkit-keyframes quantumWizPaperInputAddUnderline {
			0% {
				-webkit-transform: scaleX(0);
				-webkit-transform: scaleX(0);
				-ms-transform: scaleX(0);
				-o-transform: scaleX(0);
				transform: scaleX(0)
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1)
			}
		}

		@keyframes quantumWizPaperInputAddUnderline {
			0% {
				-webkit-transform: scaleX(0);
				-webkit-transform: scaleX(0);
				-ms-transform: scaleX(0);
				-o-transform: scaleX(0);
				transform: scaleX(0)
			}

			to {
				-webkit-transform: scaleX(1);
				-webkit-transform: scaleX(1);
				-ms-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1)
			}
		}

		.X3mtXb {
			-webkit-box-sizing: content-box;
			box-sizing: content-box
		}

		.FAiUob,
		.X3mtXb {
			display: block;
			padding: 16px 0 0;
			width: 100%
		}

		.AFTWye.OcVpRe .X3mtXb,
		.AFTWye.OcVpRe .FAiUob {
			padding: 24px 0 0;
			padding-bottom: 0
		}

		:first-child>.X3mtXb,
		:first-child>.FAiUob,
		:first-child.OcVpRe>.X3mtXb,
		:first-child.OcVpRe>.FAiUob {
			padding: 8px 0 0
		}

		.AFTWye .X3mtXb .oJeWuf {
			height: 56px;
			padding-top: 0
		}

		.AFTWye.OcVpRe .X3mtXb .oJeWuf {
			height: 36px
		}

		.X3mtXb .Wic03c {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			position: static;
			top: 0
		}

		.X3mtXb .snByac {
			background: #fff;
			bottom: 17px;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			color: #444746;
			font-size: 16px;
			font-weight: 400;
			left: 8px;
			max-width: calc(100% - 16px);
			overflow: hidden;
			padding: 0 8px;
			text-overflow: ellipsis;
			-webkit-transition: opacity .15s cubic-bezier(.4, 0, .2, 1), -webkit-transform .15s cubic-bezier(.4, 0, .2, 1);
			transition: opacity .15s cubic-bezier(.4, 0, .2, 1), -webkit-transform .15s cubic-bezier(.4, 0, .2, 1);
			-o-transition: opacity .15s cubic-bezier(.4, 0, .2, 1), -o-transform .15s cubic-bezier(.4, 0, .2, 1);
			transition: transform .15s cubic-bezier(.4, 0, .2, 1), opacity .15s cubic-bezier(.4, 0, .2, 1);
			transition: transform .15s cubic-bezier(.4, 0, .2, 1), opacity .15s cubic-bezier(.4, 0, .2, 1), -webkit-transform .15s cubic-bezier(.4, 0, .2, 1), -o-transform .15s cubic-bezier(.4, 0, .2, 1);
			white-space: nowrap;
			width: auto;
			z-index: 1
		}

		.X3mtXb.IYewr.u3bW4e .zHQkBf:not([disabled])~.snByac {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.AFTWye.OcVpRe .X3mtXb .snByac {
			bottom: 9px;
			color: #444746;
			font-size: 14px;
			left: 4px;
			line-height: 16px;
			padding: 0 6px
		}

		.AFTWye.OcVpRe .u3bW4e .snByac,
		.AFTWye.OcVpRe .CDELXb .snByac {
			-webkit-transform: scale(.75) translateY(-155%);
			-ms-transform: scale(.75) translateY(-155%);
			-o-transform: scale(.75) translateY(-155%);
			transform: scale(.75) translateY(-155%)
		}

		.X3mtXb .ndJi5d {
			top: inherit
		}

		.X3mtXb .ndJi5d,
		.X3mtXb .ovnfwe {
			pointer-events: auto
		}

		.X3mtXb .Is7Fhb,
		.X3mtXb .RxsGPe {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem;
			line-height: 1.33333333;
			opacity: 1;
			padding-top: 4px
		}

		.AFTWye .Is7Fhb {
			color: #444746;
			margin-left: 16px
		}

		.AFTWye.OcVpRe .Is7Fhb {
			margin-left: 10px
		}

		.X3mtXb .RxsGPe {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.X3mtXb .Is7Fhb:empty,
		.X3mtXb .RxsGPe:empty {
			display: none
		}

		.X3mtXb .zHQkBf {
			border-radius: 4px;
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 16px;
			height: 28px;
			margin: 1px 1px 0 1px;
			padding: 13px 15px;
			width: 100%;
			z-index: 1
		}

		.X3mtXb.u3bW4e .zHQkBf,
		.X3mtXb.IYewr .zHQkBf {
			margin: 2px 2px 0 2px;
			padding: 12px 14px
		}

		.AFTWye.OcVpRe .X3mtXb .zHQkBf {
			font-size: 14px;
			height: 20px;
			padding: 7px 9px
		}

		.AFTWye.OcVpRe .u3bW4e .zHQkBf,
		.AFTWye.OcVpRe .IYewr .zHQkBf {
			height: 20px;
			padding: 6px 8px
		}

		.UOsO2 .Wic03c,
		.UOsO2 .zHQkBf,
		.UOsO2 .iHd5yb,
		.UOsO2 .MQL3Ob {
			direction: ltr;
			text-align: left
		}

		.UOsO2 .Wic03c .snByac {
			direction: ltr
		}

		.X3mtXb .iHd5yb {
			padding-left: 15px
		}

		.X3mtXb.u3bW4e .iHd5yb {
			padding-left: 14px
		}

		.X3mtXb .MQL3Ob {
			padding-right: 15px;
			z-index: 1
		}

		.X3mtXb.u3bW4e .MQL3Ob {
			padding-right: 15px
		}

		.AFTWye.OcVpRe .X3mtXb .iHd5yb {
			padding-left: 9px
		}

		.AFTWye.OcVpRe .X3mtXb.u3bW4e .iHd5yb {
			padding-left: 8px
		}

		.AFTWye.OcVpRe .X3mtXb .MQL3Ob,
		.AFTWye.OcVpRe .X3mtXb.u3bW4e .MQL3Ob {
			padding-right: 9px
		}

		.X3mtXb .AxOyFc {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif
		}

		.X3mtXb .whsOnd:not([disabled]):focus~.AxOyFc {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.X3mtXb .mIZh1c {
			border: 1px solid #747775;
			border-radius: 4px;
			bottom: 0;
			-webkit-box-sizing: border-box;
			box-sizing: border-box
		}

		.X3mtXb .cXrdqd {
			border-radius: 4px;
			bottom: 0;
			opacity: 0;
			-webkit-transform: none;
			-ms-transform: none;
			-o-transform: none;
			transform: none;
			-webkit-transition: opacity .15s cubic-bezier(.4, 0, .2, 1);
			-o-transition: opacity .15s cubic-bezier(.4, 0, .2, 1);
			transition: opacity .15s cubic-bezier(.4, 0, .2, 1);
			width: calc(100% - 4px)
		}

		.X3mtXb .mIZh1c,
		.X3mtXb .cXrdqd,
		.X3mtXb.IYewr .mIZh1c,
		.X3mtXb.IYewr .cXrdqd {
			background-color: transparent
		}

		.X3mtXb .mIZh1c,
		.X3mtXb.k0tWj .mIZh1c {
			height: 100%
		}

		.X3mtXb.IYewr .cXrdqd {
			height: calc(100% - 2px);
			width: calc(100% - 2px)
		}

		.X3mtXb .cXrdqd,
		.X3mtXb.IYewr.u3bW4e .cXrdqd {
			height: calc(100% - 4px);
			width: calc(100% - 4px)
		}

		.X3mtXb.u3bW4e .cXrdqd,
		.X3mtXb.IYewr .cXrdqd {
			-webkit-animation: none;
			animation: none;
			opacity: 1
		}

		.X3mtXb.u3bW4e .cXrdqd {
			border: 2px solid;
			border-color: #0b57d0;
			border-color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.X3mtXb.IYewr.u3bW4e .cXrdqd {
			border-width: 2px
		}

		.X3mtXb.IYewr .cXrdqd {
			border: 1px solid;
			border-color: #b3261e;
			border-color: var(--gm3-sys-color-error, #b3261e)
		}

		.X3mtXb.IYewr.CDELXb .snByac {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.X3mtXb .zHQkBf[disabled] {
			color: rgba(31, 31, 31, 0.502)
		}

		.FAiUob .mIZh1c {
			background-color: #747775
		}

		.FAiUob .cXrdqd {
			background-color: #0b57d0;
			background-color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.FAiUob .snByac {
			color: #444746
		}

		.FAiUob.u3bW4e .snByac.snByac {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.Em2Ord {
			margin: 16px 0;
			outline: none
		}

		.Em2Ord+.Em2Ord {
			margin-top: 24px
		}

		.Em2Ord:first-child {
			margin-top: 0
		}

		.Em2Ord:last-child {
			margin-bottom: 0
		}

		.PsAlOe {
			-webkit-border-radius: 8px;
			-moz-border-radius: 8px;
			border-radius: 8px;
			padding: 16px
		}

		.PsAlOe>:first-child {
			margin-top: 0
		}

		.PsAlOe>:last-child {
			margin-bottom: 0
		}

		.PsAlOe .x9zgF {
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 1rem;
			font-weight: 500;
			letter-spacing: 0rem;
			line-height: 1.5
		}

		.PsAlOe .yTaH4c {
			color: #1f1f1f
		}

		.PsAlOe.YFdWic .vYeFie {
			margin-left: 64px;
			width: -webkit-calc(100% - 64px);
			width: -moz-calc(100% - 64px);
			width: calc(100% - 64px)
		}

		.PsAlOe.YFdWic .yTaH4c {
			margin-left: 64px;
			width: -webkit-calc(100% - 64px);
			width: -moz-calc(100% - 64px);
			width: calc(100% - 64px);
			color: #444746;
			margin-top: 4px
		}

		.PsAlOe.YFdWic:not(.S7S4N) .vYeFie {
			margin-left: 0;
			width: 0
		}

		.PsAlOe:not(.S7S4N)>.yTaH4c {
			margin-top: 0
		}

		.PsAlOe.sj692e {
			background: #e8f0fe
		}

		.PsAlOe.Xq8bDe {
			background: #f9dedc;
			background: var(--gm3-sys-color-error-container, #f9dedc)
		}

		.PsAlOe.rNe0id {
			background: #fef7e0
		}

		.PsAlOe.YFdWic {
			background: linear-gradient(0deg, rgba(124, 172, 248, 0.05), rgba(124, 172, 248, 0.05)), linear-gradient(0deg, rgba(117, 117, 117, 0.02), rgba(117, 117, 117, 0.02)), #fff;
			color: #1f1f1f;
			min-height: 80px;
			position: relative
		}

		.PsAlOe:not(.S7S4N) {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex
		}

		.Em2Ord.eLNT1d {
			display: none
		}

		.Em2Ord.RDPZE {
			opacity: .5;
			pointer-events: none
		}

		.Em2Ord.RDPZE .Em2Ord.RDPZE {
			opacity: 1
		}

		.se0rCf {
			background: linear-gradient(0deg, rgba(124, 172, 248, 0.05), rgba(124, 172, 248, 0.05)), linear-gradient(0deg, rgba(117, 117, 117, 0.02), rgba(117, 117, 117, 0.02)), #fff;
			-webkit-border-radius: 28px;
			-moz-border-radius: 28px;
			border-radius: 28px;
			padding: 16px
		}

		.se0rCf .X3mtXb .snByac,
		.se0rCf.Em2Ord .i79UJc .snByac {
			background: linear-gradient(0deg, rgba(124, 172, 248, 0.05), rgba(124, 172, 248, 0.05)), linear-gradient(0deg, rgba(117, 117, 117, 0.02), rgba(117, 117, 117, 0.02)), #fff
		}

		.se0rCf .SgHwWb {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-justify-content: flex-end;
			justify-content: flex-end;
			margin-top: 16px
		}

		.se0rCf .SgHwWb .BqKGqe {
			margin-bottom: 0;
			margin-top: 0
		}

		.nn7x3d {
			border-bottom: 1px solid #e1e3e1;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: column;
			-webkit-flex-direction: column;
			flex-direction: column
		}

		.nn7x3d .V9RXW .rBUW7e,
		.nn7x3d .nn7x3d:last-child {
			border-bottom: 0
		}

		.dwkQ3b:not(.jVwmLb) {
			border-bottom: 0
		}

		.nn7x3d .nn7x3d:last-child .ozEFYb {
			padding-bottom: 0
		}

		.nn7x3d.dwkQ3b {
			border-bottom: 0
		}

		.vYeFie:empty,
		.osxBFb:empty {
			display: none
		}

		.vYeFie>:first-child {
			margin-top: 0;
			padding-top: 0
		}

		.vYeFie>:last-child {
			margin-bottom: 0;
			padding-bottom: 0
		}

		.LwQQGe {
			margin: 0 0 8px
		}

		.nn7x3d[data-expand-type="1"] .ozEFYb,
		.Em2Ord[data-expand-type="1"] .HKEKLe {
			cursor: pointer
		}

		.nn7x3d .ozEFYb {
			padding-bottom: 16px
		}

		.x9zgF {
			-webkit-align-items: center;
			align-items: center;
			color: #1f1f1f;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 1.25rem;
			font-weight: 400;
			letter-spacing: 0rem;
			line-height: 1.2;
			margin-top: 0;
			margin-bottom: 0;
			padding: 0
		}

		.Em2Ord.S7S4N .Em2Ord:not(.nn7x3d) .x9zgF {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 1rem;
			font-weight: 500;
			letter-spacing: 0rem;
			line-height: 1.5
		}

		.nn7x3d.u3bW4e .x9zgF {
			position: relative
		}

		.nn7x3d[data-expand-type="1"].u3bW4e .x9zgF:after {
			background: rgba(11, 87, 208, 0.149);
			background: rgb(var(--gm3-sys-color-primary, 11, 87, 208), 0.15);
			-webkit-border-radius: 8px;
			-moz-border-radius: 8px;
			border-radius: 8px;
			bottom: -4px;
			content: "";
			left: -8px;
			position: absolute;
			right: -8px;
			top: -4px;
			z-index: -1
		}

		.HKEKLe {
			background: none;
			border: none;
			color: inherit;
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			font: inherit;
			margin: 0;
			outline: 0;
			padding: 0;
			text-align: inherit
		}

		.HKEKLe::-moz-focus-inner {
			border: 0
		}

		.HKEKLe [jsslot] {
			position: relative
		}

		.MI3XC {
			margin-left: 16px
		}

		.MI3XC .aHWa4d {
			-webkit-align-items: center;
			align-items: center;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			height: 24px;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-transition: transform 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			-o-transition: transform 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			transition: transform 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			width: 24px
		}

		.nn7x3d .MI3XC,
		.nn7x3d .HKEKLe,
		.nn7x3d .CuWxc {
			pointer-events: none
		}

		.nn7x3d.jVwmLb .aHWa4d {
			-webkit-transform: rotate(-180deg);
			-ms-transform: rotate(-180deg);
			-o-transform: rotate(-180deg);
			transform: rotate(-180deg)
		}

		.CuWxc {
			color: #444746;
			-ms-flex-negative: 0;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			height: 20px;
			margin-right: 16px;
			width: 20px
		}

		.CuWxc .C3qbwe {
			height: 100%;
			width: 100%
		}

		.PsAlOe .CuWxc {
			margin-top: 0
		}

		.PsAlOe.sj692e .CuWxc {
			color: #1967d2
		}

		.PsAlOe.Xq8bDe .CuWxc {
			color: #b3261e;
			color: var(--gm3-sys-color-error, #b3261e)
		}

		.PsAlOe.rNe0id .CuWxc {
			color: #ea8600
		}

		.PsAlOe.YFdWic .CuWxc {
			height: 48px;
			left: 16px;
			position: absolute;
			top: 16px;
			width: 48px
		}

		.osxBFb {
			color: #444746;
			font-size: 0.875rem;
			font-weight: 400;
			line-height: 1.42857143;
			margin-top: 8px
		}

		.vYeFie:empty+.yTaH4c {
			margin-top: 0
		}

		.yTaH4c {
			margin-bottom: 16px;
			margin-top: 10px
		}

		.se0rCf .yTaH4c {
			margin-bottom: 0;
			margin-top: 16px
		}

		.yTaH4c:only-child {
			margin-bottom: 0;
			margin-top: 0
		}

		.nn7x3d .yTaH4c {
			margin-top: 0;
			overflow: hidden;
			-webkit-transition: 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			-o-transition: 0.2s cubic-bezier(0.4, 0, 0.2, 1);
			transition: 0.2s cubic-bezier(0.4, 0, 0.2, 1)
		}

		.nn7x3d.jVwmLb .yTaH4c {
			margin-bottom: 0;
			margin-top: 0;
			max-height: 0;
			opacity: 0;
			visibility: hidden
		}

		.yTaH4c>[jsslot]>:first-child:not(.PsAlOe) {
			margin-top: 0;
			padding-top: 0
		}

		.yTaH4c>[jsslot]>:last-child:not(.PsAlOe) {
			margin-bottom: 0;
			padding-bottom: 0
		}

		.kvM7xe {
			-webkit-align-self: center;
			-ms-grid-row-align: center;
			align-self: center;
			-webkit-align-self: center;
			-ms-grid-row-align: center;
			align-self: center;
			margin-bottom: 0
		}

		.g0ndYb {
			border-bottom: 1px solid #e1e3e1;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: row;
			-webkit-flex-direction: row;
			flex-direction: row;
			-webkit-justify-content: center;
			justify-content: center;
			height: 0;
			margin-top: 12px
		}

		.VXMllb {
			background: #fff;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			height: 24px;
			margin-top: -12px
		}

		.dwkQ3b:not(.jVwmLb) .g0ndYb {
			display: none
		}

		.VfPpkd-MPu53c {
			padding: 11px;
			padding: calc((var(--mdc-checkbox-ripple-size, 40px) - 18px)/2);
			margin: 0;
			margin: calc((var(--mdc-checkbox-touch-target-size, 40px) - 40px)/2)
		}

		.VfPpkd-MPu53c .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c .VfPpkd-OYHm6b::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, #000)
		}

		.VfPpkd-MPu53c:hover .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-OYHm6b::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-OYHm6b::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-OYHm6b::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-OYHm6b::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::after {
			background-color: #018786;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-secondary, #018786))
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd:hover .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-OYHm6b::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-OYHm6b::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-OYHm6b::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-OYHm6b::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::after {
			background-color: #018786;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-secondary, #018786))
		}

		.VfPpkd-MPu53c .VfPpkd-YQoJzd {
			top: 11px;
			top: calc((var(--mdc-checkbox-ripple-size, 40px) - 18px)/2);
			left: 11px;
			left: calc((var(--mdc-checkbox-ripple-size, 40px) - 18px)/2)
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe {
			top: 0;
			top: calc((40px - var(--mdc-checkbox-touch-target-size, 40px))/2);
			right: 0;
			right: calc((40px - var(--mdc-checkbox-touch-target-size, 40px))/2);
			left: 0;
			left: calc((40px - var(--mdc-checkbox-touch-target-size, 40px))/2);
			width: 40px;
			width: var(--mdc-checkbox-touch-target-size, 40px);
			height: 40px;
			height: var(--mdc-checkbox-touch-target-size, 40px)
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: rgba(0, 0, 0, .54);
			border-color: var(--mdc-checkbox-unchecked-color, rgba(0, 0, 0, .54));
			background-color: transparent
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled:checked~.VfPpkd-YQoJzd,
		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled:indeterminate~.VfPpkd-YQoJzd,
		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]:enabled~.VfPpkd-YQoJzd {
			border-color: #018786;
			border-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786));
			background-color: #018786;
			background-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786))
		}

		@-webkit-keyframes mdc-checkbox-fade-in-background-8A000000FF01878600000000FF018786 {
			0% {
				border-color: rgba(0, 0, 0, .54);
				border-color: var(--mdc-checkbox-unchecked-color, rgba(0, 0, 0, .54));
				background-color: transparent
			}

			50% {
				border-color: #018786;
				border-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786));
				background-color: #018786;
				background-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786))
			}
		}

		@keyframes mdc-checkbox-fade-in-background-8A000000FF01878600000000FF018786 {
			0% {
				border-color: rgba(0, 0, 0, .54);
				border-color: var(--mdc-checkbox-unchecked-color, rgba(0, 0, 0, .54));
				background-color: transparent
			}

			50% {
				border-color: #018786;
				border-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786));
				background-color: #018786;
				background-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786))
			}
		}

		@-webkit-keyframes mdc-checkbox-fade-out-background-8A000000FF01878600000000FF018786 {

			0%,
			80% {
				border-color: #018786;
				border-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786));
				background-color: #018786;
				background-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786))
			}

			100% {
				border-color: rgba(0, 0, 0, .54);
				border-color: var(--mdc-checkbox-unchecked-color, rgba(0, 0, 0, .54));
				background-color: transparent
			}
		}

		@keyframes mdc-checkbox-fade-out-background-8A000000FF01878600000000FF018786 {

			0%,
			80% {
				border-color: #018786;
				border-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786));
				background-color: #018786;
				background-color: var(--mdc-checkbox-checked-color, var(--mdc-theme-secondary, #018786))
			}

			100% {
				border-color: rgba(0, 0, 0, .54);
				border-color: var(--mdc-checkbox-unchecked-color, rgba(0, 0, 0, .54));
				background-color: transparent
			}
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-in-background-8A000000FF01878600000000FF018786;
			animation-name: mdc-checkbox-fade-in-background-8A000000FF01878600000000FF018786
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-out-background-8A000000FF01878600000000FF018786;
			animation-name: mdc-checkbox-fade-out-background-8A000000FF01878600000000FF018786
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[disabled]:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: rgba(0, 0, 0, .38);
			border-color: var(--mdc-checkbox-disabled-color, rgba(0, 0, 0, .38));
			background-color: transparent
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[disabled]:checked~.VfPpkd-YQoJzd,
		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[disabled]:indeterminate~.VfPpkd-YQoJzd,
		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true][disabled]~.VfPpkd-YQoJzd {
			border-color: transparent;
			background-color: rgba(0, 0, 0, .38);
			background-color: var(--mdc-checkbox-disabled-color, rgba(0, 0, 0, .38))
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
			color: #fff;
			color: var(--mdc-checkbox-ink-color, #fff)
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
			border-color: #fff;
			border-color: var(--mdc-checkbox-ink-color, #fff)
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
			color: #fff;
			color: var(--mdc-checkbox-ink-color, #fff)
		}

		.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
			border-color: #fff;
			border-color: var(--mdc-checkbox-ink-color, #fff)
		}

		@-webkit-keyframes mdc-checkbox-unchecked-checked-checkmark-path {

			0%,
			50% {
				stroke-dashoffset: 29.7833385
			}

			50% {
				-webkit-animation-timing-function: cubic-bezier(0, 0, .2, 1);
				animation-timing-function: cubic-bezier(0, 0, .2, 1)
			}

			100% {
				stroke-dashoffset: 0
			}
		}

		@keyframes mdc-checkbox-unchecked-checked-checkmark-path {

			0%,
			50% {
				stroke-dashoffset: 29.7833385
			}

			50% {
				-webkit-animation-timing-function: cubic-bezier(0, 0, .2, 1);
				animation-timing-function: cubic-bezier(0, 0, .2, 1)
			}

			100% {
				stroke-dashoffset: 0
			}
		}

		@-webkit-keyframes mdc-checkbox-unchecked-indeterminate-mixedmark {

			0%,
			68.2% {
				-webkit-transform: scaleX(0);
				transform: scaleX(0)
			}

			68.2% {
				-webkit-animation-timing-function: cubic-bezier(0, 0, 0, 1);
				animation-timing-function: cubic-bezier(0, 0, 0, 1)
			}

			100% {
				-webkit-transform: scaleX(1);
				transform: scaleX(1)
			}
		}

		@keyframes mdc-checkbox-unchecked-indeterminate-mixedmark {

			0%,
			68.2% {
				-webkit-transform: scaleX(0);
				-o-transform: scaleX(0);
				transform: scaleX(0)
			}

			68.2% {
				-webkit-animation-timing-function: cubic-bezier(0, 0, 0, 1);
				animation-timing-function: cubic-bezier(0, 0, 0, 1)
			}

			100% {
				-webkit-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1)
			}
		}

		@-webkit-keyframes mdc-checkbox-checked-unchecked-checkmark-path {
			from {
				-webkit-animation-timing-function: cubic-bezier(.4, 0, 1, 1);
				animation-timing-function: cubic-bezier(.4, 0, 1, 1);
				opacity: 1;
				stroke-dashoffset: 0
			}

			to {
				opacity: 0;
				stroke-dashoffset: -29.7833385
			}
		}

		@keyframes mdc-checkbox-checked-unchecked-checkmark-path {
			from {
				-webkit-animation-timing-function: cubic-bezier(.4, 0, 1, 1);
				animation-timing-function: cubic-bezier(.4, 0, 1, 1);
				opacity: 1;
				stroke-dashoffset: 0
			}

			to {
				opacity: 0;
				stroke-dashoffset: -29.7833385
			}
		}

		@-webkit-keyframes mdc-checkbox-checked-indeterminate-checkmark {
			from {
				-webkit-animation-timing-function: cubic-bezier(0, 0, .2, 1);
				animation-timing-function: cubic-bezier(0, 0, .2, 1);
				-webkit-transform: rotate(0deg);
				transform: rotate(0deg);
				opacity: 1
			}

			to {
				-webkit-transform: rotate(45deg);
				transform: rotate(45deg);
				opacity: 0
			}
		}

		@keyframes mdc-checkbox-checked-indeterminate-checkmark {
			from {
				-webkit-animation-timing-function: cubic-bezier(0, 0, .2, 1);
				animation-timing-function: cubic-bezier(0, 0, .2, 1);
				-webkit-transform: rotate(0deg);
				-o-transform: rotate(0deg);
				transform: rotate(0deg);
				opacity: 1
			}

			to {
				-webkit-transform: rotate(45deg);
				-o-transform: rotate(45deg);
				transform: rotate(45deg);
				opacity: 0
			}
		}

		@-webkit-keyframes mdc-checkbox-indeterminate-checked-checkmark {
			from {
				-webkit-animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				-webkit-transform: rotate(45deg);
				transform: rotate(45deg);
				opacity: 0
			}

			to {
				-webkit-transform: rotate(1turn);
				transform: rotate(1turn);
				opacity: 1
			}
		}

		@keyframes mdc-checkbox-indeterminate-checked-checkmark {
			from {
				-webkit-animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				-webkit-transform: rotate(45deg);
				-o-transform: rotate(45deg);
				transform: rotate(45deg);
				opacity: 0
			}

			to {
				-webkit-transform: rotate(1turn);
				-o-transform: rotate(1turn);
				transform: rotate(1turn);
				opacity: 1
			}
		}

		@-webkit-keyframes mdc-checkbox-checked-indeterminate-mixedmark {
			from {
				-webkit-animation-timing-function: mdc-animation-deceleration-curve-timing-function;
				animation-timing-function: mdc-animation-deceleration-curve-timing-function;
				-webkit-transform: rotate(-45deg);
				transform: rotate(-45deg);
				opacity: 0
			}

			to {
				-webkit-transform: rotate(0deg);
				transform: rotate(0deg);
				opacity: 1
			}
		}

		@keyframes mdc-checkbox-checked-indeterminate-mixedmark {
			from {
				-webkit-animation-timing-function: mdc-animation-deceleration-curve-timing-function;
				animation-timing-function: mdc-animation-deceleration-curve-timing-function;
				-webkit-transform: rotate(-45deg);
				-o-transform: rotate(-45deg);
				transform: rotate(-45deg);
				opacity: 0
			}

			to {
				-webkit-transform: rotate(0deg);
				-o-transform: rotate(0deg);
				transform: rotate(0deg);
				opacity: 1
			}
		}

		@-webkit-keyframes mdc-checkbox-indeterminate-checked-mixedmark {
			from {
				-webkit-animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				-webkit-transform: rotate(0deg);
				transform: rotate(0deg);
				opacity: 1
			}

			to {
				-webkit-transform: rotate(315deg);
				transform: rotate(315deg);
				opacity: 0
			}
		}

		@keyframes mdc-checkbox-indeterminate-checked-mixedmark {
			from {
				-webkit-animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				animation-timing-function: cubic-bezier(.14, 0, 0, 1);
				-webkit-transform: rotate(0deg);
				-o-transform: rotate(0deg);
				transform: rotate(0deg);
				opacity: 1
			}

			to {
				-webkit-transform: rotate(315deg);
				-o-transform: rotate(315deg);
				transform: rotate(315deg);
				opacity: 0
			}
		}

		@-webkit-keyframes mdc-checkbox-indeterminate-unchecked-mixedmark {
			0% {
				-webkit-animation-timing-function: linear;
				animation-timing-function: linear;
				-webkit-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 1
			}

			32.8%,
			100% {
				-webkit-transform: scaleX(0);
				transform: scaleX(0);
				opacity: 0
			}
		}

		@keyframes mdc-checkbox-indeterminate-unchecked-mixedmark {
			0% {
				-webkit-animation-timing-function: linear;
				animation-timing-function: linear;
				-webkit-transform: scaleX(1);
				-o-transform: scaleX(1);
				transform: scaleX(1);
				opacity: 1
			}

			32.8%,
			100% {
				-webkit-transform: scaleX(0);
				-o-transform: scaleX(0);
				transform: scaleX(0);
				opacity: 0
			}
		}

		.VfPpkd-MPu53c {
			display: inline-block;
			position: relative;
			-webkit-box-flex: 0;
			-webkit-flex: 0 0 18px;
			flex: 0 0 18px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			width: 18px;
			height: 18px;
			line-height: 0;
			white-space: nowrap;
			cursor: pointer;
			vertical-align: bottom
		}

		.VfPpkd-MPu53c[hidden] {
			display: none
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-sMek6-LhBDec,
		.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-sMek6-LhBDec {
			pointer-events: none;
			border: 2px solid transparent;
			border-radius: 6px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: 100%;
			width: 100%
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-sMek6-LhBDec,
			.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-sMek6-LhBDec {
				border-color: CanvasText
			}
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-sMek6-LhBDec::after,
		.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-sMek6-LhBDec::after {
			content: "";
			border: 2px solid transparent;
			border-radius: 8px;
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-sMek6-LhBDec::after,
			.VfPpkd-MPu53c:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-sMek6-LhBDec::after {
				border-color: CanvasText
			}
		}

		@media (-ms-high-contrast:none) {
			.VfPpkd-MPu53c .VfPpkd-sMek6-LhBDec {
				display: none
			}
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {
			.VfPpkd-SJnn3d {
				margin: 0 1px
			}
		}

		.VfPpkd-MPu53c-OWXEXe-OWB6Me {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-YQoJzd {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			position: absolute;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 18px;
			height: 18px;
			border: 2px solid currentColor;
			border-radius: 2px;
			background-color: transparent;
			pointer-events: none;
			will-change: background-color, border-color;
			-webkit-transition: background-color 90ms 0ms cubic-bezier(.4, 0, .6, 1), border-color 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: background-color 90ms 0ms cubic-bezier(.4, 0, .6, 1), border-color 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: background-color 90ms 0ms cubic-bezier(.4, 0, .6, 1), border-color 90ms 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-HUofsb {
			position: absolute;
			top: 0;
			right: 0;
			bottom: 0;
			left: 0;
			width: 100%;
			opacity: 0;
			-webkit-transition: opacity .18s 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: opacity .18s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity .18s 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-MPu53c-OWXEXe-mWPk3d .VfPpkd-HUofsb {
			opacity: 1
		}

		.VfPpkd-HUofsb-Jt5cK {
			-webkit-transition: stroke-dashoffset .18s 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: stroke-dashoffset .18s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: stroke-dashoffset .18s 0ms cubic-bezier(.4, 0, .6, 1);
			stroke: currentColor;
			stroke-width: 3.12px;
			stroke-dashoffset: 29.7833385;
			stroke-dasharray: 29.7833385
		}

		.VfPpkd-SJnn3d {
			width: 100%;
			height: 0;
			-webkit-transform: scaleX(0) rotate(0deg);
			-ms-transform: scaleX(0) rotate(0deg);
			-o-transform: scaleX(0) rotate(0deg);
			transform: scaleX(0) rotate(0deg);
			border-width: 1px;
			border-style: solid;
			opacity: 0;
			-webkit-transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), -o-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), transform 90ms 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1), -o-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-YQoJzd,
		.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-YQoJzd,
		.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-YQoJzd,
		.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-YQoJzd {
			-webkit-animation-duration: .18s;
			animation-duration: .18s;
			-webkit-animation-timing-function: linear;
			animation-timing-function: linear
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-HUofsb-Jt5cK {
			-webkit-animation: mdc-checkbox-unchecked-checked-checkmark-path .18s linear 0s;
			animation: mdc-checkbox-unchecked-checked-checkmark-path .18s linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-SJnn3d {
			-webkit-animation: mdc-checkbox-unchecked-indeterminate-mixedmark 90ms linear 0s;
			animation: mdc-checkbox-unchecked-indeterminate-mixedmark 90ms linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-HUofsb-Jt5cK {
			-webkit-animation: mdc-checkbox-checked-unchecked-checkmark-path 90ms linear 0s;
			animation: mdc-checkbox-checked-unchecked-checkmark-path 90ms linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-A9y3zc .VfPpkd-HUofsb {
			-webkit-animation: mdc-checkbox-checked-indeterminate-checkmark 90ms linear 0s;
			animation: mdc-checkbox-checked-indeterminate-checkmark 90ms linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-A9y3zc .VfPpkd-SJnn3d {
			-webkit-animation: mdc-checkbox-checked-indeterminate-mixedmark 90ms linear 0s;
			animation: mdc-checkbox-checked-indeterminate-mixedmark 90ms linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-barxie .VfPpkd-HUofsb {
			-webkit-animation: mdc-checkbox-indeterminate-checked-checkmark .5s linear 0s;
			animation: mdc-checkbox-indeterminate-checked-checkmark .5s linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-barxie .VfPpkd-SJnn3d {
			-webkit-animation: mdc-checkbox-indeterminate-checked-mixedmark .5s linear 0s;
			animation: mdc-checkbox-indeterminate-checked-mixedmark .5s linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-SJnn3d {
			-webkit-animation: mdc-checkbox-indeterminate-unchecked-mixedmark .3s linear 0s;
			animation: mdc-checkbox-indeterminate-unchecked-mixedmark .3s linear 0s;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-muHVFf-bMcfAe:checked~.VfPpkd-YQoJzd,
		.VfPpkd-muHVFf-bMcfAe:indeterminate~.VfPpkd-YQoJzd,
		.VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]~.VfPpkd-YQoJzd {
			-webkit-transition: border-color 90ms 0ms cubic-bezier(0, 0, .2, 1), background-color 90ms 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: border-color 90ms 0ms cubic-bezier(0, 0, .2, 1), background-color 90ms 0ms cubic-bezier(0, 0, .2, 1);
			transition: border-color 90ms 0ms cubic-bezier(0, 0, .2, 1), background-color 90ms 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-muHVFf-bMcfAe:checked~.VfPpkd-YQoJzd .VfPpkd-HUofsb-Jt5cK,
		.VfPpkd-muHVFf-bMcfAe:indeterminate~.VfPpkd-YQoJzd .VfPpkd-HUofsb-Jt5cK,
		.VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]~.VfPpkd-YQoJzd .VfPpkd-HUofsb-Jt5cK {
			stroke-dashoffset: 0
		}

		.VfPpkd-muHVFf-bMcfAe {
			position: absolute;
			margin: 0;
			padding: 0;
			opacity: 0;
			cursor: inherit
		}

		.VfPpkd-muHVFf-bMcfAe:disabled {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-MPu53c-OWXEXe-dgl2Hf {
			margin: 4px;
			margin: calc((var(--mdc-checkbox-state-layer-size, 48px) - var(--mdc-checkbox-state-layer-size, 40px))/2)
		}

		.VfPpkd-MPu53c-OWXEXe-dgl2Hf .VfPpkd-muHVFf-bMcfAe {
			top: -4px;
			top: calc((var(--mdc-checkbox-state-layer-size, 40px) - var(--mdc-checkbox-state-layer-size, 48px))/2);
			right: -4px;
			right: calc((var(--mdc-checkbox-state-layer-size, 40px) - var(--mdc-checkbox-state-layer-size, 48px))/2);
			left: -4px;
			left: calc((var(--mdc-checkbox-state-layer-size, 40px) - var(--mdc-checkbox-state-layer-size, 48px))/2);
			width: 48px;
			width: var(--mdc-checkbox-state-layer-size, 48px);
			height: 48px;
			height: var(--mdc-checkbox-state-layer-size, 48px)
		}

		.VfPpkd-muHVFf-bMcfAe:checked~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
			-webkit-transition: opacity .18s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .18s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .18s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .18s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: opacity .18s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .18s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .18s 0ms cubic-bezier(0, 0, .2, 1), transform .18s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .18s 0ms cubic-bezier(0, 0, .2, 1), transform .18s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .18s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .18s 0ms cubic-bezier(0, 0, .2, 1);
			opacity: 1
		}

		.VfPpkd-muHVFf-bMcfAe:checked~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
			-webkit-transform: scaleX(1) rotate(-45deg);
			-ms-transform: scaleX(1) rotate(-45deg);
			-o-transform: scaleX(1) rotate(-45deg);
			transform: scaleX(1) rotate(-45deg)
		}

		.VfPpkd-muHVFf-bMcfAe:indeterminate~.VfPpkd-YQoJzd .VfPpkd-HUofsb,
		.VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
			-webkit-transform: rotate(45deg);
			-ms-transform: rotate(45deg);
			-o-transform: rotate(45deg);
			transform: rotate(45deg);
			opacity: 0;
			-webkit-transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), -o-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), transform 90ms 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity 90ms 0ms cubic-bezier(.4, 0, .6, 1), transform 90ms 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1), -o-transform 90ms 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-muHVFf-bMcfAe:indeterminate~.VfPpkd-YQoJzd .VfPpkd-SJnn3d,
		.VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
			-webkit-transform: scaleX(1) rotate(0deg);
			-ms-transform: scaleX(1) rotate(0deg);
			-o-transform: scaleX(1) rotate(0deg);
			transform: scaleX(1) rotate(0deg);
			opacity: 1
		}

		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-mWPk3d .VfPpkd-YQoJzd,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-mWPk3d .VfPpkd-HUofsb,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-mWPk3d .VfPpkd-HUofsb-Jt5cK,
		.VfPpkd-MPu53c.VfPpkd-MPu53c-OWXEXe-mWPk3d .VfPpkd-SJnn3d {
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.VfPpkd-MPu53c {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		.VfPpkd-MPu53c .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c .VfPpkd-OYHm6b::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		.VfPpkd-MPu53c .VfPpkd-OYHm6b::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		.VfPpkd-MPu53c .VfPpkd-OYHm6b::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d .VfPpkd-OYHm6b::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d .VfPpkd-OYHm6b::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-OYHm6b::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-OYHm6b::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-OYHm6b::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-MPu53c .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c .VfPpkd-OYHm6b::after {
			top: 0;
			left: 0;
			width: 100%;
			height: 100%
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d .VfPpkd-OYHm6b::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0);
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-MPu53c.VfPpkd-ksKsZd-mWPk3d .VfPpkd-OYHm6b::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-MPu53c {
			z-index: 0
		}

		.VfPpkd-MPu53c .VfPpkd-OYHm6b::before,
		.VfPpkd-MPu53c .VfPpkd-OYHm6b::after {
			z-index: -1;
			z-index: var(--mdc-ripple-z-index, -1)
		}

		.VfPpkd-OYHm6b {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			pointer-events: none
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {
			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[disabled]:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
				border-color: GrayText;
				border-color: var(--mdc-checkbox-disabled-unselected-icon-color, GrayText);
				background-color: transparent
			}

			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[disabled]:checked~.VfPpkd-YQoJzd,
			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[disabled]:indeterminate~.VfPpkd-YQoJzd,
			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true][disabled]~.VfPpkd-YQoJzd {
				border-color: GrayText;
				background-color: GrayText;
				background-color: var(--mdc-checkbox-disabled-selected-icon-color, GrayText)
			}

			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
				color: ButtonText;
				color: var(--mdc-checkbox-selected-checkmark-color, ButtonText)
			}

			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
				border-color: ButtonText;
				border-color: var(--mdc-checkbox-selected-checkmark-color, ButtonText)
			}

			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
				color: ButtonFace;
				color: var(--mdc-checkbox-disabled-selected-checkmark-color, ButtonFace)
			}

			.VfPpkd-MPu53c .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
				border-color: ButtonFace;
				border-color: var(--mdc-checkbox-disabled-selected-checkmark-color, ButtonFace)
			}
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe[disabled]:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: rgba(60, 64, 67, .38);
			border-color: var(--mdc-checkbox-disabled-unselected-icon-color, rgba(60, 64, 67, .38));
			background-color: transparent
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe[disabled]:checked~.VfPpkd-YQoJzd,
		.Ne8lhe .VfPpkd-muHVFf-bMcfAe[disabled]:indeterminate~.VfPpkd-YQoJzd,
		.Ne8lhe .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true][disabled]~.VfPpkd-YQoJzd {
			border-color: transparent;
			background-color: rgba(60, 64, 67, .38);
			background-color: var(--mdc-checkbox-disabled-selected-icon-color, rgba(60, 64, 67, .38))
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
			color: #fff;
			color: var(--mdc-checkbox-selected-checkmark-color, #fff)
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
			border-color: #fff;
			border-color: var(--mdc-checkbox-selected-checkmark-color, #fff)
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
			color: #fff;
			color: var(--mdc-checkbox-disabled-selected-checkmark-color, #fff)
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
			border-color: #fff;
			border-color: var(--mdc-checkbox-disabled-selected-checkmark-color, #fff)
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: #5f6368;
			border-color: var(--mdc-checkbox-unselected-icon-color, #5f6368);
			background-color: transparent
		}

		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled:checked~.VfPpkd-YQoJzd,
		.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled:indeterminate~.VfPpkd-YQoJzd,
		.Ne8lhe .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]:enabled~.VfPpkd-YQoJzd {
			border-color: #1a73e8;
			border-color: var(--mdc-checkbox-selected-icon-color, #1a73e8);
			background-color: #1a73e8;
			background-color: var(--mdc-checkbox-selected-icon-color, #1a73e8)
		}

		@-webkit-keyframes mdc-checkbox-fade-in-background-FF5F6368FF1A73E800000000FF1A73E8 {
			0% {
				border-color: #5f6368;
				border-color: var(--mdc-checkbox-unselected-icon-color, #5f6368);
				background-color: transparent
			}

			50% {
				border-color: #1a73e8;
				border-color: var(--mdc-checkbox-selected-icon-color, #1a73e8);
				background-color: #1a73e8;
				background-color: var(--mdc-checkbox-selected-icon-color, #1a73e8)
			}
		}

		@keyframes mdc-checkbox-fade-in-background-FF5F6368FF1A73E800000000FF1A73E8 {
			0% {
				border-color: #5f6368;
				border-color: var(--mdc-checkbox-unselected-icon-color, #5f6368);
				background-color: transparent
			}

			50% {
				border-color: #1a73e8;
				border-color: var(--mdc-checkbox-selected-icon-color, #1a73e8);
				background-color: #1a73e8;
				background-color: var(--mdc-checkbox-selected-icon-color, #1a73e8)
			}
		}

		@-webkit-keyframes mdc-checkbox-fade-out-background-FF5F6368FF1A73E800000000FF1A73E8 {

			0%,
			80% {
				border-color: #1a73e8;
				border-color: var(--mdc-checkbox-selected-icon-color, #1a73e8);
				background-color: #1a73e8;
				background-color: var(--mdc-checkbox-selected-icon-color, #1a73e8)
			}

			100% {
				border-color: #5f6368;
				border-color: var(--mdc-checkbox-unselected-icon-color, #5f6368);
				background-color: transparent
			}
		}

		@keyframes mdc-checkbox-fade-out-background-FF5F6368FF1A73E800000000FF1A73E8 {

			0%,
			80% {
				border-color: #1a73e8;
				border-color: var(--mdc-checkbox-selected-icon-color, #1a73e8);
				background-color: #1a73e8;
				background-color: var(--mdc-checkbox-selected-icon-color, #1a73e8)
			}

			100% {
				border-color: #5f6368;
				border-color: var(--mdc-checkbox-unselected-icon-color, #5f6368);
				background-color: transparent
			}
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-in-background-FF5F6368FF1A73E800000000FF1A73E8;
			animation-name: mdc-checkbox-fade-in-background-FF5F6368FF1A73E800000000FF1A73E8
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-out-background-FF5F6368FF1A73E800000000FF1A73E8;
			animation-name: mdc-checkbox-fade-out-background-FF5F6368FF1A73E800000000FF1A73E8
		}

		.Ne8lhe:hover .VfPpkd-muHVFf-bMcfAe:enabled:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: #202124;
			border-color: var(--mdc-checkbox-unselected-hover-icon-color, #202124);
			background-color: transparent
		}

		.Ne8lhe:hover .VfPpkd-muHVFf-bMcfAe:enabled:checked~.VfPpkd-YQoJzd,
		.Ne8lhe:hover .VfPpkd-muHVFf-bMcfAe:enabled:indeterminate~.VfPpkd-YQoJzd,
		.Ne8lhe:hover .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]:enabled~.VfPpkd-YQoJzd {
			border-color: #174ea6;
			border-color: var(--mdc-checkbox-selected-hover-icon-color, #174ea6);
			background-color: #174ea6;
			background-color: var(--mdc-checkbox-selected-hover-icon-color, #174ea6)
		}

		@-webkit-keyframes mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6 {
			0% {
				border-color: #202124;
				border-color: var(--mdc-checkbox-unselected-hover-icon-color, #202124);
				background-color: transparent
			}

			50% {
				border-color: #174ea6;
				border-color: var(--mdc-checkbox-selected-hover-icon-color, #174ea6);
				background-color: #174ea6;
				background-color: var(--mdc-checkbox-selected-hover-icon-color, #174ea6)
			}
		}

		@-webkit-keyframes mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6 {

			0%,
			80% {
				border-color: #174ea6;
				border-color: var(--mdc-checkbox-selected-hover-icon-color, #174ea6);
				background-color: #174ea6;
				background-color: var(--mdc-checkbox-selected-hover-icon-color, #174ea6)
			}

			100% {
				border-color: #202124;
				border-color: var(--mdc-checkbox-unselected-hover-icon-color, #202124);
				background-color: transparent
			}
		}

		.Ne8lhe:hover.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:hover.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6;
			animation-name: mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6
		}

		.Ne8lhe:hover.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:hover.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6;
			animation-name: mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-muHVFf-bMcfAe:enabled:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-muHVFf-bMcfAe:enabled:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: #202124;
			border-color: var(--mdc-checkbox-unselected-focus-icon-color, #202124);
			background-color: transparent
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-muHVFf-bMcfAe:enabled:checked~.VfPpkd-YQoJzd,
		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-muHVFf-bMcfAe:enabled:indeterminate~.VfPpkd-YQoJzd,
		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-muHVFf-bMcfAe:enabled:checked~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-muHVFf-bMcfAe:enabled:indeterminate~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]:enabled~.VfPpkd-YQoJzd {
			border-color: #174ea6;
			border-color: var(--mdc-checkbox-selected-focus-icon-color, #174ea6);
			background-color: #174ea6;
			background-color: var(--mdc-checkbox-selected-focus-icon-color, #174ea6)
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6;
			animation-name: mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6;
			animation-name: mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6
		}

		.Ne8lhe:not(:disabled):active .VfPpkd-muHVFf-bMcfAe:enabled:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
			border-color: #202124;
			border-color: var(--mdc-checkbox-unselected-pressed-icon-color, #202124);
			background-color: transparent
		}

		.Ne8lhe:not(:disabled):active .VfPpkd-muHVFf-bMcfAe:enabled:checked~.VfPpkd-YQoJzd,
		.Ne8lhe:not(:disabled):active .VfPpkd-muHVFf-bMcfAe:enabled:indeterminate~.VfPpkd-YQoJzd,
		.Ne8lhe:not(:disabled):active .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true]:enabled~.VfPpkd-YQoJzd {
			border-color: #174ea6;
			border-color: var(--mdc-checkbox-selected-pressed-icon-color, #174ea6);
			background-color: #174ea6;
			background-color: var(--mdc-checkbox-selected-pressed-icon-color, #174ea6)
		}

		@keyframes mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6 {
			0% {
				border-color: #202124;
				border-color: var(--mdc-checkbox-unselected-pressed-icon-color, #202124);
				background-color: transparent
			}

			50% {
				border-color: #174ea6;
				border-color: var(--mdc-checkbox-selected-pressed-icon-color, #174ea6);
				background-color: #174ea6;
				background-color: var(--mdc-checkbox-selected-pressed-icon-color, #174ea6)
			}
		}

		@keyframes mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6 {

			0%,
			80% {
				border-color: #174ea6;
				border-color: var(--mdc-checkbox-selected-pressed-icon-color, #174ea6);
				background-color: #174ea6;
				background-color: var(--mdc-checkbox-selected-pressed-icon-color, #174ea6)
			}

			100% {
				border-color: #202124;
				border-color: var(--mdc-checkbox-unselected-pressed-icon-color, #202124);
				background-color: transparent
			}
		}

		.Ne8lhe:not(:disabled):active.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-barxie .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(:disabled):active.VfPpkd-MPu53c-OWXEXe-vwu2ne-iAfbIe-A9y3zc .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6;
			animation-name: mdc-checkbox-fade-in-background-FF202124FF174EA600000000FF174EA6
		}

		.Ne8lhe:not(:disabled):active.VfPpkd-MPu53c-OWXEXe-vwu2ne-barxie-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd,
		.Ne8lhe:not(:disabled):active.VfPpkd-MPu53c-OWXEXe-vwu2ne-A9y3zc-iAfbIe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd {
			-webkit-animation-name: mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6;
			animation-name: mdc-checkbox-fade-out-background-FF202124FF174EA600000000FF174EA6
		}

		.Ne8lhe .VfPpkd-OYHm6b::before,
		.Ne8lhe .VfPpkd-OYHm6b::after {
			background-color: #3c4043;
			background-color: var(--mdc-checkbox-unselected-hover-state-layer-color, #3c4043)
		}

		.Ne8lhe:hover .VfPpkd-OYHm6b::before,
		.Ne8lhe.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-OYHm6b::before {
			opacity: .04;
			opacity: var(--mdc-checkbox-unselected-hover-state-layer-opacity, .04)
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-OYHm6b::before,
		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-OYHm6b::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-checkbox-unselected-focus-state-layer-opacity, .12)
		}

		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-OYHm6b::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.Ne8lhe:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-OYHm6b::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-checkbox-unselected-pressed-state-layer-opacity, .1)
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-checkbox-unselected-pressed-state-layer-opacity, 0.1)
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::before,
		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::after {
			background-color: #1a73e8;
			background-color: var(--mdc-checkbox-selected-hover-state-layer-color, #1a73e8)
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd:hover .VfPpkd-OYHm6b::before,
		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-OYHm6b::before {
			opacity: .04;
			opacity: var(--mdc-checkbox-selected-hover-state-layer-opacity, .04)
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-OYHm6b::before,
		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-OYHm6b::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-checkbox-selected-focus-state-layer-opacity, .12)
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-OYHm6b::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-OYHm6b::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-checkbox-selected-pressed-state-layer-opacity, .1)
		}

		.Ne8lhe.VfPpkd-MPu53c-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-checkbox-selected-pressed-state-layer-opacity, 0.1)
		}

		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::before,
		.Ne8lhe.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe.VfPpkd-MPu53c-OWXEXe-gk6SMd .VfPpkd-OYHm6b::after {
			background-color: #1a73e8;
			background-color: var(--mdc-checkbox-selected-hover-state-layer-color, #1a73e8)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {
			.Ne8lhe .VfPpkd-muHVFf-bMcfAe[disabled]:not(:checked):not(:indeterminate):not([data-indeterminate=true])~.VfPpkd-YQoJzd {
				border-color: GrayText;
				border-color: var(--mdc-checkbox-disabled-unselected-icon-color, GrayText);
				background-color: transparent
			}

			.Ne8lhe .VfPpkd-muHVFf-bMcfAe[disabled]:checked~.VfPpkd-YQoJzd,
			.Ne8lhe .VfPpkd-muHVFf-bMcfAe[disabled]:indeterminate~.VfPpkd-YQoJzd,
			.Ne8lhe .VfPpkd-muHVFf-bMcfAe[data-indeterminate=true][disabled]~.VfPpkd-YQoJzd {
				border-color: GrayText;
				background-color: GrayText;
				background-color: var(--mdc-checkbox-disabled-selected-icon-color, GrayText)
			}

			.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
				color: ButtonText;
				color: var(--mdc-checkbox-selected-checkmark-color, ButtonText)
			}

			.Ne8lhe .VfPpkd-muHVFf-bMcfAe:enabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
				border-color: ButtonText;
				border-color: var(--mdc-checkbox-selected-checkmark-color, ButtonText)
			}

			.Ne8lhe .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-HUofsb {
				color: ButtonFace;
				color: var(--mdc-checkbox-disabled-selected-checkmark-color, ButtonFace)
			}

			.Ne8lhe .VfPpkd-muHVFf-bMcfAe:disabled~.VfPpkd-YQoJzd .VfPpkd-SJnn3d {
				border-color: ButtonFace;
				border-color: var(--mdc-checkbox-disabled-selected-checkmark-color, ButtonFace)
			}
		}

		.az2ine {
			will-change: unset
		}

		.O1htCb-H9tDt {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-orient: vertical;
			-webkit-box-direction: normal;
			-webkit-flex-direction: column;
			flex-direction: column;
			position: relative
		}

		.O1htCb-H9tDt[hidden] {
			display: none
		}

		.VfPpkd-O1htCb {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			position: relative
		}

		.VfPpkd-O1htCb .VfPpkd-NLUYnc-V67aGc {
			top: 50%;
			-webkit-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			-o-transform: translateY(-50%);
			transform: translateY(-50%);
			pointer-events: none
		}

		.VfPpkd-O1htCb .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 16px;
			padding-right: 16px
		}

		[dir=rtl] .VfPpkd-O1htCb .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-O1htCb .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-O1htCb .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-f7MjDc {
			margin-left: 0;
			margin-right: 12px
		}

		[dir=rtl] .VfPpkd-O1htCb .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-O1htCb .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-f7MjDc[dir=rtl] {
			margin-left: 12px;
			margin-right: 0
		}

		.VfPpkd-O1htCb[hidden] {
			display: none
		}

		.VfPpkd-t08AT-Bz112c {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			position: relative;
			-webkit-align-self: center;
			align-self: center;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			pointer-events: none
		}

		.VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-auswjd,
		.VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-mt1Mkb {
			position: absolute;
			top: 0;
			left: 0
		}

		.VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-Bd00G {
			width: 41.6666666667%;
			height: 20.8333333333%
		}

		.VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-mt1Mkb {
			opacity: 1;
			-webkit-transition: opacity 75ms linear 75ms;
			-o-transition: opacity 75ms linear 75ms;
			transition: opacity 75ms linear 75ms
		}

		.VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-auswjd {
			opacity: 0;
			-webkit-transition: opacity 75ms linear;
			-o-transition: opacity 75ms linear;
			transition: opacity 75ms linear
		}

		.VfPpkd-O1htCb-OWXEXe-pXU01b .VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-mt1Mkb {
			opacity: 0;
			-webkit-transition: opacity 49.5ms linear;
			-o-transition: opacity 49.5ms linear;
			transition: opacity 49.5ms linear
		}

		.VfPpkd-O1htCb-OWXEXe-pXU01b .VfPpkd-t08AT-Bz112c .VfPpkd-t08AT-Bz112c-auswjd {
			opacity: 1;
			-webkit-transition: opacity .1005s linear 49.5ms;
			-o-transition: opacity .1005s linear 49.5ms;
			transition: opacity .1005s linear 49.5ms
		}

		.VfPpkd-TkwUic {
			min-width: 0;
			-webkit-box-flex: 1;
			-webkit-flex: 1 1 auto;
			flex: 1 1 auto;
			position: relative;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			overflow: hidden;
			outline: none;
			cursor: pointer
		}

		.VfPpkd-uusGie-fmcmS-haAclf {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-appearance: none;
			-moz-appearance: none;
			appearance: none;
			pointer-events: none;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: auto;
			min-width: 0;
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			border: none;
			outline: none;
			padding: 0;
			background-color: transparent;
			color: inherit
		}

		.VfPpkd-uusGie-fmcmS {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			line-height: 1.75rem;
			line-height: var(--mdc-typography-subtitle1-line-height, 1.75rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit);
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
			display: block;
			width: 100%;
			text-align: left
		}

		[dir=rtl] .VfPpkd-uusGie-fmcmS,
		.VfPpkd-uusGie-fmcmS[dir=rtl] {
			text-align: right
		}

		.VfPpkd-O1htCb-OWXEXe-OWB6Me {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-ibnC6b {
			padding-left: 12px;
			padding-right: 12px
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-ibnC6b,
		.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 12px;
			padding-right: 12px
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {
			.VfPpkd-YPmvEd::before {
				position: absolute;
				-webkit-box-sizing: border-box;
				box-sizing: border-box;
				width: 100%;
				height: 100%;
				top: 0;
				left: 0;
				border: 1px solid transparent;
				border-radius: inherit;
				content: "";
				pointer-events: none
			}
		}

		@media screen and (-ms-high-contrast:active) and (forced-colors:active),
		screen and (forced-colors:active) and (forced-colors:active) {
			.VfPpkd-YPmvEd::before {
				border-color: CanvasText
			}
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-cTi5dd,
		.VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-cTi5dd {
			margin-left: 0;
			margin-right: 0
		}

		[dir=rtl] .VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-cTi5dd,
		[dir=rtl] .VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-cTi5dd,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-cTi5dd[dir=rtl],
		.VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-cTi5dd[dir=rtl] {
			margin-left: 0;
			margin-right: 0
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.VfPpkd-YPmvEd .VfPpkd-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: #000;
			color: var(--mdc-theme-on-surface, #000)
		}

		.VfPpkd-YPmvEd .VfPpkd-rymPhb-KkROqb {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center
		}

		.VfPpkd-OkbHre {
			padding-left: 16px;
			padding-right: 16px
		}

		[dir=rtl] .VfPpkd-OkbHre,
		.VfPpkd-OkbHre[dir=rtl] {
			padding-left: 16px;
			padding-right: 16px
		}

		.VfPpkd-aJasdd-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc {
			height: 48px
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb {
			height: 64px
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-KkROqb {
			margin-top: 20px
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS {
			display: block;
			margin-top: 0;
			line-height: normal;
			margin-bottom: -20px
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 28px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb .VfPpkd-rymPhb-fpDzbe-fmcmS::after {
			display: inline-block;
			width: 0;
			height: 20px;
			content: "";
			vertical-align: -20px
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			display: block;
			margin-top: 0;
			line-height: normal
		}

		.VfPpkd-hjZysc-RWgCYc-wQNmvb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e::before {
			display: inline-block;
			width: 0;
			height: 36px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc {
			padding-left: 0;
			padding-right: 12px
		}

		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc.VfPpkd-rymPhb-ibnC6b {
			padding-left: 0;
			padding-right: auto
		}

		[dir=rtl] .VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: auto;
			padding-right: 0
		}

		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc .VfPpkd-rymPhb-KkROqb {
			margin-left: 12px;
			margin-right: 0
		}

		[dir=rtl] .VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc .VfPpkd-rymPhb-KkROqb,
		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc .VfPpkd-rymPhb-KkROqb[dir=rtl] {
			margin-left: 0;
			margin-right: 12px
		}

		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc .VfPpkd-rymPhb-KkROqb {
			width: 36px;
			height: 24px
		}

		[dir=rtl] .VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc,
		.VfPpkd-OkbHre-SfQLQb-M1Soyc-bN97Pc[dir=rtl] {
			padding-left: 12px;
			padding-right: 0
		}

		.VfPpkd-OkbHre-SfQLQb-r4m2rf.VfPpkd-rymPhb-ibnC6b {
			padding-left: auto;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-OkbHre-SfQLQb-r4m2rf.VfPpkd-rymPhb-ibnC6b,
		.VfPpkd-OkbHre-SfQLQb-r4m2rf.VfPpkd-rymPhb-ibnC6b[dir=rtl] {
			padding-left: 0;
			padding-right: auto
		}

		.VfPpkd-OkbHre-SfQLQb-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			margin-left: 12px;
			margin-right: 12px
		}

		[dir=rtl] .VfPpkd-OkbHre-SfQLQb-r4m2rf .VfPpkd-rymPhb-JMEf7e,
		.VfPpkd-OkbHre-SfQLQb-r4m2rf .VfPpkd-rymPhb-JMEf7e[dir=rtl] {
			margin-left: 12px;
			margin-right: 12px
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-xl07Ob-XxIAqe-OWXEXe-uxVfW-FNFY6c-uFfGwd {
			border-top-left-radius: 0;
			border-top-right-radius: 0
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-XpnDCe.VfPpkd-RWgCYc-ksKsZd::after {
			-webkit-transform: scale(1, 2);
			-ms-transform: scale(1, 2);
			-o-transform: scale(1, 2);
			transform: scale(1, 2);
			opacity: 1
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-TkwUic {
			height: 56px;
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-align: baseline;
			-webkit-align-items: baseline;
			align-items: baseline
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-TkwUic::before {
			display: inline-block;
			width: 0;
			height: 40px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-di8rgd-V67aGc .VfPpkd-TkwUic .VfPpkd-uusGie-fmcmS::before {
			content: "​"
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-di8rgd-V67aGc .VfPpkd-TkwUic .VfPpkd-uusGie-fmcmS-haAclf {
			height: 100%;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-di8rgd-V67aGc .VfPpkd-TkwUic::before {
			display: none
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-TkwUic {
			border-top-left-radius: 4px;
			border-top-left-radius: var(--mdc-shape-small, 4px);
			border-top-right-radius: 4px;
			border-top-right-radius: var(--mdc-shape-small, 4px);
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 0
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-TkwUic {
			background-color: whitesmoke
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-TkwUic {
			background-color: #fafafa
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgba(0, 0, 0, .42)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):hover .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgba(0, 0, 0, .87)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::after {
			border-bottom-color: #6200ee;
			border-bottom-color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgba(0, 0, 0, .06)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-NLUYnc-V67aGc {
			max-width: calc(100% - 64px)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			max-width: calc(133.3333333333% - 85.3333333333px)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-NLUYnc-V67aGc {
			left: 16px;
			right: auto
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-NLUYnc-V67aGc,
		.VfPpkd-O1htCb-OWXEXe-MFS4be .VfPpkd-NLUYnc-V67aGc[dir=rtl] {
			left: auto;
			right: 16px
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc {
			left: 48px;
			right: auto
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc,
		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc[dir=rtl] {
			left: auto;
			right: 48px
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc {
			max-width: calc(100% - 96px)
		}

		.VfPpkd-O1htCb-OWXEXe-MFS4be.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			max-width: calc(133.3333333333% - 128px)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: #b00020;
			border-bottom-color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):hover .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: #b00020;
			border-bottom-color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::after {
			border-bottom-color: #b00020;
			border-bottom-color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc {
			border: none
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-align: baseline;
			-webkit-align-items: baseline;
			align-items: baseline;
			overflow: visible
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-uusGie-fmcmS-haAclf {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			border: none;
			z-index: 1;
			background-color: transparent
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-cTi5dd {
			z-index: 2
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-xl07Ob-XxIAqe {
			margin-bottom: 8px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-di8rgd-V67aGc .VfPpkd-xl07Ob-XxIAqe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-xl07Ob-XxIAqe-OWXEXe-uxVfW-FNFY6c-uFfGwd {
			margin-bottom: 0
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic {
			height: 56px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above-select-outlined-56px .25s 1;
			animation: mdc-floating-label-shake-float-above-select-outlined-56px .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above-select-outlined-56px {
			0% {
				-webkit-transform: translateX(0) translateY(-34.75px) scale(.75);
				transform: translateX(0) translateY(-34.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(4%) translateY(-34.75px) scale(.75);
				transform: translateX(4%) translateY(-34.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(-4%) translateY(-34.75px) scale(.75);
				transform: translateX(-4%) translateY(-34.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(0) translateY(-34.75px) scale(.75);
				transform: translateX(0) translateY(-34.75px) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above-select-outlined-56px {
			0% {
				-webkit-transform: translateX(0) translateY(-34.75px) scale(.75);
				-o-transform: translateX(0) translateY(-34.75px) scale(.75);
				transform: translateX(0) translateY(-34.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(4%) translateY(-34.75px) scale(.75);
				-o-transform: translateX(4%) translateY(-34.75px) scale(.75);
				transform: translateX(4%) translateY(-34.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(-4%) translateY(-34.75px) scale(.75);
				-o-transform: translateX(-4%) translateY(-34.75px) scale(.75);
				transform: translateX(-4%) translateY(-34.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(0) translateY(-34.75px) scale(.75);
				-o-transform: translateX(0) translateY(-34.75px) scale(.75);
				transform: translateX(0) translateY(-34.75px) scale(.75)
			}
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb {
			border-top-left-radius: 4px;
			border-top-left-radius: var(--mdc-shape-small, 4px);
			border-top-right-radius: 0;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 4px;
			border-bottom-left-radius: var(--mdc-shape-small, 4px)
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb[dir=rtl] {
			border-top-left-radius: 0;
			border-top-right-radius: 4px;
			border-top-right-radius: var(--mdc-shape-small, 4px);
			border-bottom-right-radius: 4px;
			border-bottom-right-radius: var(--mdc-shape-small, 4px);
			border-bottom-left-radius: 0
		}

		@supports (top:max(0%)) {
			.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb {
				width: max(12px, var(--mdc-shape-small, 4px))
			}
		}

		@supports (top:max(0%)) {
			.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd {
				max-width: calc(100% - max(12px, var(--mdc-shape-small, 4px))*2)
			}
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-top-left-radius: 0;
			border-top-right-radius: 4px;
			border-top-right-radius: var(--mdc-shape-small, 4px);
			border-bottom-right-radius: 4px;
			border-bottom-right-radius: var(--mdc-shape-small, 4px);
			border-bottom-left-radius: 0
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe[dir=rtl] {
			border-top-left-radius: 4px;
			border-top-left-radius: var(--mdc-shape-small, 4px);
			border-top-right-radius: 0;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 4px;
			border-bottom-left-radius: var(--mdc-shape-small, 4px)
		}

		@supports (top:max(0%)) {
			.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic {
				padding-left: max(16px, calc(var(--mdc-shape-small, 4px) + 4px))
			}
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic[dir=rtl] {
			padding-left: 0
		}

		@supports (top:max(0%)) {

			[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic,
			.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic[dir=rtl] {
				padding-right: max(16px, calc(var(--mdc-shape-small, 4px) + 4px))
			}
		}

		@supports (top:max(0%)) {
			.VfPpkd-O1htCb-OWXEXe-INsAgc+.VfPpkd-O1htCb-W0vJo-fmcmS {
				margin-left: max(16px, calc(var(--mdc-shape-small, 4px) + 4px))
			}
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc+.VfPpkd-O1htCb-W0vJo-fmcmS,
		.VfPpkd-O1htCb-OWXEXe-INsAgc+.VfPpkd-O1htCb-W0vJo-fmcmS[dir=rtl] {
			margin-left: 0
		}

		@supports (top:max(0%)) {

			[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc+.VfPpkd-O1htCb-W0vJo-fmcmS,
			.VfPpkd-O1htCb-OWXEXe-INsAgc+.VfPpkd-O1htCb-W0vJo-fmcmS[dir=rtl] {
				margin-right: max(16px, calc(var(--mdc-shape-small, 4px) + 4px))
			}
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-TkwUic {
			background-color: transparent
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-TkwUic {
			background-color: transparent
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgba(0, 0, 0, .87)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: #6200ee;
			border-color: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgba(0, 0, 0, .06)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-width: 2px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic :not(.VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd) .VfPpkd-NSFCdd-Ra9xwd {
			max-width: calc(100% - 60px)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above-select-outlined .25s 1;
			animation: mdc-floating-label-shake-float-above-select-outlined .25s 1
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-37.25px) scale(1);
			-ms-transform: translateY(-37.25px) scale(1);
			-o-transform: translateY(-37.25px) scale(1);
			transform: translateY(-37.25px) scale(1)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: .75rem
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-34.75px) scale(.75);
			-ms-transform: translateY(-34.75px) scale(.75);
			-o-transform: translateY(-34.75px) scale(.75);
			transform: translateY(-34.75px) scale(.75)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: 1rem
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd .VfPpkd-NSFCdd-Ra9xwd {
			padding-top: 1px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-uusGie-fmcmS::before {
			content: "​"
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic .VfPpkd-uusGie-fmcmS-haAclf {
			height: 100%;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic::before {
			display: none
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NLUYnc-V67aGc {
			line-height: 1.15rem;
			left: 4px;
			right: auto
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NLUYnc-V67aGc,
		.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-NLUYnc-V67aGc[dir=rtl] {
			left: auto;
			right: 4px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd .VfPpkd-NSFCdd-Ra9xwd {
			padding-top: 2px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-MpmGFe {
			border-color: #b00020;
			border-color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: #b00020;
			border-color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: #b00020;
			border-color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc {
			left: 36px;
			right: auto
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc[dir=rtl] {
			left: auto;
			right: 36px
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-37.25px) translateX(-32px) scale(1);
			-ms-transform: translateY(-37.25px) translateX(-32px) scale(1);
			-o-transform: translateY(-37.25px) translateX(-32px) scale(1);
			transform: translateY(-37.25px) translateX(-32px) scale(1)
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe[dir=rtl] {
			-webkit-transform: translateY(-37.25px) translateX(32px) scale(1);
			-ms-transform: translateY(-37.25px) translateX(32px) scale(1);
			-o-transform: translateY(-37.25px) translateX(32px) scale(1);
			transform: translateY(-37.25px) translateX(32px) scale(1)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: .75rem
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-34.75px) translateX(-32px) scale(.75);
			-ms-transform: translateY(-34.75px) translateX(-32px) scale(.75);
			-o-transform: translateY(-34.75px) translateX(-32px) scale(.75);
			transform: translateY(-34.75px) translateX(-32px) scale(.75)
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe[dir=rtl],
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe[dir=rtl] {
			-webkit-transform: translateY(-34.75px) translateX(32px) scale(.75);
			-ms-transform: translateY(-34.75px) translateX(32px) scale(.75);
			-o-transform: translateY(-34.75px) translateX(32px) scale(.75);
			transform: translateY(-34.75px) translateX(32px) scale(.75)
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: 1rem
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px .25s 1;
			animation: mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px {
			0% {
				-webkit-transform: translateX(-32px) translateY(-34.75px) scale(.75);
				transform: translateX(-32px) translateY(-34.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% - 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(4% - 32px)) translateY(-34.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% - 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(-4% - 32px)) translateY(-34.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(-32px) translateY(-34.75px) scale(.75);
				transform: translateX(-32px) translateY(-34.75px) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px {
			0% {
				-webkit-transform: translateX(-32px) translateY(-34.75px) scale(.75);
				-o-transform: translateX(-32px) translateY(-34.75px) scale(.75);
				transform: translateX(-32px) translateY(-34.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% - 32px)) translateY(-34.75px) scale(.75);
				-o-transform: translateX(calc(4% - 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(4% - 32px)) translateY(-34.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% - 32px)) translateY(-34.75px) scale(.75);
				-o-transform: translateX(calc(-4% - 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(-4% - 32px)) translateY(-34.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(-32px) translateY(-34.75px) scale(.75);
				-o-transform: translateX(-32px) translateY(-34.75px) scale(.75);
				transform: translateX(-32px) translateY(-34.75px) scale(.75)
			}
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU,
		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c[dir=rtl] .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px .25s 1;
			animation: mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px-rtl {
			0% {
				-webkit-transform: translateX(32px) translateY(-34.75px) scale(.75);
				transform: translateX(32px) translateY(-34.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% + 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(4% + 32px)) translateY(-34.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% + 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(-4% + 32px)) translateY(-34.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(32px) translateY(-34.75px) scale(.75);
				transform: translateX(32px) translateY(-34.75px) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above-select-outlined-leading-icon-56px-rtl {
			0% {
				-webkit-transform: translateX(32px) translateY(-34.75px) scale(.75);
				-o-transform: translateX(32px) translateY(-34.75px) scale(.75);
				transform: translateX(32px) translateY(-34.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% + 32px)) translateY(-34.75px) scale(.75);
				-o-transform: translateX(calc(4% + 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(4% + 32px)) translateY(-34.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% + 32px)) translateY(-34.75px) scale(.75);
				-o-transform: translateX(calc(-4% + 32px)) translateY(-34.75px) scale(.75);
				transform: translateX(calc(-4% + 32px)) translateY(-34.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(32px) translateY(-34.75px) scale(.75);
				-o-transform: translateX(32px) translateY(-34.75px) scale(.75);
				transform: translateX(32px) translateY(-34.75px) scale(.75)
			}
		}

		.VfPpkd-O1htCb-OWXEXe-INsAgc.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic :not(.VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd) .VfPpkd-NSFCdd-Ra9xwd {
			max-width: calc(100% - 96px)
		}

		.VfPpkd-TkwUic {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		.VfPpkd-TkwUic .VfPpkd-woaZLe::before,
		.VfPpkd-TkwUic .VfPpkd-woaZLe::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		.VfPpkd-TkwUic .VfPpkd-woaZLe::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		.VfPpkd-TkwUic .VfPpkd-woaZLe::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d .VfPpkd-woaZLe::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d .VfPpkd-woaZLe::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-woaZLe::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-woaZLe::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-woaZLe::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-TkwUic .VfPpkd-woaZLe::before,
		.VfPpkd-TkwUic .VfPpkd-woaZLe::after {
			top: -50%;
			left: -50%;
			width: 200%;
			height: 200%
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d .VfPpkd-woaZLe::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-TkwUic .VfPpkd-woaZLe::before,
		.VfPpkd-TkwUic .VfPpkd-woaZLe::after {
			background-color: rgba(0, 0, 0, .87);
			background-color: var(--mdc-ripple-color, rgba(0, 0, 0, .87))
		}

		.VfPpkd-TkwUic:hover .VfPpkd-woaZLe::before,
		.VfPpkd-TkwUic.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-woaZLe::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-woaZLe::before,
		.VfPpkd-TkwUic:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-woaZLe::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-TkwUic .VfPpkd-woaZLe {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			pointer-events: none
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-on-surface, #000))
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after {
			background-color: #000;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-on-surface, #000))
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.VfPpkd-YPmvEd .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-O1htCb-W0vJo-fmcmS {
			margin: 0;
			margin-left: 16px;
			margin-right: 16px;
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-caption-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: .75rem;
			font-size: var(--mdc-typography-caption-font-size, .75rem);
			line-height: 1.25rem;
			line-height: var(--mdc-typography-caption-line-height, 1.25rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-caption-font-weight, 400);
			letter-spacing: .0333333333em;
			letter-spacing: var(--mdc-typography-caption-letter-spacing, .0333333333em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-decoration: var(--mdc-typography-caption-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-caption-text-transform, inherit);
			display: block;
			margin-top: 0;
			line-height: normal
		}

		[dir=rtl] .VfPpkd-O1htCb-W0vJo-fmcmS,
		.VfPpkd-O1htCb-W0vJo-fmcmS[dir=rtl] {
			margin-left: 16px;
			margin-right: 16px
		}

		.VfPpkd-O1htCb-W0vJo-fmcmS::before {
			display: inline-block;
			width: 0;
			height: 16px;
			content: "";
			vertical-align: 0
		}

		.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb {
			opacity: 0;
			-webkit-transition: opacity .18s cubic-bezier(.4, 0, .2, 1);
			-o-transition: opacity .18s cubic-bezier(.4, 0, .2, 1);
			transition: opacity .18s cubic-bezier(.4, 0, .2, 1)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc+.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb,
		.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb-zvnfze {
			opacity: 1
		}

		.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-cTi5dd {
			display: inline-block;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			border: none;
			text-decoration: none;
			cursor: pointer;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			-webkit-align-self: center;
			align-self: center;
			background-color: transparent;
			fill: currentColor
		}

		.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-cTi5dd {
			margin-left: 12px;
			margin-right: 12px
		}

		[dir=rtl] .VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-cTi5dd,
		.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-cTi5dd[dir=rtl] {
			margin-left: 12px;
			margin-right: 12px
		}

		.VfPpkd-cTi5dd:not([tabindex]),
		.VfPpkd-cTi5dd[tabindex="-1"] {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-uusGie-fmcmS {
			color: rgba(0, 0, 0, .87)
		}

		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-uusGie-fmcmS {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc {
			color: rgba(0, 0, 0, .6)
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NLUYnc-V67aGc {
			color: rgba(98, 0, 238, .87)
		}

		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NLUYnc-V67aGc {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: rgba(0, 0, 0, .54)
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: #6200ee;
			fill: var(--mdc-theme-primary, #6200ee)
		}

		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-t08AT-Bz112c {
			fill: rgba(0, 0, 0, .38)
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me)+.VfPpkd-O1htCb-W0vJo-fmcmS {
			color: rgba(0, 0, 0, .6)
		}

		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me+.VfPpkd-O1htCb-W0vJo-fmcmS {
			color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-O1htCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-cTi5dd {
			color: rgba(0, 0, 0, .54)
		}

		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-cTi5dd {
			color: rgba(0, 0, 0, .38)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {
			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-uusGie-fmcmS {
				color: GrayText
			}

			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-t08AT-Bz112c {
				fill: red
			}

			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NLUYnc-V67aGc {
				color: GrayText
			}

			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-RWgCYc-ksKsZd::before {
				border-bottom-color: GrayText
			}

			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-Brv4Fb,
			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-Ra9xwd,
			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-MpmGFe {
				border-color: GrayText
			}

			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-cTi5dd,
			.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-OWB6Me+.VfPpkd-O1htCb-W0vJo-fmcmS {
				color: GrayText
			}
		}

		.VfPpkd-O1htCb .VfPpkd-TkwUic {
			padding-left: 16px;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-O1htCb .VfPpkd-TkwUic,
		.VfPpkd-O1htCb .VfPpkd-TkwUic[dir=rtl] {
			padding-left: 0;
			padding-right: 16px
		}

		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic {
			padding-left: 0;
			padding-right: 0
		}

		[dir=rtl] .VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic,
		.VfPpkd-O1htCb.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic[dir=rtl] {
			padding-left: 0;
			padding-right: 0
		}

		.VfPpkd-O1htCb .VfPpkd-cTi5dd {
			width: 24px;
			height: 24px;
			font-size: 24px
		}

		.VfPpkd-O1htCb .VfPpkd-t08AT-Bz112c {
			width: 24px;
			height: 24px
		}

		.VfPpkd-t08AT-Bz112c {
			margin-left: 12px;
			margin-right: 12px
		}

		[dir=rtl] .VfPpkd-t08AT-Bz112c,
		.VfPpkd-t08AT-Bz112c[dir=rtl] {
			margin-left: 12px;
			margin-right: 12px
		}

		.VfPpkd-TkwUic {
			width: 200px
		}

		.VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-106%) scale(.75);
			-ms-transform: translateY(-106%) scale(.75);
			-o-transform: translateY(-106%) scale(.75);
			transform: translateY(-106%) scale(.75)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc {
			color: #b00020;
			color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NLUYnc-V67aGc {
			color: #b00020;
			color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-UJflGc+.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb {
			color: #b00020;
			color: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: #b00020;
			fill: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: #b00020;
			fill: var(--mdc-theme-error, #b00020)
		}

		.VfPpkd-uusGie-fmcmS-haAclf {
			height: 28px
		}

		.s8kOBc {
			-webkit-box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12);
			box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12);
			font-family: Roboto, Arial, sans-serif;
			line-height: 1.5rem;
			font-size: 1rem;
			letter-spacing: .00625em;
			font-weight: 400
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb {
			font-family: Roboto, Arial, sans-serif;
			line-height: 1.5rem;
			font-size: 1rem;
			letter-spacing: .00625em;
			font-weight: 400;
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-IhFlZd {
			color: rgb(95, 99, 104)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
			opacity: .38
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-StrnGf-rymPhb-f7MjDc {
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: 0
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd {
			background-color: rgb(232, 240, 254)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--mdc-ripple-color, rgb(26, 115, 232))
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c,
			.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-fpDzbe-fmcmS,
			.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
				color: GrayText
			}

			.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-StrnGf-rymPhb-b9t22c {
				opacity: 1
			}
		}

		.s8kOBc .VfPpkd-rymPhb-fpDzbe-fmcmS {
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-rymPhb-L8ivfd-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-bC5pod-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-JMEf7e {
			color: rgb(95, 99, 104)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-L8ivfd-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-bC5pod-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-KkROqb,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-Gtdoyb,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-JMEf7e {
			opacity: .38
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b .VfPpkd-rymPhb-fpDzbe-fmcmS,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-pXU01b.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before {
			opacity: 0
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd {
			background-color: rgb(232, 240, 254)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--mdc-ripple-color, rgb(26, 115, 232))
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.s8kOBc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		@media screen and (forced-colors:active) {

			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-fpDzbe-fmcmS,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-L8ivfd-fmcmS,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-bC5pod-fmcmS,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me.VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-r4m2rf .VfPpkd-rymPhb-JMEf7e {
				color: GrayText
			}

			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-KkROqb,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-Gtdoyb,
			.s8kOBc .VfPpkd-rymPhb-ibnC6b-OWXEXe-OWB6Me .VfPpkd-rymPhb-JMEf7e {
				opacity: 1
			}
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-L8ivfd-fmcmS {
			color: rgb(95, 99, 104)
		}

		.s8kOBc .VfPpkd-StrnGf-rymPhb .VfPpkd-StrnGf-rymPhb-f7MjDc,
		.s8kOBc .VfPpkd-rymPhb .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb,
		.s8kOBc .VfPpkd-rymPhb .VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-UbuQg-Bz112c .VfPpkd-rymPhb-JMEf7e {
			color: rgb(60, 64, 67)
		}

		.s8kOBc .VfPpkd-rymPhb-fpDzbe-fmcmS {
			letter-spacing: .00625em
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd {
			background-color: rgb(252, 232, 230)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			background-color: rgb(217, 48, 37);
			background-color: var(--mdc-ripple-color, rgb(217, 48, 37))
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-StrnGf-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-StrnGf-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-StrnGf-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd .VfPpkd-rymPhb-pZXsl::after {
			background-color: rgb(217, 48, 37);
			background-color: var(--mdc-ripple-color, rgb(217, 48, 37))
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:hover .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-rymPhb-pZXsl::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-rymPhb-pZXsl::before,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-rymPhb-pZXsl::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-rymPhb-pZXsl::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-StrnGf-rymPhb-ibnC6b.VfPpkd-StrnGf-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d,
		.s8kOBc.VfPpkd-YPmvEd-OWXEXe-UJflGc .VfPpkd-rymPhb-ibnC6b.VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-TkwUic {
			background-color: rgb(241, 243, 244)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-TkwUic {
			background-color: rgba(95, 99, 104, .04)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgb(95, 99, 104)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):hover .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgb(32, 33, 36)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::after {
			border-bottom-color: rgb(25, 103, 210)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgba(95, 99, 104, .38)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc {
			color: rgb(95, 99, 104)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NLUYnc-V67aGc {
			color: rgb(25, 103, 210)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-NLUYnc-V67aGc {
			color: rgb(32, 33, 36)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NLUYnc-V67aGc {
			color: rgba(95, 99, 104, .38)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me)+.VfPpkd-O1htCb-W0vJo-fmcmS {
			color: rgb(95, 99, 104)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me+.VfPpkd-O1htCb-W0vJo-fmcmS {
			color: rgba(95, 99, 104, .38)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-UJflGc+.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb {
			color: rgb(197, 34, 31)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover.VfPpkd-O1htCb-OWXEXe-UJflGc+.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb {
			color: rgb(165, 14, 14)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-uusGie-fmcmS {
			color: rgb(60, 64, 67)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-uusGie-fmcmS {
			color: rgba(60, 64, 67, .38)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: rgb(95, 99, 104)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-t08AT-Bz112c {
			fill: rgb(32, 33, 36)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: rgb(23, 78, 166)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-t08AT-Bz112c {
			fill: rgba(95, 99, 104, .38)
		}

		.hqBSCb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-cTi5dd {
			color: rgb(95, 99, 104)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-cTi5dd {
			color: rgba(95, 99, 104, .38)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgb(197, 34, 31)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):hover .VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-color: rgb(165, 14, 14)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-RWgCYc-ksKsZd::after {
			border-bottom-color: rgb(197, 34, 31)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc {
			color: rgb(197, 34, 31)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-NLUYnc-V67aGc {
			color: rgb(165, 14, 14)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			color: rgb(197, 34, 31)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			color: rgb(165, 14, 14)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: rgb(217, 48, 37)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-t08AT-Bz112c {
			fill: rgb(165, 14, 14)
		}

		.hqBSCb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: rgb(217, 48, 37)
		}

		.hqBSCb .VfPpkd-TkwUic .VfPpkd-woaZLe::before,
		.hqBSCb .VfPpkd-TkwUic .VfPpkd-woaZLe::after {
			background-color: rgb(60, 64, 67);
			background-color: var(--mdc-ripple-color, rgb(60, 64, 67))
		}

		.hqBSCb .VfPpkd-TkwUic:hover .VfPpkd-woaZLe::before,
		.hqBSCb .VfPpkd-TkwUic.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-woaZLe::before {
			opacity: .08;
			opacity: var(--mdc-ripple-hover-opacity, .08)
		}

		.hqBSCb .VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-woaZLe::before,
		.hqBSCb .VfPpkd-TkwUic:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-woaZLe::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.hqBSCb .VfPpkd-TkwUic:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-woaZLe::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.hqBSCb .VfPpkd-TkwUic:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-woaZLe::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.hqBSCb .VfPpkd-TkwUic.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgb(128, 134, 139)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgb(32, 33, 36)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgb(26, 115, 232)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgba(60, 64, 67, .12)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc {
			color: rgb(95, 99, 104)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NLUYnc-V67aGc {
			color: rgb(26, 115, 232)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-NLUYnc-V67aGc {
			color: rgb(32, 33, 36)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-NLUYnc-V67aGc {
			color: rgba(95, 99, 104, .38)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me)+.VfPpkd-O1htCb-W0vJo-fmcmS {
			color: rgb(95, 99, 104)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me+.VfPpkd-O1htCb-W0vJo-fmcmS {
			color: rgba(95, 99, 104, .38)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-UJflGc+.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb {
			color: rgb(217, 48, 37)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover.VfPpkd-O1htCb-OWXEXe-UJflGc+.VfPpkd-O1htCb-W0vJo-fmcmS-OWXEXe-Rfh2Tc-EglORb {
			color: rgb(165, 14, 14)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-uusGie-fmcmS {
			color: rgb(60, 64, 67)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-uusGie-fmcmS {
			color: rgba(60, 64, 67, .38)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: rgb(95, 99, 104)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-t08AT-Bz112c {
			fill: rgb(32, 33, 36)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: rgb(26, 115, 232)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-t08AT-Bz112c {
			fill: rgba(95, 99, 104, .38)
		}

		.ReCbLb:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-cTi5dd {
			color: rgb(95, 99, 104)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-OWB6Me .VfPpkd-cTi5dd {
			color: rgba(95, 99, 104, .38)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgb(217, 48, 37)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe) .VfPpkd-TkwUic:hover .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgb(165, 14, 14)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd,
		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-color: rgb(217, 48, 37)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc {
			color: rgb(217, 48, 37)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-NLUYnc-V67aGc {
			color: rgb(165, 14, 14)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			color: rgb(217, 48, 37)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			color: rgb(165, 14, 14)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: rgb(197, 34, 31)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-t08AT-Bz112c {
			fill: rgb(165, 14, 14)
		}

		.ReCbLb.VfPpkd-O1htCb-OWXEXe-UJflGc:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: rgb(197, 34, 31)
		}

		.VfPpkd-I9GLp-yrriRe {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			vertical-align: middle
		}

		.VfPpkd-I9GLp-yrriRe[hidden] {
			display: none
		}

		.VfPpkd-I9GLp-yrriRe>label {
			margin-left: 0;
			margin-right: auto;
			padding-left: 4px;
			padding-right: 0;
			-webkit-box-ordinal-group: 1;
			-webkit-order: 0;
			order: 0
		}

		[dir=rtl] .VfPpkd-I9GLp-yrriRe>label,
		.VfPpkd-I9GLp-yrriRe>label[dir=rtl] {
			margin-left: auto;
			margin-right: 0
		}

		[dir=rtl] .VfPpkd-I9GLp-yrriRe>label,
		.VfPpkd-I9GLp-yrriRe>label[dir=rtl] {
			padding-left: 0;
			padding-right: 4px
		}

		.VfPpkd-I9GLp-yrriRe-OWXEXe-WrakWd>label {
			text-overflow: ellipsis;
			overflow: hidden;
			white-space: nowrap
		}

		.VfPpkd-I9GLp-yrriRe-OWXEXe-fW01td-CpWD9d>label {
			margin-left: auto;
			margin-right: 0;
			padding-left: 0;
			padding-right: 4px;
			-webkit-box-ordinal-group: 0;
			-webkit-order: -1;
			order: -1
		}

		[dir=rtl] .VfPpkd-I9GLp-yrriRe-OWXEXe-fW01td-CpWD9d>label,
		.VfPpkd-I9GLp-yrriRe-OWXEXe-fW01td-CpWD9d>label[dir=rtl] {
			margin-left: 0;
			margin-right: auto
		}

		[dir=rtl] .VfPpkd-I9GLp-yrriRe-OWXEXe-fW01td-CpWD9d>label,
		.VfPpkd-I9GLp-yrriRe-OWXEXe-fW01td-CpWD9d>label[dir=rtl] {
			padding-left: 4px;
			padding-right: 0
		}

		.VfPpkd-I9GLp-yrriRe-OWXEXe-fozPsf-t6UvL {
			-webkit-box-pack: justify;
			-webkit-justify-content: space-between;
			justify-content: space-between
		}

		.VfPpkd-I9GLp-yrriRe-OWXEXe-fozPsf-t6UvL>label {
			margin: 0
		}

		[dir=rtl] .VfPpkd-I9GLp-yrriRe-OWXEXe-fozPsf-t6UvL>label,
		.VfPpkd-I9GLp-yrriRe-OWXEXe-fozPsf-t6UvL>label[dir=rtl] {
			margin: 0
		}

		.VfPpkd-I9GLp-yrriRe {
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-form-field-label-text-font, Roboto, sans-serif);
			line-height: 1.25rem;
			line-height: var(--mdc-form-field-label-text-line-height, 1.25rem);
			font-size: .875rem;
			font-size: var(--mdc-form-field-label-text-size, .875rem);
			font-weight: 400;
			font-weight: var(--mdc-form-field-label-text-weight, 400);
			letter-spacing: .0178571429em;
			letter-spacing: var(--mdc-form-field-label-text-tracking, .0178571429em);
			color: rgba(0, 0, 0, .87);
			color: var(--mdc-form-field-label-text-color, var(--mdc-theme-text-primary-on-background, rgba(0, 0, 0, .87)))
		}

		.MlG5Jc {
			font-family: Roboto, Arial, sans-serif;
			line-height: 1.25rem;
			font-size: .875rem;
			letter-spacing: .0142857143em;
			font-weight: 400
		}

		.MlG5Jc gm-checkbox[disabled]~.VfPpkd-V67aGc,
		.MlG5Jc gm-radio[disabled]~.VfPpkd-V67aGc,
		.MlG5Jc .VfPpkd-MPu53c-OWXEXe-OWB6Me~.VfPpkd-V67aGc,
		.MlG5Jc .VfPpkd-GCYh9b-OWXEXe-OWB6Me~.VfPpkd-V67aGc {
			color: rgb(95, 99, 104)
		}

		.VfPpkd-GCYh9b {
			padding: 10px
		}

		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgba(0, 0, 0, .54)
		}

		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe:enabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: #018786;
			border-color: var(--mdc-theme-secondary, #018786)
		}

		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe:enabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			border-color: #018786;
			border-color: var(--mdc-theme-secondary, #018786)
		}

		.VfPpkd-GCYh9b [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe:disabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-GCYh9b [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe:disabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-GCYh9b [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			border-color: rgba(0, 0, 0, .38)
		}

		.VfPpkd-GCYh9b .VfPpkd-RsCWK::before {
			background-color: #018786;
			background-color: var(--mdc-theme-secondary, #018786)
		}

		.VfPpkd-GCYh9b .VfPpkd-RsCWK::before {
			top: -10px;
			left: -10px;
			width: 40px;
			height: 40px
		}

		.VfPpkd-GCYh9b .VfPpkd-gBXA9-bMcfAe {
			top: 0;
			right: 0;
			left: 0;
			width: 40px;
			height: 40px
		}

		@media (-ms-high-contrast:active),
		screen and (forced-colors:active) {

			.VfPpkd-GCYh9b.VfPpkd-GCYh9b-OWXEXe-OWB6Me [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
			.VfPpkd-GCYh9b.VfPpkd-GCYh9b-OWXEXe-OWB6Me .VfPpkd-gBXA9-bMcfAe:disabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
				border-color: GrayText
			}

			.VfPpkd-GCYh9b.VfPpkd-GCYh9b-OWXEXe-OWB6Me [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
			.VfPpkd-GCYh9b.VfPpkd-GCYh9b-OWXEXe-OWB6Me .VfPpkd-gBXA9-bMcfAe:disabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
				border-color: GrayText
			}

			.VfPpkd-GCYh9b.VfPpkd-GCYh9b-OWXEXe-OWB6Me [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
			.VfPpkd-GCYh9b.VfPpkd-GCYh9b-OWXEXe-OWB6Me .VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
				border-color: GrayText
			}
		}

		.VfPpkd-GCYh9b {
			display: inline-block;
			position: relative;
			-webkit-box-flex: 0;
			-webkit-flex: 0 0 auto;
			flex: 0 0 auto;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			width: 20px;
			height: 20px;
			cursor: pointer;
			will-change: opacity, transform, border-color, color
		}

		.VfPpkd-GCYh9b[hidden] {
			display: none
		}

		.VfPpkd-RsCWK {
			display: inline-block;
			position: relative;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 20px;
			height: 20px
		}

		.VfPpkd-RsCWK::before {
			position: absolute;
			-webkit-transform: scale(0, 0);
			-ms-transform: scale(0, 0);
			-o-transform: scale(0, 0);
			transform: scale(0, 0);
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: "";
			-webkit-transition: opacity .12s 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity .12s 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: opacity .12s 0ms cubic-bezier(.4, 0, .6, 1), -o-transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity .12s 0ms cubic-bezier(.4, 0, .6, 1), transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: opacity .12s 0ms cubic-bezier(.4, 0, .6, 1), transform .12s 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform .12s 0ms cubic-bezier(.4, 0, .6, 1), -o-transform .12s 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-wVo5xe-LkdAo {
			position: absolute;
			top: 0;
			left: 0;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			border-width: 2px;
			border-style: solid;
			border-radius: 50%;
			-webkit-transition: border-color .12s 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: border-color .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: border-color .12s 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-Z5TpLc-LkdAo {
			position: absolute;
			top: 0;
			left: 0;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			height: 100%;
			-webkit-transform: scale(0, 0);
			-ms-transform: scale(0, 0);
			-o-transform: scale(0, 0);
			transform: scale(0, 0);
			border-width: 10px;
			border-style: solid;
			border-radius: 50%;
			-webkit-transition: border-color .12s 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: border-color .12s 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			-o-transition: border-color .12s 0ms cubic-bezier(.4, 0, .6, 1), -o-transform .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: transform .12s 0ms cubic-bezier(.4, 0, .6, 1), border-color .12s 0ms cubic-bezier(.4, 0, .6, 1);
			transition: transform .12s 0ms cubic-bezier(.4, 0, .6, 1), border-color .12s 0ms cubic-bezier(.4, 0, .6, 1), -webkit-transform .12s 0ms cubic-bezier(.4, 0, .6, 1), -o-transform .12s 0ms cubic-bezier(.4, 0, .6, 1)
		}

		.VfPpkd-gBXA9-bMcfAe {
			position: absolute;
			margin: 0;
			padding: 0;
			opacity: 0;
			cursor: inherit;
			z-index: 1
		}

		.VfPpkd-GCYh9b-OWXEXe-dgl2Hf {
			margin-top: 4px;
			margin-bottom: 4px;
			margin-right: 4px;
			margin-left: 4px
		}

		.VfPpkd-GCYh9b-OWXEXe-dgl2Hf .VfPpkd-gBXA9-bMcfAe {
			top: -4px;
			right: -4px;
			left: -4px;
			width: 48px;
			height: 48px
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-r6xRoe-LhBDec,
		.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-r6xRoe-LhBDec {
			pointer-events: none;
			border: 2px solid transparent;
			border-radius: 6px;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: 100%;
			width: 100%
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-r6xRoe-LhBDec,
			.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-r6xRoe-LhBDec {
				border-color: CanvasText
			}
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-r6xRoe-LhBDec::after,
		.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-r6xRoe-LhBDec::after {
			content: "";
			border: 2px solid transparent;
			border-radius: 8px;
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			-ms-transform: translate(-50%, -50%);
			-o-transform: translate(-50%, -50%);
			transform: translate(-50%, -50%);
			height: calc(100% + 4px);
			width: calc(100% + 4px)
		}

		@media screen and (forced-colors:active) {

			.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-r6xRoe-LhBDec::after,
			.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-r6xRoe-LhBDec::after {
				border-color: CanvasText
			}
		}

		.VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK,
		.VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK {
			-webkit-transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), transform .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			-webkit-transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
		.VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			-webkit-transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: transform .12s 0ms cubic-bezier(0, 0, .2, 1), border-color .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: transform .12s 0ms cubic-bezier(0, 0, .2, 1), border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-GCYh9b-OWXEXe-OWB6Me {
			cursor: default;
			pointer-events: none
		}

		.VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			-webkit-transform: scale(.5);
			-ms-transform: scale(.5);
			-o-transform: scale(.5);
			transform: scale(.5);
			-webkit-transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: transform .12s 0ms cubic-bezier(0, 0, .2, 1), border-color .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: transform .12s 0ms cubic-bezier(0, 0, .2, 1), border-color .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK,
		[aria-disabled=true] .VfPpkd-gBXA9-bMcfAe+.VfPpkd-RsCWK {
			cursor: default
		}

		.VfPpkd-gBXA9-bMcfAe:focus+.VfPpkd-RsCWK::before {
			-webkit-transform: scale(1);
			-ms-transform: scale(1);
			-o-transform: scale(1);
			transform: scale(1);
			opacity: .12;
			-webkit-transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			-o-transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), transform .12s 0ms cubic-bezier(0, 0, .2, 1);
			transition: opacity .12s 0ms cubic-bezier(0, 0, .2, 1), transform .12s 0ms cubic-bezier(0, 0, .2, 1), -webkit-transform .12s 0ms cubic-bezier(0, 0, .2, 1), -o-transform .12s 0ms cubic-bezier(0, 0, .2, 1)
		}

		.VfPpkd-GCYh9b {
			--mdc-ripple-fg-size: 0;
			--mdc-ripple-left: 0;
			--mdc-ripple-top: 0;
			--mdc-ripple-fg-scale: 1;
			--mdc-ripple-fg-translate-end: 0;
			--mdc-ripple-fg-translate-start: 0;
			-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
			will-change: transform, opacity
		}

		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::before,
		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::after {
			position: absolute;
			border-radius: 50%;
			opacity: 0;
			pointer-events: none;
			content: ""
		}

		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::before {
			-webkit-transition: opacity 15ms linear, background-color 15ms linear;
			-o-transition: opacity 15ms linear, background-color 15ms linear;
			transition: opacity 15ms linear, background-color 15ms linear;
			z-index: 1;
			z-index: var(--mdc-ripple-z-index, 1)
		}

		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::after {
			z-index: 0;
			z-index: var(--mdc-ripple-z-index, 0)
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-eHTEvd::before {
			-webkit-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: scale(var(--mdc-ripple-fg-scale, 1));
			transform: scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-eHTEvd::after {
			top: 0;
			left: 0;
			-webkit-transform: scale(0);
			-ms-transform: scale(0);
			-o-transform: scale(0);
			transform: scale(0);
			-webkit-transform-origin: center center;
			-ms-transform-origin: center center;
			-o-transform-origin: center center;
			transform-origin: center center
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-ZNMTqd .VfPpkd-eHTEvd::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0)
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-lJfZMc .VfPpkd-eHTEvd::after {
			-webkit-animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards;
			animation: mdc-ripple-fg-radius-in 225ms forwards, mdc-ripple-fg-opacity-in 75ms forwards
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-Tv8l5d-OmS1vf .VfPpkd-eHTEvd::after {
			-webkit-animation: mdc-ripple-fg-opacity-out .15s;
			animation: mdc-ripple-fg-opacity-out .15s;
			-webkit-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-ms-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			-o-transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1));
			transform: translate(var(--mdc-ripple-fg-translate-end, 0)) scale(var(--mdc-ripple-fg-scale, 1))
		}

		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::before,
		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::after {
			top: 0;
			left: 0;
			width: 100%;
			height: 100%
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-eHTEvd::before,
		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-eHTEvd::after {
			top: var(--mdc-ripple-top, 0);
			left: var(--mdc-ripple-left, 0);
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-eHTEvd::after {
			width: var(--mdc-ripple-fg-size, 100%);
			height: var(--mdc-ripple-fg-size, 100%)
		}

		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::before,
		.VfPpkd-GCYh9b .VfPpkd-eHTEvd::after {
			background-color: #018786;
			background-color: var(--mdc-ripple-color, var(--mdc-theme-secondary, #018786))
		}

		.VfPpkd-GCYh9b:hover .VfPpkd-eHTEvd::before,
		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-eHTEvd::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-eHTEvd::before,
		.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-eHTEvd::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-eHTEvd::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.VfPpkd-GCYh9b:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-eHTEvd::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-press-opacity, .12)
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.12)
		}

		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d .VfPpkd-RsCWK::before,
		.VfPpkd-GCYh9b.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-RsCWK::before {
			content: none
		}

		.VfPpkd-eHTEvd {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			pointer-events: none
		}

		.kDzhGf {
			z-index: 0
		}

		.kDzhGf .VfPpkd-eHTEvd::before,
		.kDzhGf .VfPpkd-eHTEvd::after {
			z-index: -1
		}

		.kDzhGf .VfPpkd-eHTEvd::before,
		.kDzhGf .VfPpkd-eHTEvd::after {
			background-color: rgb(26, 115, 232);
			background-color: var(--gm-radio-state-color, rgb(26, 115, 232))
		}

		.kDzhGf:hover .VfPpkd-eHTEvd::before,
		.kDzhGf.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-eHTEvd::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.kDzhGf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-eHTEvd::before,
		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-eHTEvd::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-eHTEvd::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-eHTEvd::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.kDzhGf .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::before,
		.kDzhGf .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::after {
			background-color: rgb(60, 64, 67);
			background-color: var(--gm-radio-state-color, rgb(60, 64, 67))
		}

		.kDzhGf:hover .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::before,
		.kDzhGf.VfPpkd-ksKsZd-XxIAqe-OWXEXe-ZmdkE .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::before {
			opacity: .04;
			opacity: var(--mdc-ripple-hover-opacity, .04)
		}

		.kDzhGf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::before,
		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::before {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .12;
			opacity: var(--mdc-ripple-focus-opacity, .12)
		}

		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d) .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::after {
			-webkit-transition: opacity .15s linear;
			-o-transition: opacity .15s linear;
			transition: opacity .15s linear
		}

		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):active .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)~.VfPpkd-eHTEvd::after {
			-webkit-transition-duration: 75ms;
			-o-transition-duration: 75ms;
			transition-duration: 75ms;
			opacity: .1;
			opacity: var(--mdc-ripple-press-opacity, .1)
		}

		.kDzhGf.VfPpkd-ksKsZd-mWPk3d {
			--mdc-ripple-fg-opacity: var(--mdc-ripple-press-opacity, 0.1)
		}

		.kDzhGf .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgb(95, 99, 104);
			border-color: var(--gm-radio-stroke-color--unchecked, rgb(95, 99, 104))
		}

		.kDzhGf .VfPpkd-gBXA9-bMcfAe:enabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgb(26, 115, 232);
			border-color: var(--gm-radio-stroke-color--checked, rgb(26, 115, 232))
		}

		.kDzhGf .VfPpkd-gBXA9-bMcfAe:enabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			border-color: rgb(26, 115, 232);
			border-color: var(--gm-radio-ink-color, rgb(26, 115, 232))
		}

		.kDzhGf [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf .VfPpkd-gBXA9-bMcfAe:disabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgba(60, 64, 67, .38);
			border-color: var(--gm-radio-disabled-stroke-color--unchecked, rgba(60, 64, 67, .38))
		}

		.kDzhGf [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf .VfPpkd-gBXA9-bMcfAe:disabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgba(60, 64, 67, .38);
			border-color: var(--gm-radio-disabled-stroke-color--checked, rgba(60, 64, 67, .38))
		}

		.kDzhGf [aria-disabled=true] .VfPpkd-gBXA9-bMcfAe+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
		.kDzhGf .VfPpkd-gBXA9-bMcfAe:disabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			border-color: rgba(60, 64, 67, .38);
			border-color: var(--gm-radio-disabled-ink-color, rgba(60, 64, 67, .38))
		}

		.kDzhGf .VfPpkd-RsCWK::before {
			background-color: rgb(26, 115, 232);
			background-color: var(--gm-radio-state-color, rgb(26, 115, 232))
		}

		.kDzhGf:hover .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf:active .VfPpkd-gBXA9-bMcfAe:enabled:not(:checked)+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgb(32, 33, 36);
			border-color: var(--gm-radio-stroke-color--unchecked-stateful, rgb(32, 33, 36))
		}

		.kDzhGf:hover .VfPpkd-gBXA9-bMcfAe:enabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-gBXA9-bMcfAe:enabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-gBXA9-bMcfAe:enabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo,
		.kDzhGf:active .VfPpkd-gBXA9-bMcfAe:enabled:checked+.VfPpkd-RsCWK .VfPpkd-wVo5xe-LkdAo {
			border-color: rgb(23, 78, 166);
			border-color: var(--gm-radio-stroke-color--checked-stateful, rgb(23, 78, 166))
		}

		.kDzhGf:hover .VfPpkd-gBXA9-bMcfAe:enabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
		.kDzhGf.VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe .VfPpkd-gBXA9-bMcfAe:enabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
		.kDzhGf:not(.VfPpkd-ksKsZd-mWPk3d):focus .VfPpkd-gBXA9-bMcfAe:enabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo,
		.kDzhGf:active .VfPpkd-gBXA9-bMcfAe:enabled+.VfPpkd-RsCWK .VfPpkd-Z5TpLc-LkdAo {
			border-color: rgb(23, 78, 166);
			border-color: var(--gm-radio-ink-color--stateful, rgb(23, 78, 166))
		}

		.wHsUjf {
			will-change: unset
		}

		.VfPpkd-NLUYnc-V67aGc {
			position: absolute;
			left: 0;
			-webkit-transform-origin: left top;
			-ms-transform-origin: left top;
			-o-transform-origin: left top;
			transform-origin: left top;
			line-height: 1.15rem;
			text-align: left;
			text-overflow: ellipsis;
			white-space: nowrap;
			cursor: text;
			overflow: hidden;
			will-change: transform
		}

		[dir=rtl] .VfPpkd-NLUYnc-V67aGc,
		.VfPpkd-NLUYnc-V67aGc[dir=rtl] {
			right: 0;
			left: auto;
			-webkit-transform-origin: right top;
			-ms-transform-origin: right top;
			-o-transform-origin: right top;
			transform-origin: right top;
			text-align: right
		}

		.VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			cursor: auto
		}

		.VfPpkd-NLUYnc-V67aGc-OWXEXe-ztc6md:not(.VfPpkd-NLUYnc-V67aGc-OWXEXe-ZYIfFd-ztc6md-vXpfLb)::after {
			margin-left: 1px;
			margin-right: 0;
			content: "*"
		}

		[dir=rtl] .VfPpkd-NLUYnc-V67aGc-OWXEXe-ztc6md:not(.VfPpkd-NLUYnc-V67aGc-OWXEXe-ZYIfFd-ztc6md-vXpfLb)::after,
		.VfPpkd-NLUYnc-V67aGc-OWXEXe-ztc6md:not(.VfPpkd-NLUYnc-V67aGc-OWXEXe-ZYIfFd-ztc6md-vXpfLb)[dir=rtl]::after {
			margin-left: 0;
			margin-right: 1px
		}

		.VfPpkd-NLUYnc-V67aGc {
			-moz-osx-font-smoothing: grayscale;
			-webkit-font-smoothing: antialiased;
			font-family: Roboto, sans-serif;
			font-family: var(--mdc-typography-subtitle1-font-family, var(--mdc-typography-font-family, Roboto, sans-serif));
			font-size: 1rem;
			font-size: var(--mdc-typography-subtitle1-font-size, 1rem);
			font-weight: 400;
			font-weight: var(--mdc-typography-subtitle1-font-weight, 400);
			letter-spacing: .009375em;
			letter-spacing: var(--mdc-typography-subtitle1-letter-spacing, .009375em);
			text-decoration: inherit;
			-webkit-text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-decoration: var(--mdc-typography-subtitle1-text-decoration, inherit);
			text-transform: inherit;
			text-transform: var(--mdc-typography-subtitle1-text-transform, inherit);
			-webkit-transition: color .15s cubic-bezier(.4, 0, .2, 1), -webkit-transform .15s cubic-bezier(.4, 0, .2, 1);
			transition: color .15s cubic-bezier(.4, 0, .2, 1), -webkit-transform .15s cubic-bezier(.4, 0, .2, 1);
			-o-transition: color .15s cubic-bezier(.4, 0, .2, 1), -o-transform .15s cubic-bezier(.4, 0, .2, 1);
			transition: transform .15s cubic-bezier(.4, 0, .2, 1), color .15s cubic-bezier(.4, 0, .2, 1);
			transition: transform .15s cubic-bezier(.4, 0, .2, 1), color .15s cubic-bezier(.4, 0, .2, 1), -webkit-transform .15s cubic-bezier(.4, 0, .2, 1), -o-transform .15s cubic-bezier(.4, 0, .2, 1)
		}

		.VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-106%) scale(.75);
			-ms-transform: translateY(-106%) scale(.75);
			-o-transform: translateY(-106%) scale(.75);
			transform: translateY(-106%) scale(.75)
		}

		.VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above-standard .25s 1;
			animation: mdc-floating-label-shake-float-above-standard .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above-standard {
			0% {
				-webkit-transform: translateX(0) translateY(-106%) scale(.75);
				transform: translateX(0) translateY(-106%) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(4%) translateY(-106%) scale(.75);
				transform: translateX(4%) translateY(-106%) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(-4%) translateY(-106%) scale(.75);
				transform: translateX(-4%) translateY(-106%) scale(.75)
			}

			100% {
				-webkit-transform: translateX(0) translateY(-106%) scale(.75);
				transform: translateX(0) translateY(-106%) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above-standard {
			0% {
				-webkit-transform: translateX(0) translateY(-106%) scale(.75);
				-o-transform: translateX(0) translateY(-106%) scale(.75);
				transform: translateX(0) translateY(-106%) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(4%) translateY(-106%) scale(.75);
				-o-transform: translateX(4%) translateY(-106%) scale(.75);
				transform: translateX(4%) translateY(-106%) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(-4%) translateY(-106%) scale(.75);
				-o-transform: translateX(-4%) translateY(-106%) scale(.75);
				transform: translateX(-4%) translateY(-106%) scale(.75)
			}

			100% {
				-webkit-transform: translateX(0) translateY(-106%) scale(.75);
				-o-transform: translateX(0) translateY(-106%) scale(.75);
				transform: translateX(0) translateY(-106%) scale(.75)
			}
		}

		.VfPpkd-RWgCYc-ksKsZd::before,
		.VfPpkd-RWgCYc-ksKsZd::after {
			position: absolute;
			bottom: 0;
			left: 0;
			width: 100%;
			border-bottom-style: solid;
			content: ""
		}

		.VfPpkd-RWgCYc-ksKsZd::before {
			z-index: 1
		}

		.VfPpkd-RWgCYc-ksKsZd::after {
			-webkit-transform: scaleX(0);
			-ms-transform: scaleX(0);
			-o-transform: scaleX(0);
			transform: scaleX(0);
			opacity: 0;
			z-index: 2
		}

		.VfPpkd-RWgCYc-ksKsZd-OWXEXe-auswjd::after {
			-webkit-transform: scaleX(1);
			-ms-transform: scaleX(1);
			-o-transform: scaleX(1);
			transform: scaleX(1);
			opacity: 1
		}

		.VfPpkd-RWgCYc-ksKsZd-OWXEXe-JD038d::after {
			opacity: 0
		}

		.VfPpkd-RWgCYc-ksKsZd::before {
			border-bottom-width: 1px
		}

		.VfPpkd-RWgCYc-ksKsZd::after {
			border-bottom-width: 2px
		}

		.VfPpkd-RWgCYc-ksKsZd::after {
			-webkit-transition: opacity .18s cubic-bezier(.4, 0, .2, 1), -webkit-transform .18s cubic-bezier(.4, 0, .2, 1);
			transition: opacity .18s cubic-bezier(.4, 0, .2, 1), -webkit-transform .18s cubic-bezier(.4, 0, .2, 1);
			-o-transition: opacity .18s cubic-bezier(.4, 0, .2, 1), -o-transform .18s cubic-bezier(.4, 0, .2, 1);
			transition: transform .18s cubic-bezier(.4, 0, .2, 1), opacity .18s cubic-bezier(.4, 0, .2, 1);
			transition: transform .18s cubic-bezier(.4, 0, .2, 1), opacity .18s cubic-bezier(.4, 0, .2, 1), -webkit-transform .18s cubic-bezier(.4, 0, .2, 1), -o-transform .18s cubic-bezier(.4, 0, .2, 1)
		}

		.VfPpkd-NSFCdd-i5vt6e {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			position: absolute;
			top: 0;
			right: 0;
			left: 0;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			width: 100%;
			max-width: 100%;
			height: 100%;
			text-align: left;
			pointer-events: none
		}

		[dir=rtl] .VfPpkd-NSFCdd-i5vt6e,
		.VfPpkd-NSFCdd-i5vt6e[dir=rtl] {
			text-align: right
		}

		.VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-NSFCdd-MpmGFe {
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			height: 100%;
			pointer-events: none
		}

		.VfPpkd-NSFCdd-MpmGFe {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.VfPpkd-NSFCdd-Ra9xwd {
			-webkit-box-flex: 0;
			-webkit-flex: 0 0 auto;
			flex: 0 0 auto;
			width: auto
		}

		.VfPpkd-NSFCdd-i5vt6e .VfPpkd-NLUYnc-V67aGc {
			display: inline-block;
			position: relative;
			max-width: 100%
		}

		.VfPpkd-NSFCdd-i5vt6e .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			text-overflow: clip
		}

		.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			max-width: 133.3333333333%
		}

		.VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd .VfPpkd-NSFCdd-Ra9xwd {
			padding-left: 0;
			padding-right: 8px;
			border-top: none
		}

		[dir=rtl] .VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd .VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd .VfPpkd-NSFCdd-Ra9xwd[dir=rtl] {
			padding-left: 8px;
			padding-right: 0
		}

		.VfPpkd-NSFCdd-i5vt6e-OWXEXe-di8rgd-V67aGc .VfPpkd-NSFCdd-Ra9xwd {
			display: none
		}

		.VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-NSFCdd-Ra9xwd,
		.VfPpkd-NSFCdd-MpmGFe {
			border-top: 1px solid;
			border-bottom: 1px solid
		}

		.VfPpkd-NSFCdd-Brv4Fb {
			border-left: 1px solid;
			border-right: none;
			width: 12px
		}

		[dir=rtl] .VfPpkd-NSFCdd-Brv4Fb,
		.VfPpkd-NSFCdd-Brv4Fb[dir=rtl] {
			border-left: none;
			border-right: 1px solid
		}

		.VfPpkd-NSFCdd-MpmGFe {
			border-left: none;
			border-right: 1px solid
		}

		[dir=rtl] .VfPpkd-NSFCdd-MpmGFe,
		.VfPpkd-NSFCdd-MpmGFe[dir=rtl] {
			border-left: 1px solid;
			border-right: none
		}

		.VfPpkd-NSFCdd-Ra9xwd {
			max-width: calc(100% - 24px)
		}

		@-webkit-keyframes primary-indeterminate-translate {
			0% {
				-webkit-transform: translateX(-145.166611%);
				-webkit-transform: translateX(-145.166611%);
				-ms-transform: translateX(-145.166611%);
				-o-transform: translateX(-145.166611%);
				transform: translateX(-145.166611%)
			}

			20% {
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-o-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-transform: translateX(-145.166611%);
				-webkit-transform: translateX(-145.166611%);
				-ms-transform: translateX(-145.166611%);
				-o-transform: translateX(-145.166611%);
				transform: translateX(-145.166611%)
			}

			59.15% {
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-o-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-transform: translateX(-61.495191%);
				-webkit-transform: translateX(-61.495191%);
				-ms-transform: translateX(-61.495191%);
				-o-transform: translateX(-61.495191%);
				transform: translateX(-61.495191%)
			}

			to {
				-webkit-transform: translateX(55.444446%);
				-webkit-transform: translateX(55.444446%);
				-ms-transform: translateX(55.444446%);
				-o-transform: translateX(55.444446%);
				transform: translateX(55.444446%)
			}
		}

		@keyframes primary-indeterminate-translate {
			0% {
				-webkit-transform: translateX(-145.166611%);
				-webkit-transform: translateX(-145.166611%);
				-ms-transform: translateX(-145.166611%);
				-o-transform: translateX(-145.166611%);
				transform: translateX(-145.166611%)
			}

			20% {
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-o-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-transform: translateX(-145.166611%);
				-webkit-transform: translateX(-145.166611%);
				-ms-transform: translateX(-145.166611%);
				-o-transform: translateX(-145.166611%);
				transform: translateX(-145.166611%)
			}

			59.15% {
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-o-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-transform: translateX(-61.495191%);
				-webkit-transform: translateX(-61.495191%);
				-ms-transform: translateX(-61.495191%);
				-o-transform: translateX(-61.495191%);
				transform: translateX(-61.495191%)
			}

			to {
				-webkit-transform: translateX(55.444446%);
				-webkit-transform: translateX(55.444446%);
				-ms-transform: translateX(55.444446%);
				-o-transform: translateX(55.444446%);
				transform: translateX(55.444446%)
			}
		}

		@-webkit-keyframes primary-indeterminate-translate-reverse {
			0% {
				-webkit-transform: translateX(145.166611%);
				-webkit-transform: translateX(145.166611%);
				-ms-transform: translateX(145.166611%);
				-o-transform: translateX(145.166611%);
				transform: translateX(145.166611%)
			}

			20% {
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-o-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-transform: translateX(145.166611%);
				-webkit-transform: translateX(145.166611%);
				-ms-transform: translateX(145.166611%);
				-o-transform: translateX(145.166611%);
				transform: translateX(145.166611%)
			}

			59.15% {
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-o-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-transform: translateX(61.495191%);
				-webkit-transform: translateX(61.495191%);
				-ms-transform: translateX(61.495191%);
				-o-transform: translateX(61.495191%);
				transform: translateX(61.495191%)
			}

			to {
				-webkit-transform: translateX(-55.4444461%);
				-webkit-transform: translateX(-55.4444461%);
				-ms-transform: translateX(-55.4444461%);
				-o-transform: translateX(-55.4444461%);
				transform: translateX(-55.4444461%)
			}
		}

		@keyframes primary-indeterminate-translate-reverse {
			0% {
				-webkit-transform: translateX(145.166611%);
				-webkit-transform: translateX(145.166611%);
				-ms-transform: translateX(145.166611%);
				-o-transform: translateX(145.166611%);
				transform: translateX(145.166611%)
			}

			20% {
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-o-animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				animation-timing-function: cubic-bezier(0.5, 0, 0.701732, 0.495819);
				-webkit-transform: translateX(145.166611%);
				-webkit-transform: translateX(145.166611%);
				-ms-transform: translateX(145.166611%);
				-o-transform: translateX(145.166611%);
				transform: translateX(145.166611%)
			}

			59.15% {
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-o-animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				animation-timing-function: cubic-bezier(0.302435, 0.381352, 0.55, 0.956352);
				-webkit-transform: translateX(61.495191%);
				-webkit-transform: translateX(61.495191%);
				-ms-transform: translateX(61.495191%);
				-o-transform: translateX(61.495191%);
				transform: translateX(61.495191%)
			}

			to {
				-webkit-transform: translateX(-55.4444461%);
				-webkit-transform: translateX(-55.4444461%);
				-ms-transform: translateX(-55.4444461%);
				-o-transform: translateX(-55.4444461%);
				transform: translateX(-55.4444461%)
			}
		}

		@-webkit-keyframes primary-indeterminate-scale {
			0% {
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}

			36.65% {
				-webkit-animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				-webkit-animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				-o-animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}

			69.15% {
				-webkit-animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				-webkit-animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				-o-animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				-webkit-transform: scaleX(0.661479);
				-webkit-transform: scaleX(0.661479);
				-ms-transform: scaleX(0.661479);
				-o-transform: scaleX(0.661479);
				transform: scaleX(0.661479)
			}

			to {
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}
		}

		@keyframes primary-indeterminate-scale {
			0% {
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}

			36.65% {
				-webkit-animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				-webkit-animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				-o-animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				animation-timing-function: cubic-bezier(0.334731, 0.12482, 0.785844, 1);
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}

			69.15% {
				-webkit-animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				-webkit-animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				-o-animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				animation-timing-function: cubic-bezier(0.06, 0.11, 0.6, 1);
				-webkit-transform: scaleX(0.661479);
				-webkit-transform: scaleX(0.661479);
				-ms-transform: scaleX(0.661479);
				-o-transform: scaleX(0.661479);
				transform: scaleX(0.661479)
			}

			to {
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}
		}

		@-webkit-keyframes auxiliary-indeterminate-translate {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-o-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-transform: translateX(-54.888891%);
				-webkit-transform: translateX(-54.888891%);
				-ms-transform: translateX(-54.888891%);
				-o-transform: translateX(-54.888891%);
				transform: translateX(-54.888891%)
			}

			25% {
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-o-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-transform: translateX(-17.236978%);
				-webkit-transform: translateX(-17.236978%);
				-ms-transform: translateX(-17.236978%);
				-o-transform: translateX(-17.236978%);
				transform: translateX(-17.236978%)
			}

			48.35% {
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-o-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-transform: translateX(29.497274%);
				-webkit-transform: translateX(29.497274%);
				-ms-transform: translateX(29.497274%);
				-o-transform: translateX(29.497274%);
				transform: translateX(29.497274%)
			}

			to {
				-webkit-transform: translateX(105.388891%);
				-webkit-transform: translateX(105.388891%);
				-ms-transform: translateX(105.388891%);
				-o-transform: translateX(105.388891%);
				transform: translateX(105.388891%)
			}
		}

		@keyframes auxiliary-indeterminate-translate {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-o-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-transform: translateX(-54.888891%);
				-webkit-transform: translateX(-54.888891%);
				-ms-transform: translateX(-54.888891%);
				-o-transform: translateX(-54.888891%);
				transform: translateX(-54.888891%)
			}

			25% {
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-o-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-transform: translateX(-17.236978%);
				-webkit-transform: translateX(-17.236978%);
				-ms-transform: translateX(-17.236978%);
				-o-transform: translateX(-17.236978%);
				transform: translateX(-17.236978%)
			}

			48.35% {
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-o-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-transform: translateX(29.497274%);
				-webkit-transform: translateX(29.497274%);
				-ms-transform: translateX(29.497274%);
				-o-transform: translateX(29.497274%);
				transform: translateX(29.497274%)
			}

			to {
				-webkit-transform: translateX(105.388891%);
				-webkit-transform: translateX(105.388891%);
				-ms-transform: translateX(105.388891%);
				-o-transform: translateX(105.388891%);
				transform: translateX(105.388891%)
			}
		}

		@-webkit-keyframes auxiliary-indeterminate-translate-reverse {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-o-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-transform: translateX(54.888891%);
				-webkit-transform: translateX(54.888891%);
				-ms-transform: translateX(54.888891%);
				-o-transform: translateX(54.888891%);
				transform: translateX(54.888891%)
			}

			25% {
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-o-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-transform: translateX(17.236978%);
				-webkit-transform: translateX(17.236978%);
				-ms-transform: translateX(17.236978%);
				-o-transform: translateX(17.236978%);
				transform: translateX(17.236978%)
			}

			48.35% {
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-o-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-transform: translateX(-29.497274%);
				-webkit-transform: translateX(-29.497274%);
				-ms-transform: translateX(-29.497274%);
				-o-transform: translateX(-29.497274%);
				transform: translateX(-29.497274%)
			}

			to {
				-webkit-transform: translateX(-105.388891%);
				-webkit-transform: translateX(-105.388891%);
				-ms-transform: translateX(-105.388891%);
				-o-transform: translateX(-105.388891%);
				transform: translateX(-105.388891%)
			}
		}

		@keyframes auxiliary-indeterminate-translate-reverse {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-o-animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				animation-timing-function: cubic-bezier(0.15, 0, 0.515058, 0.409685);
				-webkit-transform: translateX(54.888891%);
				-webkit-transform: translateX(54.888891%);
				-ms-transform: translateX(54.888891%);
				-o-transform: translateX(54.888891%);
				transform: translateX(54.888891%)
			}

			25% {
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-o-animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				animation-timing-function: cubic-bezier(0.31033, 0.284058, 0.8, 0.733712);
				-webkit-transform: translateX(17.236978%);
				-webkit-transform: translateX(17.236978%);
				-ms-transform: translateX(17.236978%);
				-o-transform: translateX(17.236978%);
				transform: translateX(17.236978%)
			}

			48.35% {
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-o-animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				animation-timing-function: cubic-bezier(0.4, 0.627035, 0.6, 0.902026);
				-webkit-transform: translateX(-29.497274%);
				-webkit-transform: translateX(-29.497274%);
				-ms-transform: translateX(-29.497274%);
				-o-transform: translateX(-29.497274%);
				transform: translateX(-29.497274%)
			}

			to {
				-webkit-transform: translateX(-105.388891%);
				-webkit-transform: translateX(-105.388891%);
				-ms-transform: translateX(-105.388891%);
				-o-transform: translateX(-105.388891%);
				transform: translateX(-105.388891%)
			}
		}

		@-webkit-keyframes auxiliary-indeterminate-scale {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				-webkit-animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				-o-animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}

			19.15% {
				-webkit-animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				-webkit-animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				-o-animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				-webkit-transform: scaleX(0.457104);
				-webkit-transform: scaleX(0.457104);
				-ms-transform: scaleX(0.457104);
				-o-transform: scaleX(0.457104);
				transform: scaleX(0.457104)
			}

			44.15% {
				-webkit-animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				-webkit-animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				-o-animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				-webkit-transform: scaleX(0.72796);
				-webkit-transform: scaleX(0.72796);
				-ms-transform: scaleX(0.72796);
				-o-transform: scaleX(0.72796);
				transform: scaleX(0.72796)
			}

			to {
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}
		}

		@keyframes auxiliary-indeterminate-scale {
			0% {
				-webkit-animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				-webkit-animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				-o-animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				animation-timing-function: cubic-bezier(0.205028, 0.057051, 0.57661, 0.453971);
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}

			19.15% {
				-webkit-animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				-webkit-animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				-o-animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				animation-timing-function: cubic-bezier(0.152313, 0.196432, 0.648374, 1.004315);
				-webkit-transform: scaleX(0.457104);
				-webkit-transform: scaleX(0.457104);
				-ms-transform: scaleX(0.457104);
				-o-transform: scaleX(0.457104);
				transform: scaleX(0.457104)
			}

			44.15% {
				-webkit-animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				-webkit-animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				-o-animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				animation-timing-function: cubic-bezier(0.257759, 0.003163, 0.211762, 1.38179);
				-webkit-transform: scaleX(0.72796);
				-webkit-transform: scaleX(0.72796);
				-ms-transform: scaleX(0.72796);
				-o-transform: scaleX(0.72796);
				transform: scaleX(0.72796)
			}

			to {
				-webkit-transform: scaleX(0.08);
				-webkit-transform: scaleX(0.08);
				-ms-transform: scaleX(0.08);
				-o-transform: scaleX(0.08);
				transform: scaleX(0.08)
			}
		}

		@-webkit-keyframes buffering {
			to {
				-webkit-transform: translateX(-10px);
				-webkit-transform: translateX(-10px);
				-ms-transform: translateX(-10px);
				-o-transform: translateX(-10px);
				transform: translateX(-10px)
			}
		}

		@keyframes buffering {
			to {
				-webkit-transform: translateX(-10px);
				-webkit-transform: translateX(-10px);
				-ms-transform: translateX(-10px);
				-o-transform: translateX(-10px);
				transform: translateX(-10px)
			}
		}

		@-webkit-keyframes buffering-reverse {
			to {
				-webkit-transform: translateX(10px);
				-webkit-transform: translateX(10px);
				-ms-transform: translateX(10px);
				-o-transform: translateX(10px);
				transform: translateX(10px)
			}
		}

		@keyframes buffering-reverse {
			to {
				-webkit-transform: translateX(10px);
				-webkit-transform: translateX(10px);
				-ms-transform: translateX(10px);
				-o-transform: translateX(10px);
				transform: translateX(10px)
			}
		}

		@-webkit-keyframes indeterminate-translate-ie {
			0% {
				-webkit-transform: translateX(-100%);
				-webkit-transform: translateX(-100%);
				-ms-transform: translateX(-100%);
				-o-transform: translateX(-100%);
				transform: translateX(-100%)
			}

			to {
				-webkit-transform: translateX(100%);
				-webkit-transform: translateX(100%);
				-ms-transform: translateX(100%);
				-o-transform: translateX(100%);
				transform: translateX(100%)
			}
		}

		@keyframes indeterminate-translate-ie {
			0% {
				-webkit-transform: translateX(-100%);
				-webkit-transform: translateX(-100%);
				-ms-transform: translateX(-100%);
				-o-transform: translateX(-100%);
				transform: translateX(-100%)
			}

			to {
				-webkit-transform: translateX(100%);
				-webkit-transform: translateX(100%);
				-ms-transform: translateX(100%);
				-o-transform: translateX(100%);
				transform: translateX(100%)
			}
		}

		@-webkit-keyframes indeterminate-translate-reverse-ie {
			0% {
				-webkit-transform: translateX(100%);
				-webkit-transform: translateX(100%);
				-ms-transform: translateX(100%);
				-o-transform: translateX(100%);
				transform: translateX(100%)
			}

			to {
				-webkit-transform: translateX(-100%);
				-webkit-transform: translateX(-100%);
				-ms-transform: translateX(-100%);
				-o-transform: translateX(-100%);
				transform: translateX(-100%)
			}
		}

		@keyframes indeterminate-translate-reverse-ie {
			0% {
				-webkit-transform: translateX(100%);
				-webkit-transform: translateX(100%);
				-ms-transform: translateX(100%);
				-o-transform: translateX(100%);
				transform: translateX(100%)
			}

			to {
				-webkit-transform: translateX(-100%);
				-webkit-transform: translateX(-100%);
				-ms-transform: translateX(-100%);
				-o-transform: translateX(-100%);
				transform: translateX(-100%)
			}
		}

		.sZwd7c {
			height: 4px;
			overflow: hidden;
			position: relative;
			-webkit-transform: translateZ(0);
			-webkit-transform: translateZ(0);
			-ms-transform: translateZ(0);
			-o-transform: translateZ(0);
			transform: translateZ(0);
			-webkit-transition: opacity 250ms linear;
			-webkit-transition: opacity 250ms linear;
			-o-transition: opacity 250ms linear;
			transition: opacity 250ms linear;
			width: 100%
		}

		.w2zcLc {
			position: absolute
		}

		.xcNBHc,
		.MyvhI,
		.l3q5xe {
			height: 100%;
			position: absolute;
			width: 100%
		}

		.w2zcLc {
			-ms-transform-origin: top left;
			-o-transform-origin: top left;
			transform-origin: top left;
			-o-transition: -webkit-transform 250ms ease;
			transition: -webkit-transform 250ms ease;
			-o-transition: transform 250ms ease;
			transition: transform 250ms ease;
			-o-transition: transform 250ms ease, -webkit-transform 250ms ease;
			transition: transform 250ms ease, -webkit-transform 250ms ease
		}

		.MyvhI {
			-webkit-transform-origin: top left;
			-webkit-transform-origin: top left;
			-ms-transform-origin: top left;
			-o-transform-origin: top left;
			transform-origin: top left;
			-webkit-transition: -webkit-transform 250ms ease;
			-webkit-transition: -webkit-transform 250ms ease;
			-o-transition: -webkit-transform 250ms ease;
			transition: -webkit-transform 250ms ease;
			-webkit-transition: transform 250ms ease;
			-o-transition: transform 250ms ease;
			transition: transform 250ms ease;
			-webkit-transition: transform 250ms ease, -webkit-transform 250ms ease;
			-o-transition: transform 250ms ease, -webkit-transform 250ms ease;
			transition: transform 250ms ease, -webkit-transform 250ms ease;
			-webkit-animation: none;
			-webkit-animation: none;
			-o-animation: none;
			animation: none
		}

		.l3q5xe {
			-webkit-animation: none;
			-webkit-animation: none;
			-o-animation: none;
			animation: none
		}

		.w2zcLc {
			background-color: #e6e6e6;
			height: 100%;
			-webkit-transform-origin: top left;
			-webkit-transform-origin: top left;
			-ms-transform-origin: top left;
			-o-transform-origin: top left;
			transform-origin: top left;
			-webkit-transition: -webkit-transform 250ms ease;
			-webkit-transition: -webkit-transform 250ms ease;
			-o-transition: -webkit-transform 250ms ease;
			transition: -webkit-transform 250ms ease;
			-webkit-transition: transform 250ms ease;
			-o-transition: transform 250ms ease;
			transition: transform 250ms ease;
			-webkit-transition: transform 250ms ease, -webkit-transform 250ms ease;
			-o-transition: transform 250ms ease, -webkit-transform 250ms ease;
			transition: transform 250ms ease, -webkit-transform 250ms ease;
			width: 100%
		}

		.TKVRUb {
			-webkit-transform: scaleX(0);
			-webkit-transform: scaleX(0);
			-ms-transform: scaleX(0);
			-o-transform: scaleX(0);
			transform: scaleX(0)
		}

		.sUoeld {
			visibility: hidden
		}

		.l3q5xe {
			background-color: #000;
			display: inline-block
		}

		.xcNBHc {
			-webkit-background-size: 10px 4px;
			-o-background-size: 10px 4px;
			background-size: 10px 4px;
			background-repeat: repeat-x;
			background-image: url('data:image/svg+xml;charset=UTF-8,%3Csvg%20version%3D%271.1%27%20xmlns%3D%27http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%27%20xmlns%3Axlink%3D%27http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%27%20x%3D%270px%27%20y%3D%270px%27%20enable-background%3D%27new%200%200%205%202%27%20xml%3Aspace%3D%27preserve%27%20viewBox%3D%270%200%205%202%27%20preserveAspectRatio%3D%27none%20slice%27%3E%3Ccircle%20cx%3D%271%27%20cy%3D%271%27%20r%3D%271%27%20fill%3D%27%23e6e6e6%27%2F%3E%3C%2Fsvg%3E');
			visibility: hidden
		}

		.sZwd7c.B6Vhqe .MyvhI {
			-webkit-transition: none;
			-webkit-transition: none;
			-o-transition: none;
			transition: none
		}

		.sZwd7c.B6Vhqe .TKVRUb {
			-webkit-animation: primary-indeterminate-translate 2s infinite linear;
			-webkit-animation: primary-indeterminate-translate 2s infinite linear;
			-o-animation: primary-indeterminate-translate 2s infinite linear;
			animation: primary-indeterminate-translate 2s infinite linear
		}

		.sZwd7c.B6Vhqe .TKVRUb>.l3q5xe {
			-webkit-animation: primary-indeterminate-scale 2s infinite linear;
			-webkit-animation: primary-indeterminate-scale 2s infinite linear;
			-o-animation: primary-indeterminate-scale 2s infinite linear;
			animation: primary-indeterminate-scale 2s infinite linear
		}

		.sZwd7c.B6Vhqe .sUoeld {
			-webkit-animation: auxiliary-indeterminate-translate 2s infinite linear;
			-webkit-animation: auxiliary-indeterminate-translate 2s infinite linear;
			-o-animation: auxiliary-indeterminate-translate 2s infinite linear;
			animation: auxiliary-indeterminate-translate 2s infinite linear;
			visibility: visible
		}

		.sZwd7c.B6Vhqe .sUoeld>.l3q5xe {
			-webkit-animation: auxiliary-indeterminate-scale 2s infinite linear;
			-webkit-animation: auxiliary-indeterminate-scale 2s infinite linear;
			-o-animation: auxiliary-indeterminate-scale 2s infinite linear;
			animation: auxiliary-indeterminate-scale 2s infinite linear
		}

		.sZwd7c.B6Vhqe.ieri7c .l3q5xe {
			-webkit-transform: scaleX(0.45);
			-webkit-transform: scaleX(0.45);
			-ms-transform: scaleX(0.45);
			-o-transform: scaleX(0.45);
			transform: scaleX(0.45)
		}

		.sZwd7c.B6Vhqe.ieri7c .sUoeld {
			-webkit-animation: none;
			-webkit-animation: none;
			-o-animation: none;
			animation: none;
			visibility: hidden
		}

		.sZwd7c.B6Vhqe.ieri7c .TKVRUb {
			-webkit-animation: indeterminate-translate-ie 2s infinite ease-out;
			-webkit-animation: indeterminate-translate-ie 2s infinite ease-out;
			-o-animation: indeterminate-translate-ie 2s infinite ease-out;
			animation: indeterminate-translate-ie 2s infinite ease-out
		}

		.sZwd7c.B6Vhqe.ieri7c .TKVRUb>.l3q5xe,
		.sZwd7c.B6Vhqe.ieri7c .sUoeld>.l3q5xe {
			-webkit-animation: none;
			-webkit-animation: none;
			-o-animation: none;
			animation: none
		}

		.sZwd7c.juhVM .w2zcLc,
		.sZwd7c.juhVM .MyvhI {
			right: 0;
			-webkit-transform-origin: center right;
			-webkit-transform-origin: center right;
			-ms-transform-origin: center right;
			-o-transform-origin: center right;
			transform-origin: center right
		}

		.sZwd7c.juhVM .TKVRUb {
			-webkit-animation-name: primary-indeterminate-translate-reverse;
			-webkit-animation-name: primary-indeterminate-translate-reverse;
			-o-animation-name: primary-indeterminate-translate-reverse;
			animation-name: primary-indeterminate-translate-reverse
		}

		.sZwd7c.juhVM .sUoeld {
			-webkit-animation-name: auxiliary-indeterminate-translate-reverse;
			-webkit-animation-name: auxiliary-indeterminate-translate-reverse;
			-o-animation-name: auxiliary-indeterminate-translate-reverse;
			animation-name: auxiliary-indeterminate-translate-reverse
		}

		.sZwd7c.juhVM.ieri7c .TKVRUb {
			-webkit-animation-name: indeterminate-translate-reverse-ie;
			-webkit-animation-name: indeterminate-translate-reverse-ie;
			-o-animation-name: indeterminate-translate-reverse-ie;
			animation-name: indeterminate-translate-reverse-ie
		}

		.sZwd7c.qdulke {
			opacity: 0
		}

		.sZwd7c.jK7moc .sUoeld,
		.sZwd7c.jK7moc .TKVRUb,
		.sZwd7c.jK7moc .sUoeld>.l3q5xe,
		.sZwd7c.jK7moc .TKVRUb>.l3q5xe {
			-webkit-animation-play-state: paused;
			animation-play-state: paused
		}

		.sZwd7c.D6TUi .xcNBHc {
			-webkit-animation: buffering 250ms infinite linear;
			-webkit-animation: buffering 250ms infinite linear;
			-o-animation: buffering 250ms infinite linear;
			animation: buffering 250ms infinite linear;
			visibility: visible
		}

		.sZwd7c.D6TUi.juhVM .xcNBHc {
			-webkit-animation: buffering-reverse 250ms infinite linear;
			-webkit-animation: buffering-reverse 250ms infinite linear;
			-o-animation: buffering-reverse 250ms infinite linear;
			animation: buffering-reverse 250ms infinite linear
		}

		.BrpTO {
			margin: auto;
			max-width: 380px;
			overflow: hidden;
			position: relative
		}

		.BrpTO .Q8ElWe {
			position: relative;
			text-align: center
		}

		.viAgtf {
			border-radius: 50%;
			color: rgb(95, 99, 104);
			overflow: hidden
		}

		.eCirAf {
			line-height: 1.4286
		}

		.cABCAe {
			width: 100%
		}

		.cABCAe .viAgtf {
			-webkit-box-flex: 0;
			-webkit-flex: none;
			flex: none;
			height: 28px;
			margin-right: 12px;
			width: 28px
		}

		.cABCAe .Q8ElWe,
		.TPmpLe .Q8ElWe {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center
		}

		.cABCAe .Q8ElWe {
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center
		}

		.BrpTO .viAgtf {
			height: 64px;
			margin: 0 auto 8px;
			width: 64px
		}

		.rs3gSb {
			border-radius: 50%;
			display: block
		}

		.cABCAe .rs3gSb,
		.cABCAe .hZUije,
		.cABCAe .kHluYc {
			max-height: 100%;
			max-width: 100%
		}

		.BrpTO .rs3gSb,
		.BrpTO .hZUije,
		.BrpTO .kHluYc {
			height: 64px;
			width: 64px
		}

		.TPmpLe {
			height: 20px
		}

		.TPmpLe .viAgtf {
			margin-right: 8px;
			height: 20px;
			min-width: 20px
		}

		.TPmpLe .rs3gSb,
		.TPmpLe .hZUije,
		.TPmpLe .kHluYc {
			color: rgb(60, 64, 67);
			height: 20px;
			width: 20px
		}

		.TPmpLe .kk39Eb {
			overflow: hidden
		}

		.TPmpLe .yavlK {
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap
		}

		.cABCAe .kk39Eb {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.cABCAe .eCirAf {
			color: rgb(60, 64, 67);
			font-size: 14px;
			font-weight: 500
		}

		.BrpTO .eCirAf {
			color: rgb(32, 33, 36);
			font-size: 16px
		}

		.yavlK,
		.FzDwd {
			direction: ltr;
			font-size: 12px;
			text-align: left;
			line-height: 1.3333;
			word-break: break-all
		}

		.FzDwd {
			color: rgb(95, 99, 104)
		}

		.TPmpLe .yavlK {
			color: rgb(60, 64, 67)
		}

		.cABCAe .yavlK {
			color: rgb(95, 99, 104)
		}

		.BrpTO .yavlK {
			color: rgb(95, 99, 104);
			text-align: center
		}

		.BtUzhd {
			color: rgb(95, 99, 104);
			font-size: 12px
		}

		.cABCAe .BtUzhd {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			-webkit-box-flex: 0;
			-webkit-flex: none;
			flex: none;
			line-height: 1.3333
		}

		.HUYFt {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-moz-flex-wrap: wrap;
			-ms-flex-wrap: wrap;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			font-size: 12px;
			-webkit-justify-content: space-between;
			justify-content: space-between;
			padding: 0 24px 14px
		}

		.HUYFt .hXs2T,
		.HUYFt .M2nKge {
			line-height: 48px
		}

		@media all and (min-width:601px) {
			.HUYFt {
				padding-left: 0;
				padding-right: 0;
				position: absolute;
				width: 100%
			}
		}

		.hXs2T .pUP0Nd {
			color: rgb(60, 64, 67)
		}

		.hXs2T {
			margin-left: -16px;
			margin-right: 16px
		}

		.N158t {
			-moz-appearance: none;
			-webkit-appearance: none;
			-webkit-appearance: none;
			-moz-appearance: none;
			appearance: none;
			background-color: transparent;
			background-image: url("data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIGhlaWdodD0iMjRweCIgdmlld0JveD0iMCAwIDI0IDI0IiB3aWR0aD0iMjRweCIgZmlsbD0iIzQ1NUE2NCI+PHBhdGggZD0iTTAgMGgyNHYyNEgwVjB6IiBmaWxsPSJub25lIi8+PHBhdGggZD0iTTcgMTBsNSA1IDUtNUg3eiIvPjwvc3ZnPg==");
			background-position: right;
			background-repeat: no-repeat;
			border: none;
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
			color: rgb(95, 99, 104);
			cursor: pointer;
			font-size: 12px;
			outline: none;
			padding: 16.0002px 24px 16.0002px 16px;
			-webkit-transition: background;
			-o-transition: background;
			transition: background
		}

		.N158t:focus {
			background-color: rgb(232, 234, 237)
		}

		.M2nKge {
			list-style: none;
			margin: 0 -16px;
			padding: 0
		}

		.vomtoe {
			display: inline-block;
			margin: 0
		}

		.pUP0Nd {
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px;
			color: rgb(95, 99, 104);
			display: inline-block;
			outline: none;
			z-index: 1
		}

		.pUP0Nd .UskCyf {
			background-color: transparent;
			padding: 6px 16px;
			-webkit-transition: background;
			-o-transition: background;
			transition: background
		}

		.pUP0Nd:focus .UskCyf {
			background-color: rgb(232, 234, 237);
			-webkit-border-radius: 4px;
			-moz-border-radius: 4px;
			border-radius: 4px
		}

		.ObDc3 {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: column;
			-webkit-flex-direction: column;
			flex-direction: column;
			margin-bottom: 32px
		}

		@media all and (min-width:840px) {
			.ObDc3 {
				margin-bottom: 32px
			}
		}

		.wsArZ[data-ss-mode="1"] .ObDc3 {
			margin-bottom: 0
		}

		@media all and (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .ObDc3 {
				margin-bottom: 0
			}
		}

		.Su9bff {
			-webkit-align-items: center;
			align-items: center
		}

		.vAV9bf {
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-weight: 400;
			line-height: 1.25;
			margin-bottom: 0;
			margin-bottom: var(--c-ts-b, 0);
			margin-top: 24px;
			margin-top: var(--c-ts-t, 24px);
			word-break: break-word;
			font-size: 2rem;
			font-size: var(--wf-tfs, 2rem)
		}

		@media all and (min-width:840px) {
			.vAV9bf {
				line-height: 1.22222222;
				font-size: 2.25rem;
				font-size: var(--wf-tfs-bp3, 2.25rem)
			}
		}

		@media all and (min-width:960px) {
			.vAV9bf {
				line-height: 1.22222222;
				font-size: 2.25rem;
				font-size: var(--wf-tfs-bp3, 2.25rem)
			}
		}

		@media all and (min-width:1600px) {
			.vAV9bf {
				line-height: 1.18181818;
				font-size: 2.75rem;
				font-size: var(--wf-tfs-bp5, 2.75rem)
			}
		}

		.gNJDp {
			color: #1f1f1f;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-weight: 400;
			letter-spacing: 0rem;
			line-height: 1.5;
			margin-bottom: 0;
			margin-bottom: var(--c-sts-b, 0);
			margin-top: 16px;
			margin-top: var(--c-sts-t, 16px);
			font-size: 1rem;
			font-size: var(--wf-stfs, 1rem)
		}

		@media all and (min-width:840px) {
			.gNJDp {
				margin-top: 24px;
				margin-top: var(--c-sts-t, 24px)
			}
		}

		@media all and (min-width:1600px) {
			.gNJDp {
				line-height: 1.5;
				font-size: 1rem;
				font-size: var(--wf-stfs-bp5, 1rem)
			}
		}

		.gNJDp:empty {
			display: none
		}

		.I7GnLc {
			font-weight: 500;
			letter-spacing: .25px;
			min-height: 24px
		}

		.SOeSgb {
			height: 32px
		}

		.I7GnLc,
		.SOeSgb {
			margin-bottom: 0;
			margin-bottom: var(--c-sts-b, 0);
			margin-top: 16px;
			margin-top: var(--c-sts-t, 16px)
		}

		@media all and (min-width:840px) {

			.I7GnLc,
			.SOeSgb {
				margin-top: 24px;
				margin-top: var(--c-sts-t, 24px)
			}
		}

		.ObDc3.ZYOIke .I7GnLc,
		.ObDc3.ZYOIke .SOeSgb {
			margin-bottom: 0;
			margin-top: 16px
		}

		@media all and (min-width:840px) {

			.ObDc3.ZYOIke .I7GnLc,
			.ObDc3.ZYOIke .SOeSgb {
				margin-top: 24px
			}
		}

		.SfkAJe {
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		:root {
			--wf-gutw-hlf: -webkit-calc(var(--c-gutw, 48px)/2);
			--wf-gutw-hlf: -moz-calc(var(--c-gutw, 48px)/2);
			--wf-gutw-hlf: calc(var(--c-gutw, 48px)/2);
			--wf-gutw-hlf-bp2: -webkit-calc(var(--c-gutw, 76px)/2);
			--wf-gutw-hlf-bp2: -moz-calc(var(--c-gutw, 76px)/2);
			--wf-gutw-hlf-bp2: calc(var(--c-gutw, 76px)/2);
			--wf-brsz: -webkit-calc(var(--c-brsz, 48px) + 24px);
			--wf-brsz: -moz-calc(var(--c-brsz, 48px) + 24px);
			--wf-brsz: calc(var(--c-brsz, 48px) + 24px);
			--wf-ps-t: -webkit-calc(var(--c-ps-t, 24px) + var(--wf-brsz, 72px));
			--wf-ps-t: -moz-calc(var(--c-ps-t, 24px) + var(--wf-brsz, 72px));
			--wf-ps-t: calc(var(--c-ps-t, 24px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp2: -webkit-calc(var(--c-ps-t, 24px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp2: -moz-calc(var(--c-ps-t, 24px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp2: calc(var(--c-ps-t, 24px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp5: -webkit-calc(var(--c-ps-t, 36px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp5: -moz-calc(var(--c-ps-t, 36px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp5: calc(var(--c-ps-t, 36px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp3-l: -webkit-calc(var(--c-ps-t, 36px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp3-l: -moz-calc(var(--c-ps-t, 36px) + var(--wf-brsz, 72px));
			--wf-ps-t-bp3-l: calc(var(--c-ps-t, 36px) + var(--wf-brsz, 72px))
		}

		.TcuCfd {
			background: #fff;
			-webkit-border-radius: 0;
			-moz-border-radius: 0;
			border-radius: 0;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: column;
			-webkit-flex-direction: column;
			flex-direction: column;
			padding-bottom: 24px;
			position: relative;
			padding-top: 96px;
			padding-top: var(--wf-ps-t, 96px);
			margin: 0 auto;
			padding-left: 24px;
			padding-left: var(--c-ps-s, 24px);
			padding-right: 24px;
			padding-right: var(--c-ps-e, 24px);
			width: 100%
		}

		.wmGw4 {
			margin: 0 auto;
			padding-left: 24px;
			padding-left: var(--c-ps-s, 24px);
			padding-right: 24px;
			padding-right: var(--c-ps-e, 24px);
			width: 100%
		}

		@media all and (min-width:600px) {
			.TcuCfd {
				-webkit-border-radius: 28px;
				-moz-border-radius: 28px;
				border-radius: 28px;
				min-height: 528px;
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px);
				width: 480px
			}

			.wmGw4 {
				padding: 0 16px;
				width: 480px
			}
		}

		@media all and (min-width:600px) and (orientation:landscape) {

			.TcuCfd,
			.wmGw4 {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px);
				width: 100%
			}

			.TcuCfd {
				-webkit-border-radius: 28px;
				-moz-border-radius: 28px;
				border-radius: 28px;
				min-height: unset
			}
		}

		@media all and (min-width:840px) {
			.TcuCfd {
				padding-bottom: 24px;
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px);
				padding-top: 96px;
				padding-top: var(--wf-ps-t-bp2, 96px);
				width: 480px
			}

			.wmGw4 {
				width: 480px
			}
		}

		@media all and (min-width:840px) and (orientation:landscape) {

			.TcuCfd,
			.wmGw4 {
				padding-left: 32px;
				padding-left: var(--c-ps-s, 32px);
				padding-right: 32px;
				padding-right: var(--c-ps-e, 32px);
				width: 100%
			}
		}

		@media all and (min-width:960px) {
			.TcuCfd {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px);
				width: 480px
			}

			.wmGw4 {
				width: 480px
			}
		}

		@media all and (min-width:960px) and (orientation:landscape) {
			.TcuCfd {
				-webkit-border-radius: 28px;
				-moz-border-radius: 28px;
				border-radius: 28px;
				min-height: 384px;
				padding-left: 36px;
				padding-left: var(--c-ps-s, 36px);
				padding-right: 36px;
				padding-right: var(--c-ps-e, 36px);
				padding-top: 108px;
				padding-top: var(--wf-ps-t-bp3-l, 108px);
				width: 840px
			}

			.wmGw4 {
				padding: 0 16px;
				width: 840px
			}
		}

		@media all and (min-width:1240px) {
			.TcuCfd {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px);
				width: 480px
			}

			.wmGw4 {
				width: 480px
			}
		}

		@media all and (min-width:1240px) and (orientation:landscape) {
			.TcuCfd {
				margin-left: 200px;
				margin-right: 200px;
				padding-left: 36px;
				padding-left: var(--c-ps-s, 36px);
				padding-right: 36px;
				padding-right: var(--c-ps-e, 36px);
				width: auto
			}

			.wmGw4 {
				width: auto;
				margin-left: 200px;
				margin-right: 200px
			}
		}

		@media all and (min-width:1600px) {
			.TcuCfd {
				min-height: 384px;
				padding-bottom: 36px;
				padding-left: 36px;
				padding-left: var(--c-ps-s, 36px);
				padding-right: 36px;
				padding-right: var(--c-ps-e, 36px);
				padding-top: 108px;
				padding-top: var(--wf-ps-t-bp5, 108px);
				width: 1040px
			}

			.wmGw4 {
				width: 1040px
			}
		}

		@media all and (min-width:1600px) and (orientation:landscape) {
			.TcuCfd {
				margin-left: auto;
				margin-right: auto;
				padding-left: 36px;
				padding-left: var(--c-ps-s, 36px);
				padding-right: 36px;
				padding-right: var(--c-ps-e, 36px);
				width: 1040px
			}

			.wmGw4 {
				margin-left: auto;
				margin-right: auto;
				width: 1040px
			}
		}

		.Ih3FE {
			left: 24px;
			left: var(--c-ps-s, 24px);
			position: absolute;
			right: 24px;
			right: var(--c-ps-e, 24px);
			top: 0;
			z-index: 5
		}

		@media all and (min-width:600px) {
			.Ih3FE {
				left: 24px;
				left: var(--c-ps-s, 24px);
				right: 24px;
				right: var(--c-ps-e, 24px)
			}
		}

		@media all and (min-width:600px) and (orientation:landscape) {
			.Ih3FE {
				left: 24px;
				left: var(--c-ps-s, 24px);
				right: 24px;
				right: var(--c-ps-e, 24px)
			}
		}

		@media all and (min-width:840px) {
			.Ih3FE {
				left: 24px;
				left: var(--c-ps-s, 24px);
				right: 24px;
				right: var(--c-ps-e, 24px)
			}
		}

		@media all and (min-width:840px) and (orientation:landscape) {
			.Ih3FE {
				left: 32px;
				left: var(--c-ps-s, 32px);
				right: 32px;
				right: var(--c-ps-e, 32px)
			}
		}

		@media all and (min-width:960px) {
			.Ih3FE {
				left: 24px;
				left: var(--c-ps-s, 24px);
				right: 24px;
				right: var(--c-ps-e, 24px)
			}
		}

		@media all and (min-width:960px) and (orientation:landscape) {
			.Ih3FE {
				left: 36px;
				left: var(--c-ps-s, 36px);
				right: 36px;
				right: var(--c-ps-e, 36px)
			}
		}

		@media all and (min-width:1240px) {
			.Ih3FE {
				left: 24px;
				left: var(--c-ps-s, 24px);
				right: 24px;
				right: var(--c-ps-e, 24px)
			}
		}

		@media all and (min-width:1240px) and (orientation:landscape) {
			.Ih3FE {
				left: 36px;
				left: var(--c-ps-s, 36px);
				right: 36px;
				right: var(--c-ps-e, 36px)
			}
		}

		@media all and (min-width:1600px) {
			.Ih3FE {
				left: 36px;
				left: var(--c-ps-s, 36px);
				right: 36px;
				right: var(--c-ps-e, 36px)
			}
		}

		@media all and (min-width:1600px) and (orientation:landscape) {
			.Ih3FE {
				left: 36px;
				left: var(--c-ps-s, 36px);
				right: 36px;
				right: var(--c-ps-e, 36px)
			}
		}

		.A77ntc,
		.Svhjgc,
		.fAlnEc {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: column;
			-webkit-flex-direction: column;
			flex-direction: column;
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.zIgDIc {
			margin-top: -72px;
			margin-top: calc(var(--wf-brsz, 72px)*-1)
		}

		.wsArZ[data-ss-mode="1"] .zIgDIc {
			padding-right: 24px;
			padding-right: var(--wf-gutw-hlf, 24px)
		}

		@media all and (min-width:840px) {
			.wsArZ[data-ss-mode="1"] .zIgDIc {
				padding-right: 38px;
				padding-right: var(--wf-gutw-hlf-bp2, 38px)
			}
		}

		@media all and (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .zIgDIc {
				padding-right: 24px;
				padding-right: var(--wf-gutw-hlf, 24px)
			}
		}

		.TcuCfd.nnGvjf .Svhjgc {
			overflow: visible
		}

		.wsArZ[data-ss-mode="1"] .Svhjgc,
		.UXFQgc {
			-ms-flex-direction: row;
			-webkit-flex-direction: row;
			flex-direction: row;
			-moz-flex-wrap: wrap;
			-ms-flex-wrap: wrap;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap
		}

		.UXFQgc {
			-webkit-box-flex: unset;
			box-flex: unset;
			-ms-flex-positive: unset;
			-webkit-flex-grow: unset;
			flex-grow: unset
		}

		@media all and (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .Svhjgc {
				-ms-flex-direction: row;
				-webkit-flex-direction: row;
				flex-direction: row;
				-moz-flex-wrap: wrap;
				-ms-flex-wrap: wrap;
				-webkit-flex-wrap: wrap;
				flex-wrap: wrap
			}
		}

		.wsArZ[data-ss-mode="1"] .UXFQgc {
			padding-left: 24px;
			padding-left: var(--wf-gutw-hlf, 24px)
		}

		@media all and (min-width:840px) {
			.wsArZ[data-ss-mode="1"] .UXFQgc {
				padding-left: 38px;
				padding-left: var(--wf-gutw-hlf-bp2, 38px)
			}
		}

		.wsArZ[data-ss-mode="1"] .zIgDIc {
			-webkit-flex-basis: 50%;
			-ms-flex-preferred-size: 50%;
			flex-basis: 50%;
			max-width: 50%
		}

		.wsArZ[data-ss-mode="1"] .UXFQgc {
			-webkit-flex-basis: 50%;
			-ms-flex-preferred-size: 50%;
			flex-basis: 50%;
			max-width: 50%
		}

		.wsArZ[data-ss-mode="1"] .zIgDIc,
		.wsArZ[data-ss-mode="1"] .UXFQgc {
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		@media all and (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .zIgDIc {
				-webkit-flex-basis: 50%;
				-ms-flex-preferred-size: 50%;
				flex-basis: 50%;
				-webkit-box-flex: 1;
				box-flex: 1;
				-ms-flex-positive: 1;
				-webkit-flex-grow: 1;
				flex-grow: 1;
				max-width: 50%
			}

			.NQ5OL .UXFQgc {
				-webkit-flex-basis: 50%;
				-ms-flex-preferred-size: 50%;
				flex-basis: 50%;
				-webkit-box-flex: 1;
				box-flex: 1;
				-ms-flex-positive: 1;
				-webkit-flex-grow: 1;
				flex-grow: 1;
				max-width: 50%
			}
		}

		@media all and (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .UXFQgc {
				padding-left: 24px;
				padding-left: var(--wf-gutw-hlf, 24px)
			}
		}

		.TcuCfd.nnGvjf .UXFQgc {
			-webkit-transform: none;
			-ms-transform: none;
			-o-transform: none;
			transform: none
		}

		.xKcayf {
			-ms-flex-negative: 0;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			width: 100%
		}

		.Hai8t .Em2Ord:not(.eLNT1d) {
			margin-bottom: 16px
		}

		.AcKKx.RDPZE {
			opacity: .5;
			pointer-events: none
		}

		.qWK5J {
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.UXFQgc.hAfgic {
			overflow-x: hidden
		}

		.UXFQgc.hAfgic .qWK5J {
			-webkit-transition: -webkit-transform .3s cubic-bezier(.4, 0, .2, 1);
			-moz-transition: -moz-transform .3s cubic-bezier(.4, 0, .2, 1);
			-o-transition: -o-transform .3s cubic-bezier(.4, 0, .2, 1);
			-webkit-transition: transform .3s cubic-bezier(.4, 0, .2, 1);
			-o-transition: transform .3s cubic-bezier(.4, 0, .2, 1);
			transition: transform .3s cubic-bezier(.4, 0, .2, 1)
		}

		.UXFQgc.QsjdCb .qWK5J {
			-webkit-transform: translate3d(0, 0, 0);
			-ms-transform: translate3d(0, 0, 0);
			-o-transform: translate3d(0, 0, 0);
			transform: translate3d(0, 0, 0)
		}

		.UXFQgc.GEcl0c .qWK5J {
			-webkit-transform: translate3d(-100%, 0, 0);
			-ms-transform: translate3d(-100%, 0, 0);
			-o-transform: translate3d(-100%, 0, 0);
			transform: translate3d(-100%, 0, 0)
		}

		[dir=rtl] .UXFQgc.GEcl0c .qWK5J {
			-webkit-transform: translate3d(100%, 0, 0);
			-ms-transform: translate3d(100%, 0, 0);
			-o-transform: translate3d(100%, 0, 0);
			transform: translate3d(100%, 0, 0)
		}

		.FZfKCe {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			-webkit-box-pack: justify;
			-webkit-justify-content: space-between;
			justify-content: space-between
		}

		.HwzH1e {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			list-style: none;
			margin: 0 -12px;
			padding: 0
		}

		.qKvP1b {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			margin: 16px 4px
		}

		.qKvP1b:first-child {
			margin-left: 0
		}

		.qKvP1b:last-child {
			margin-right: 0
		}

		.AVAq4d {
			-webkit-align-content: center;
			align-content: center;
			border-radius: 8px;
			color: #1f1f1f;
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem;
			line-height: 1.33333333;
			padding: 8px 12px;
			text-decoration: none;
			outline-color: #0b57d0;
			outline-color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.AVAq4d:focus,
		.AVAq4d:hover {
			background: rgba(68, 71, 70, 0.078)
		}

		.eXa0v {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			margin-right: 12px
		}

		.dEoyBf {
			margin-left: -16px
		}

		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Brv4Fb,
		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Ra9xwd,
		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-MpmGFe {
			border-color: transparent
		}

		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Brv4Fb,
		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-Ra9xwd,
		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-NSFCdd-MpmGFe {
			border-width: 0
		}

		.dEoyBf .VfPpkd-OkbHre .VfPpkd-rymPhb-fpDzbe-fmcmS {
			color: #1f1f1f
		}

		.dEoyBf .VfPpkd-OkbHre .VfPpkd-rymPhb-fpDzbe-fmcmS {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			line-height: 1.33333333;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem
		}

		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-t08AT-Bz112c {
			fill: #444746
		}

		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me):not(.VfPpkd-O1htCb-OWXEXe-XpnDCe):hover .VfPpkd-t08AT-Bz112c {
			fill: #444746
		}

		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me).VfPpkd-O1htCb-OWXEXe-XpnDCe .VfPpkd-t08AT-Bz112c {
			fill: #444746
		}

		.dEoyBf:not(.VfPpkd-O1htCb-OWXEXe-OWB6Me) .VfPpkd-uusGie-fmcmS {
			color: #1f1f1f
		}

		.dEoyBf .VfPpkd-uusGie-fmcmS {
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			line-height: 1.33333333;
			font-size: 0.75rem;
			font-weight: 400;
			letter-spacing: 0.00625rem
		}

		.dEoyBf .VfPpkd-TkwUic {
			height: 32px
		}

		.dEoyBf .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-25.25px) scale(1);
			-ms-transform: translateY(-25.25px) scale(1);
			-o-transform: translateY(-25.25px) scale(1);
			transform: translateY(-25.25px) scale(1)
		}

		.dEoyBf .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: .75rem
		}

		.dEoyBf .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.dEoyBf .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-22.75px) scale(.75);
			-ms-transform: translateY(-22.75px) scale(.75);
			-o-transform: translateY(-22.75px) scale(.75);
			transform: translateY(-22.75px) scale(.75)
		}

		.dEoyBf .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.dEoyBf .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: 1rem
		}

		.dEoyBf .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above-select-outlined-32px .25s 1;
			animation: mdc-floating-label-shake-float-above-select-outlined-32px .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above-select-outlined-32px {
			0% {
				-webkit-transform: translateX(0) translateY(-22.75px) scale(.75);
				transform: translateX(0) translateY(-22.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(4%) translateY(-22.75px) scale(.75);
				transform: translateX(4%) translateY(-22.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(-4%) translateY(-22.75px) scale(.75);
				transform: translateX(-4%) translateY(-22.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(0) translateY(-22.75px) scale(.75);
				transform: translateX(0) translateY(-22.75px) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above-select-outlined-32px {
			0% {
				-webkit-transform: translateX(0) translateY(-22.75px) scale(.75);
				-o-transform: translateX(0) translateY(-22.75px) scale(.75);
				transform: translateX(0) translateY(-22.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(4%) translateY(-22.75px) scale(.75);
				-o-transform: translateX(4%) translateY(-22.75px) scale(.75);
				transform: translateX(4%) translateY(-22.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(-4%) translateY(-22.75px) scale(.75);
				-o-transform: translateX(-4%) translateY(-22.75px) scale(.75);
				transform: translateX(-4%) translateY(-22.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(0) translateY(-22.75px) scale(.75);
				-o-transform: translateX(0) translateY(-22.75px) scale(.75);
				transform: translateX(0) translateY(-22.75px) scale(.75)
			}
		}

		.dEoyBf .VfPpkd-t08AT-Bz112c {
			width: 20px;
			height: 20px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic :not(.VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd) .VfPpkd-NSFCdd-Ra9xwd {
			max-width: calc(100% - 56px)
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic {
			height: 32px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-t08AT-Bz112c {
			width: 20px;
			height: 20px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc {
			left: 32px;
			right: auto
		}

		[dir=rtl] .dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc,
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc[dir=rtl] {
			left: auto;
			right: 32px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-25.25px) translateX(-28px) scale(1);
			-ms-transform: translateY(-25.25px) translateX(-28px) scale(1);
			-o-transform: translateY(-25.25px) translateX(-28px) scale(1);
			transform: translateY(-25.25px) translateX(-28px) scale(1)
		}

		[dir=rtl] .dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe[dir=rtl] {
			-webkit-transform: translateY(-25.25px) translateX(28px) scale(1);
			-ms-transform: translateY(-25.25px) translateX(28px) scale(1);
			-o-transform: translateY(-25.25px) translateX(28px) scale(1);
			transform: translateY(-25.25px) translateX(28px) scale(1)
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: .75rem
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			-webkit-transform: translateY(-22.75px) translateX(-28px) scale(.75);
			-ms-transform: translateY(-22.75px) translateX(-28px) scale(.75);
			-o-transform: translateY(-22.75px) translateX(-28px) scale(.75);
			transform: translateY(-22.75px) translateX(-28px) scale(.75)
		}

		[dir=rtl] .dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		[dir=rtl] .dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe[dir=rtl],
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe[dir=rtl] {
			-webkit-transform: translateY(-22.75px) translateX(28px) scale(.75);
			-ms-transform: translateY(-22.75px) translateX(28px) scale(.75);
			-o-transform: translateY(-22.75px) translateX(28px) scale(.75);
			transform: translateY(-22.75px) translateX(28px) scale(.75)
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic.VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe,
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NSFCdd-i5vt6e-OWXEXe-mWPk3d .VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe {
			font-size: 1rem
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above- .25s 1;
			animation: mdc-floating-label-shake-float-above- .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above- {
			0% {
				-webkit-transform: translateX(-28px) translateY(-22.75px) scale(.75);
				transform: translateX(-28px) translateY(-22.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% - 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(4% - 28px)) translateY(-22.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% - 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(-4% - 28px)) translateY(-22.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(-28px) translateY(-22.75px) scale(.75);
				transform: translateX(-28px) translateY(-22.75px) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above- {
			0% {
				-webkit-transform: translateX(-28px) translateY(-22.75px) scale(.75);
				-o-transform: translateX(-28px) translateY(-22.75px) scale(.75);
				transform: translateX(-28px) translateY(-22.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% - 28px)) translateY(-22.75px) scale(.75);
				-o-transform: translateX(calc(4% - 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(4% - 28px)) translateY(-22.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% - 28px)) translateY(-22.75px) scale(.75);
				-o-transform: translateX(calc(-4% - 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(-4% - 28px)) translateY(-22.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(-28px) translateY(-22.75px) scale(.75);
				-o-transform: translateX(-28px) translateY(-22.75px) scale(.75);
				transform: translateX(-28px) translateY(-22.75px) scale(.75)
			}
		}

		[dir=rtl] .dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU,
		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-TkwUic[dir=rtl] .VfPpkd-NLUYnc-V67aGc-OWXEXe-bF1zU {
			-webkit-animation: mdc-floating-label-shake-float-above- .25s 1;
			animation: mdc-floating-label-shake-float-above- .25s 1
		}

		@-webkit-keyframes mdc-floating-label-shake-float-above--rtl {
			0% {
				-webkit-transform: translateX(28px) translateY(-22.75px) scale(.75);
				transform: translateX(28px) translateY(-22.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% + 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(4% + 28px)) translateY(-22.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% + 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(-4% + 28px)) translateY(-22.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(28px) translateY(-22.75px) scale(.75);
				transform: translateX(28px) translateY(-22.75px) scale(.75)
			}
		}

		@keyframes mdc-floating-label-shake-float-above--rtl {
			0% {
				-webkit-transform: translateX(28px) translateY(-22.75px) scale(.75);
				-o-transform: translateX(28px) translateY(-22.75px) scale(.75);
				transform: translateX(28px) translateY(-22.75px) scale(.75)
			}

			33% {
				-webkit-animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				animation-timing-function: cubic-bezier(.5, 0, .701732, .495819);
				-webkit-transform: translateX(calc(4% + 28px)) translateY(-22.75px) scale(.75);
				-o-transform: translateX(calc(4% + 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(4% + 28px)) translateY(-22.75px) scale(.75)
			}

			66% {
				-webkit-animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				animation-timing-function: cubic-bezier(.302435, .381352, .55, .956352);
				-webkit-transform: translateX(calc(-4% + 28px)) translateY(-22.75px) scale(.75);
				-o-transform: translateX(calc(-4% + 28px)) translateY(-22.75px) scale(.75);
				transform: translateX(calc(-4% + 28px)) translateY(-22.75px) scale(.75)
			}

			100% {
				-webkit-transform: translateX(28px) translateY(-22.75px) scale(.75);
				-o-transform: translateX(28px) translateY(-22.75px) scale(.75);
				transform: translateX(28px) translateY(-22.75px) scale(.75)
			}
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-StrnGf-rymPhb-f7MjDc {
			width: 20px;
			height: 20px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-rymPhb-KkROqb {
			width: 32px;
			height: 20px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c .VfPpkd-cTi5dd {
			width: 20px;
			height: 20px;
			font-size: 20px
		}

		.dEoyBf.VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c.VfPpkd-O1htCb-OWXEXe-INsAgc .VfPpkd-TkwUic :not(.VfPpkd-NSFCdd-i5vt6e-OWXEXe-NSFCdd) .VfPpkd-NSFCdd-Ra9xwd {
			max-width: calc(100% - 88px)
		}

		.dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb {
			border-top-left-radius: 8px;
			border-top-right-radius: 0;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 8px
		}

		[dir=rtl] .dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb,
		.dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb[dir=rtl] {
			border-top-left-radius: 0;
			border-top-right-radius: 8px;
			border-bottom-right-radius: 8px;
			border-bottom-left-radius: 0
		}

		@supports (top:max(0%)) {
			.dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Brv4Fb {
				width: max(12px, 8px)
			}
		}

		@supports (top:max(0%)) {
			.dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-Ra9xwd {
				max-width: calc(100% - max(12px, 8px)*2)
			}
		}

		.dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe {
			border-top-left-radius: 0;
			border-top-right-radius: 8px;
			border-bottom-right-radius: 8px;
			border-bottom-left-radius: 0
		}

		[dir=rtl] .dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe,
		.dEoyBf .VfPpkd-NSFCdd-i5vt6e .VfPpkd-NSFCdd-MpmGFe[dir=rtl] {
			border-top-left-radius: 8px;
			border-top-right-radius: 0;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 8px
		}

		@supports (top:max(0%)) {
			.dEoyBf .VfPpkd-TkwUic {
				padding-left: max(16px, 12px)
			}
		}

		[dir=rtl] .dEoyBf .VfPpkd-TkwUic,
		.dEoyBf .VfPpkd-TkwUic[dir=rtl] {
			padding-left: 0
		}

		@supports (top:max(0%)) {

			[dir=rtl] .dEoyBf .VfPpkd-TkwUic,
			.dEoyBf .VfPpkd-TkwUic[dir=rtl] {
				padding-right: max(16px, 12px)
			}
		}

		@supports (top:max(0%)) {
			.dEoyBf+.VfPpkd-O1htCb-W0vJo-fmcmS {
				margin-left: max(16px, 12px)
			}
		}

		[dir=rtl] .dEoyBf+.VfPpkd-O1htCb-W0vJo-fmcmS,
		.dEoyBf+.VfPpkd-O1htCb-W0vJo-fmcmS[dir=rtl] {
			margin-left: 0
		}

		@supports (top:max(0%)) {

			[dir=rtl] .dEoyBf+.VfPpkd-O1htCb-W0vJo-fmcmS,
			.dEoyBf+.VfPpkd-O1htCb-W0vJo-fmcmS[dir=rtl] {
				margin-right: max(16px, 12px)
			}
		}

		.dEoyBf:hover {
			background: rgba(68, 71, 70, 0.078);
			border-radius: 8px
		}

		.JYXaTc {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-orient: vertical;
			-webkit-box-direction: normal;
			-webkit-flex-direction: column;
			flex-direction: column;
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			-webkit-box-pack: end;
			-webkit-justify-content: flex-end;
			justify-content: flex-end;
			margin-bottom: -6px;
			margin-left: -16px;
			margin-top: 32px
		}

		.JYXaTc.fXx9Lc {
			margin: 0;
			min-height: 0;
			padding: 0
		}

		.wsArZ[data-ss-mode="1"] .JYXaTc {
			width: 100%
		}

		@media (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .JYXaTc {
				width: 100%
			}
		}

		.wsArZ[data-ss-mode="1"] .TNTaPb {
			margin-left: 40px;
			margin-right: 0
		}

		.wsArZ[data-ss-mode="1"] .TNTaPb:empty {
			margin-left: 0
		}

		@media (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .TNTaPb {
				margin-left: 40px;
				margin-right: 0
			}

			.NQ5OL .TNTaPb:empty {
				margin-left: 0;
				margin-right: 0
			}
		}

		.wsArZ[data-ss-mode="1"] .FO2vFd {
			margin-left: 0;
			margin-right: -16px
		}

		@media (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {
			.NQ5OL .FO2vFd {
				margin-left: 0;
				margin-right: -16px
			}
		}

		@media (min-width:840px) {

			.wsArZ[data-ss-mode="1"] .TNTaPb,
			.wsArZ[data-ss-mode="1"] .FO2vFd {
				-webkit-box-flex: unset;
				-webkit-flex-grow: unset;
				flex-grow: unset
			}
		}

		@media (min-width:600px) and (orientation:landscape),
		all and (min-width:1600px) {

			.NQ5OL .TNTaPb,
			.NQ5OL .FO2vFd {
				-webkit-box-flex: unset;
				-webkit-flex-grow: unset;
				flex-grow: unset
			}
		}

		.S1zJGd {
			-webkit-align-self: flex-start;
			align-self: flex-start;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			margin-bottom: 24px
		}

		.O1Slxf {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-orient: vertical;
			-webkit-box-direction: normal;
			-webkit-flex-direction: row-reverse;
			flex-direction: row-reverse;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			width: 100%
		}

		.TNTaPb,
		.FO2vFd {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.FO2vFd {
			-webkit-box-pack: flex-start;
			-webkit-justify-content: flex-start;
			justify-content: flex-start
		}

		.TNTaPb {
			-webkit-box-pack: flex-end;
			-webkit-justify-content: flex-end;
			justify-content: flex-end
		}

		.JYXaTc.NNItQ:not(.F8PBrb) .TNTaPb,
		.JYXaTc.NNItQ:not(.F8PBrb) .FO2vFd {
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center
		}

		.JYXaTc.NNItQ .TNTaPb,
		.JYXaTc.F8PBrb .TNTaPb {
			padding-left: 16px
		}

		.JYXaTc.F8PBrb .TNTaPb {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-pack: justify;
			-webkit-justify-content: space-between;
			justify-content: space-between;
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			width: 100%
		}

		.JYXaTc.NNItQ .FO2vFd,
		.JYXaTc.F8PBrb .TNTaPb+.FO2vFd {
			margin-top: 16px
		}

		.JYXaTc:not(.NNItQ) .FO2vFd .mWv92d,
		.JYXaTc:not(.NNItQ) .FO2vFd .JLt0ke,
		.JYXaTc:not(.NNItQ) .FO2vFd .J7pUA {
			text-align: left
		}

		.BbN10e {
			display: block;
			width: calc(100% - 2px)
		}

		.JYXaTc.F8PBrb .O1Slxf {
			margin: 0 -2px;
			width: calc(100% + 4px)
		}

		.JYXaTc.F8PBrb .FO2vFd {
			margin: 0 2px
		}

		.o3Yfjb {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			margin: 0 2px;
			min-width: calc(50% - 4px)
		}

		.BbN10e {
			white-space: nowrap;
			width: 100%
		}

		.BbN10e .pIzcPc {
			display: block
		}

		.mWv92d+.n3Clv,
		.JLt0ke+.n3Clv {
			margin-top: 32px
		}

		.n3Clv .q6oraf {
			border-radius: 16px
		}

		.JYXaTc .J7pUA.u3bW4e {
			background-color: transparent
		}

		.J7pUA .snByac {
			color: #0b57d0;
			color: var(--gm3-sys-color-primary, #0b57d0);
			line-height: 1.42857143;
			margin: 16px;
			text-transform: none
		}

		.J7pUA [jsslot] {
			margin: 0
		}

		.BbN10e .pIzcPc {
			width: 100%
		}

		.Ih3FE {
			height: 4px;
			overflow: hidden
		}

		.kPY6ve {
			background: #fff;
			bottom: 0;
			left: 0;
			opacity: .5;
			outline: none;
			position: fixed;
			top: 0;
			width: 100%;
			z-index: 4
		}

		.Ih3FE .l3q5xe {
			background-color: #0b57d0;
			background-color: var(--gm3-sys-color-primary, #0b57d0)
		}

		.Ih3FE .w2zcLc {
			background-color: #e0e0e0
		}

		.RDsYTb {
			color: #444746;
			font-family: "Google Sans", roboto, "Noto Sans Myanmar UI", arial, sans-serif;
			font-size: 0.875rem;
			font-weight: 400;
			letter-spacing: 0rem;
			line-height: 1.42857143;
			margin-top: 32px
		}

		.Ha17qf {
			background: #fff;
			display: -webkit-box;
			display: -moz-box;
			display: -webkit-flex;
			display: -ms-flexbox;
			display: flex;
			-ms-flex-direction: column;
			-webkit-flex-direction: column;
			flex-direction: column;
			max-width: 100%;
			min-height: 100vh;
			position: relative
		}

		@media all and (min-width:601px) {
			.Ha17qf {
				background: #fff;
				border: 1px solid #dadce0;
				-webkit-border-radius: 8px;
				-moz-border-radius: 8px;
				border-radius: 8px;
				display: block;
				-ms-flex-negative: 0;
				-webkit-flex-shrink: 0;
				flex-shrink: 0;
				margin: 0 auto;
				min-height: 0;
				width: 450px
			}

			.Ha17qf.qmmlRd {
				width: 450px
			}

			.Ha17qf.qmmlRd .Or16q {
				height: auto;
				min-height: 500px
			}
		}

		.Or16q {
			-webkit-box-flex: 1;
			box-flex: 1;
			-ms-flex-positive: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			overflow: hidden;
			padding: 24px 24px 36px
		}

		@media all and (min-width:601px) {
			.Or16q {
				height: auto;
				min-height: 500px;
				overflow-y: auto
			}
		}

		@media all and (min-width:450px) {
			.Or16q {
				padding: 48px 40px 36px
			}
		}

		.iEhbme {
			padding: 24px 0 0
		}

		.iEhbme.RDPZE {
			opacity: .5;
			pointer-events: none
		}

		.HDuqac {
			background: transparent;
			border: none;
			color: rgb(60, 64, 67);
			cursor: pointer;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			font-size: 14px;
			letter-spacing: .25px;
			max-width: 100%
		}

		.BOs5fd {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			background: #fff;
			border: 1px solid rgb(218, 220, 224);
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			max-width: 100%;
			position: relative
		}

		.HDuqac:focus-visible {
			outline: none
		}

		.HDuqac:focus-visible .BOs5fd {
			outline: none;
			position: relative;
			background: rgba(60, 64, 67, .12)
		}

		.HDuqac:focus-visible .BOs5fd::after {
			border: 2px solid rgb(24, 90, 188);
			border-radius: 20px;
			bottom: -5px;
			-webkit-box-shadow: 0 0 0 2px rgb(232, 240, 254);
			box-shadow: 0 0 0 2px rgb(232, 240, 254);
			content: "";
			left: -5px;
			position: absolute;
			right: -5px;
			top: -5px
		}

		.HDuqac:focus:not(:focus-visible) .BOs5fd {
			-webkit-box-shadow: 0 1px 1px 0 rgba(66, 133, 244, .3), 0 1px 3px 1px rgba(66, 133, 244, .15);
			box-shadow: 0 1px 1px 0 rgba(66, 133, 244, .3), 0 1px 3px 1px rgba(66, 133, 244, .15);
			border-color: rgb(218, 220, 224);
			-webkit-box-shadow: none;
			box-shadow: none
		}

		.HDuqac:hover:not(:focus-visible) .BOs5fd {
			background: rgba(60, 64, 67, .04)
		}

		.HDuqac:focus .BOs5fd,
		.HDuqac:hover .BOs5fd {
			border-color: rgb(218, 220, 224)
		}

		.HDuqac:active:focus .BOs5fd {
			background: rgba(60, 64, 67, .12);
			border-color: rgb(60, 64, 67);
			color: rgb(60, 64, 67)
		}

		.EI77qf {
			line-height: 30px;
			margin: -8px 0;
			padding: 8px 0
		}

		.EI77qf.DbQnIe {
			color: rgb(26, 115, 232);
			font-size: 12px;
			line-height: 22px
		}

		.EI77qf .BOs5fd {
			border-radius: 16px;
			padding: 0 15px 0 15px
		}

		.EI77qf.DbQnIe .BOs5fd {
			border-radius: 12px;
			padding: 0 10px 0 10px
		}

		.EI77qf.iiFyne .BOs5fd {
			padding-right: 7px
		}

		.EI77qf.cd29Sd .BOs5fd {
			padding-left: 5px
		}

		.EI77qf.DbQnIe.cd29Sd .BOs5fd {
			padding-left: 2px
		}

		.EI77qf.DbQnIe.iiFyne .BOs5fd {
			padding-right: 7px
		}

		.hMeYtd {
			border-radius: 10px;
			height: 20px;
			margin-right: 8px
		}

		.hMeYtd .rs3gSb,
		.hMeYtd .hZUije,
		.hMeYtd .kHluYc {
			border-radius: 50%;
			color: rgb(60, 64, 67);
			display: block;
			height: 20px;
			width: 20px
		}

		.wJxLsd {
			direction: ltr;
			overflow: hidden;
			text-align: left;
			text-overflow: ellipsis;
			white-space: nowrap
		}

		.znpTjf {
			color: rgb(60, 64, 67);
			-webkit-flex-shrink: 0;
			flex-shrink: 0;
			height: 18px;
			margin-left: 4px;
			width: 18px
		}

		.HDuqac.DbQnIe .znpTjf {
			height: 16px;
			width: 16px
		}

		.JC0zZc {
			display: block;
			height: 100%;
			width: 100%
		}

		.aMfydd {
			text-align: center
		}

		.aMfydd .Tn0LBd {
			padding-bottom: 0;
			padding-top: 16px;
			color: rgb(32, 33, 36);
			font-size: 24px;
			font-weight: 400;
			line-height: 1.3333;
			margin-bottom: 0;
			margin-top: 0
		}

		.a2CQh {
			padding-bottom: 3px;
			padding-top: 1px;
			margin-bottom: 0;
			margin-top: 0
		}

		.a2CQh {
			font-size: 16px;
			font-weight: 400;
			letter-spacing: .1px;
			line-height: 1.5;
			padding-bottom: 0;
			padding-top: 8px
		}

		.a2CQh:empty {
			display: none
		}

		.n868rf {
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			letter-spacing: .25px;
			min-height: 24px;
			padding-bottom: 0;
			padding-top: 8px
		}

		.C7uRJc {
			margin-top: 8px
		}

		.NveWz {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.i2knIc {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-flex: 0;
			-webkit-flex-grow: 0;
			flex-grow: 0;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			margin-left: -8px;
			margin-top: 32px;
			margin-bottom: -16px;
			min-height: 48px;
			padding-bottom: 20px
		}

		.i2knIc.fXx9Lc,
		.i2knIc.fXx9Lc .RhTxBf,
		.i2knIc.fXx9Lc .tmMcIf {
			margin: 0;
			min-height: 0;
			padding: 0
		}

		.sXlxWd {
			margin-bottom: 32px;
			width: 100%
		}

		.wg0fFb {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-orient: horizontal;
			-webkit-box-direction: reverse;
			-webkit-flex-direction: row-reverse;
			flex-direction: row-reverse;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			width: 100%
		}

		.RhTxBf,
		.tmMcIf {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			margin-bottom: 16px
		}

		.i2knIc.NNItQ:not(.F8PBrb) .RhTxBf,
		.i2knIc.NNItQ:not(.F8PBrb) .tmMcIf {
			text-align: center
		}

		.RhTxBf {
			text-align: right
		}

		.i2knIc.F8PBrb .wg0fFb {
			margin: 0 -2px;
			margin-left: 8px;
			width: calc(100% + 4px)
		}

		.i2knIc.F8PBrb .RhTxBf {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			width: 100%
		}

		.i2knIc.F8PBrb .tmMcIf {
			margin: 0 2px
		}

		.xOs3Jc {
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1;
			margin: 0 2px;
			min-width: calc(50% - 4px)
		}

		.Cokknd {
			margin-bottom: 6px;
			margin-top: 6px;
			white-space: nowrap;
			width: 100%
		}

		.D4rY0b {
			color: rgb(95, 99, 104);
			font-size: 14px;
			line-height: 1.4286;
			margin-top: 32px
		}

		.TRuRhd {
			margin-top: 24px;
			position: relative
		}

		.Fu5aXd:first-child .TRuRhd {
			margin-top: 8px
		}

		.xyezD {
			background-color: transparent;
			border: none;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			color: rgb(32, 33, 36);
			font-size: 16px;
			height: 56px;
			outline: none;
			padding: 0 14px;
			width: 100%
		}

		.TRuRhd.YKooDc .xyezD {
			direction: ltr;
			text-align: left
		}

		.Yr2OOb {
			line-height: 1.4286;
			margin: 14px;
			padding: 0;
			resize: vertical
		}

		.LBj8vb {
			background-color: transparent;
			border: none;
			font-size: 16px;
			height: 56px;
			padding: 0 14px;
			outline: none;
			width: 100%
		}

		.dXXNOd {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
			width: 100%
		}

		.xMpNCd:not(:empty) {
			line-height: 56px;
			padding-left: 14px
		}

		.pkBWge:not(:empty) {
			line-height: 56px;
			padding-right: 14px
		}

		.TRuRhd[data-has-domain-suffix] .pkBWge {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			white-space: nowrap
		}

		.TRuRhd[data-has-domain-suffix][data-has-at-sign] .pkBWge {
			display: none
		}

		.fjpXlc {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			height: 100%
		}

		.nWPx2e {
			-webkit-box-align: stretch;
			-webkit-align-items: stretch;
			align-items: stretch;
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-orient: horizontal;
			-webkit-box-direction: normal;
			-webkit-flex-direction: row;
			flex-direction: row;
			height: 100%;
			-webkit-box-pack: start;
			-webkit-justify-content: flex-start;
			justify-content: flex-start;
			left: 0;
			max-width: 100%;
			pointer-events: none;
			position: absolute;
			top: 0;
			width: 100%
		}

		.YhhY8,
		.CCQ94b,
		.tNASEf {
			border: 1px solid rgb(218, 220, 224)
		}

		.YhhY8 {
			border-bottom-left-radius: 4px;
			border-right: none;
			border-top-left-radius: 4px;
			width: 8px
		}

		.CCQ94b {
			border-left: none;
			border-right: none;
			border-top: none;
			color: rgb(95, 99, 104);
			font-size: 12px;
			margin: -6px 0 0;
			overflow: hidden;
			padding: 0 6px;
			text-overflow: ellipsis;
			white-space: nowrap
		}

		.tNASEf {
			border-bottom-right-radius: 4px;
			border-left: none;
			border-top-right-radius: 4px;
			-webkit-box-flex: 1;
			-webkit-flex-grow: 1;
			flex-grow: 1
		}

		.Fu5aXd:not(.Jj6Lae) .xyezD:focus+.nWPx2e .CCQ94b,
		.Fu5aXd:not(.Jj6Lae) .LBj8vb:focus+.nWPx2e .CCQ94b {
			color: rgb(26, 115, 232)
		}

		.xyezD:focus+.nWPx2e .YhhY8,
		.xyezD:focus+.nWPx2e .CCQ94b,
		.xyezD:focus+.nWPx2e .tNASEf,
		.LBj8vb:focus+.nWPx2e .YhhY8,
		.LBj8vb:focus+.nWPx2e .CCQ94b,
		.LBj8vb:focus+.nWPx2e .tNASEf {
			border-color: rgb(26, 115, 232);
			border-width: 2px
		}

		.TMZ8p {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-sizing: content-box;
			box-sizing: content-box;
			cursor: pointer;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			-webkit-box-flex: 0;
			-webkit-flex: 0 0 48px;
			flex: 0 0 48px;
			height: 48px;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			line-height: 0;
			position: relative;
			vertical-align: bottom;
			white-space: nowrap;
			width: 48px
		}

		.TMZ8p .zSAiZc {
			height: 48px;
			left: 0;
			margin: 0;
			opacity: 0;
			outline: 0;
			padding: 0;
			position: absolute;
			top: 0;
			width: 48px
		}

		.RiAcXe {
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			border: 2px solid currentColor;
			border-radius: 2px;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			display: -webkit-inline-box;
			display: -webkit-inline-flex;
			display: inline-flex;
			height: 18px;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
			left: 15px;
			pointer-events: none;
			position: absolute;
			top: 15px;
			width: 18px
		}

		.TIX6ke {
			bottom: 0;
			left: 0;
			opacity: 0;
			position: absolute;
			right: 0;
			top: 0;
			width: 100%
		}

		.TMZ8p .zSAiZc~.RiAcXe .TIX6ke {
			color: white;
			opacity: 1
		}

		.M08VSe {
			stroke: currentColor;
			stroke-dashoffset: 29.7833385;
			stroke-width: 3.12px
		}

		.TMZ8p .zSAiZc:enabled:not(:checked)~.RiAcXe {
			background-color: transparent;
			border-color: rgb(95, 99, 104)
		}

		.TMZ8p .zSAiZc:enabled:checked~.RiAcXe {
			background-color: rgb(26, 115, 232);
			border-color: rgb(26, 115, 232)
		}

		.TMZ8p .zSAiZc[disabled]:not(:checked)~.RiAcXe {
			background-color: transparent;
			border-color: rgba(60, 64, 67, .38)
		}

		.TMZ8p .zSAiZc[disabled]:checked~.RiAcXe {
			background-color: rgba(60, 64, 67, .38);
			border-color: transparent
		}

		.TMZ8p:hover .zSAiZc:enabled:not(:checked)~.RiAcXe {
			background-color: transparent;
			border-color: rgb(32, 33, 36)
		}

		.TMZ8p:hover .zSAiZc:enabled:checked~.RiAcXe {
			background-color: rgb(23, 78, 166);
			border-color: rgb(23, 78, 166)
		}

		.TMZ8p .zSAiZc:focus-visible~.RiAcXe {
			outline: none;
			position: relative
		}

		.TMZ8p .zSAiZc:focus-visible~.RiAcXe::after {
			border: 2px solid rgb(24, 90, 188);
			border-radius: 4px;
			bottom: -5px;
			-webkit-box-shadow: 0 0 0 2px rgb(232, 240, 254);
			box-shadow: 0 0 0 2px rgb(232, 240, 254);
			content: "";
			left: -5px;
			position: absolute;
			right: -5px;
			top: -5px
		}

		.F3wxlc {
			-webkit-box-align: start;
			-webkit-align-items: flex-start;
			align-items: flex-start;
			color: rgb(95, 99, 104);
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			font-size: 12px;
			line-height: normal;
			margin-top: 4px
		}

		.EllNBf {
			margin-right: 8px;
			margin-top: -2px
		}

		.SnjiRb {
			height: 16px;
			width: 16px
		}

		.F3wxlc:empty,
		.NHVGlc:empty {
			display: none
		}

		.Fu5aXd.Jj6Lae .F3wxlc {
			color: rgb(217, 48, 37)
		}

		.Fu5aXd .azsAwf {
			margin-left: 16px
		}

		.Fu5aXd.Jj6Lae .nWPx2e .YhhY8,
		.Fu5aXd.Jj6Lae .nWPx2e .CCQ94b,
		.Fu5aXd.Jj6Lae .nWPx2e .tNASEf {
			border-color: rgb(217, 48, 37)
		}

		.Fu5aXd.Jj6Lae .nWPx2e .CCQ94b {
			color: rgb(217, 48, 37)
		}

		.TcuCfd.hyqGzc {
			padding-left: 24px;
			padding-left: var(--c-ps-s, 24px);
			padding-right: 24px;
			padding-right: var(--c-ps-e, 24px)
		}

		.TcuCfd.hyqGzc.wsArZ[data-ss-mode="1"] {
			padding-left: 24px;
			padding-left: var(--c-ps-s, 24px);
			padding-right: 24px;
			padding-right: var(--c-ps-e, 24px)
		}

		@media all and (orientation:landscape) {
			.TcuCfd.hyqGzc.NQ5OL {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px)
			}
		}

		@media all and (min-aspect-ratio:2/3) and (orientation:portrait) {
			.TcuCfd.AdRpFc {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px)
			}
		}

		@media all and (max-aspect-ratio:3/2) and (orientation:landscape) {
			.TcuCfd.AdRpFc.wsArZ[data-ss-mode="1"] {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px)
			}

			.TcuCfd.AdRpFc.NQ5OL {
				padding-left: 24px;
				padding-left: var(--c-ps-s, 24px);
				padding-right: 24px;
				padding-right: var(--c-ps-e, 24px)
			}
		}

		.ZWssT {
			margin-top: 26px
		}

		.vopC4e {
			background: transparent;
			border: none;
			-webkit-box-sizing: border-box;
			box-sizing: border-box;
			color: rgb(32, 33, 36);
			cursor: pointer;
			margin-bottom: -15px;
			margin-top: -15px;
			outline: inherit;
			padding-bottom: 15px;
			padding-top: 15px;
			position: relative;
			z-index: 1
		}

		.vopC4e:focus::after {
			background-color: rgba(26, 115, 232, .15);
			border-radius: 2px;
			bottom: 0;
			content: "";
			left: 0;
			position: absolute;
			right: 0;
			top: 0;
			z-index: -1
		}

		.JVMrYb {
			display: block
		}

		.hJIRO {
			display: none
		}

		.sQecwc {
			display: hidden
		}

		sentinel {}

		/*# sourceURL=/_/mss/boq-identity/_/ss/k=boq-identity.AccountsSignInUi.Yps5vY2VtKQ.L.X.O/am=DoCfiInHBqD8A1gAIABQoAAAAAAAAAAAADSQJQQ/d=1/ed=1/rs=AOaEmlGiep7r8B2bj5kvqy6m0c79-34A1Q/m=identifierview,_b,_tp */
	</style>
	<style nonce="2Q2GS9Pqql5ILT5cGsT2qw">
		@font-face {
			font-family: 'Product Sans';
			font-style: normal;
			font-weight: 400;
			src: url(//fonts.gstatic.com/s/productsans/v9/pxiDypQkot1TnFhsFMOfGShVF9eL.ttf)format('truetype');
		}
	</style>
	<meta name="description" content="">
	<meta name="robots" content="noindex, nofollow"><noscript>
		<meta http-equiv="refresh"
			content="0; url=/v3/signin/rejected?app_domain=http://localhost:8081&amp;client_id=25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com&amp;continue=https://accounts.google.com/signin/oauth/legacy/consent?authuser%3Dunknown%26part%3DAJi8hAP9su1ktWsSJoMWE169hk2DpRdEhfjxpT3PEnRlfLKPMiG_VYpzjhDzibxj2LBz-Z0c2mjuYP1Tbtx9npFzLZ2GhxOTfRuK2IiBKaN34PG25h3hRK8FNNXrTsFA_aF-Ox6KFz7j_SweQTLxWcLjyJsle-ahCMQqEYQZdmyosqJZU6WPuYIq8oCYZ9eGy0xdPDSzrKiFnH3bEwst51CWY-LPzyzFR6nZz7ysnkFuzMkPDP9yDbPBFr30u07J1gAi0Hbn7sAianw17GkyRExPis5bgBUQavXeZi1ftABwwD60xE5MKK3mF9_i3QhanG1FT56a5SIU-nWHv-hV6mmBk76SUi_z_RaswcXWNfsstAU-hVHnXyGlLgOBb7TZPOaO0t1SQyjgF_eEhy8K4J2KgYBsv7FyhQjtZZew0UsS0crnz2SuRtV73KqSD-TyVmXBKbhBVvF7RML6x9KhXSVYjv-RzcxUZQ%26as%3DS587311950%253A1696551822831222%26client_id%3D25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com%26theme%3Dglif%23&amp;dsh=S587311950:1696551822831222&amp;flowName=GeneralOAuthLite&amp;o2v=2&amp;opparams=%253F&amp;rart=ANgoxcexAd21k-Wnz_9BXHTuZIQui91FQoGyw2kNkcjm8DTG-0KMavr3lT-pJidk7-I1oq5W3Qy8Eh7KZXdPKMCy_uxagnB06w&amp;redirect_uri=http://localhost:8081/v1/api/auth/google/callback&amp;response_type=code&amp;rhlk=js&amp;rrk=47&amp;scope=profile+email&amp;service=lso&amp;theme=glif">
		<style nonce="2Q2GS9Pqql5ILT5cGsT2qw">
			body {
				opacity: 0;
			}
		</style>
	</noscript>
	<title>Sign in - Google Accounts</title>
</head>

<body>
	<div class="BDEI9 LZgQXe">
		<div class="Ha17qf" data-auto-init="Card">
			<div class="Or16q">
				<div data-view-id="hm18Ec" data-locale="en_US" data-allow-sign-up-types="true">
					<c-wiz jsrenderer="OTcFib" jsshadow jsdata="deferred-i2"
						data-p="%.@.&quot;25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com&quot;]"
						data-node-index="2;0" jsmodel="hc6Ubd" c-wiz>
						<div class="gEc4r">
							<div class="BivnM">
								<div class="ji6sFc">
									<img src="//ssl.gstatic.com/images/branding/googleg/2x/googleg_standard_color_14dp.png" class="TrZEUc" alt="Google" width="14" height="14"></div>
									<div class="O3jdWc">Sign in with Google</div>
								</div>
							</div>
							<c-data id="i2" jsdata=" eCjdDd;_;5"></c-data>
					</c-wiz>
					<div class="EQIoSc" jsname="bN97Pc">
						<div jsname="paFcre">
							<div class="aMfydd" jsname="tJHJj">
								<h1 class="Tn0LBd" jsname="r4nke">Sign in</h1>
								<p class="a2CQh" jsname="VdSJob">to continue to
									<button jscontroller="eS2ylb" type="button" jsname="LZaERc" jsaction="click:CnOdef(preventDefault=true)" data-destination-info="Signing in will redirect you to: http://localhost:8081" data-third-party-email="ljm9894@dgsw.hs.kr">DEE:P</button>
								</p>
							</div>
						</div>
						<form
							action="/v3/signin/identifier?app_domain=http://localhost:8081&amp;client_id=25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com&amp;continue=https://accounts.google.com/signin/oauth/legacy/consent?authuser%3Dunknown%26part%3DAJi8hAP9su1ktWsSJoMWE169hk2DpRdEhfjxpT3PEnRlfLKPMiG_VYpzjhDzibxj2LBz-Z0c2mjuYP1Tbtx9npFzLZ2GhxOTfRuK2IiBKaN34PG25h3hRK8FNNXrTsFA_aF-Ox6KFz7j_SweQTLxWcLjyJsle-ahCMQqEYQZdmyosqJZU6WPuYIq8oCYZ9eGy0xdPDSzrKiFnH3bEwst51CWY-LPzyzFR6nZz7ysnkFuzMkPDP9yDbPBFr30u07J1gAi0Hbn7sAianw17GkyRExPis5bgBUQavXeZi1ftABwwD60xE5MKK3mF9_i3QhanG1FT56a5SIU-nWHv-hV6mmBk76SUi_z_RaswcXWNfsstAU-hVHnXyGlLgOBb7TZPOaO0t1SQyjgF_eEhy8K4J2KgYBsv7FyhQjtZZew0UsS0crnz2SuRtV73KqSD-TyVmXBKbhBVvF7RML6x9KhXSVYjv-RzcxUZQ%26as%3DS587311950%253A1696551822831222%26client_id%3D25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com%26theme%3Dglif%23&amp;dsh=S587311950:1696551822831222&amp;flowName=GeneralOAuthLite&amp;o2v=2&amp;opparams=%253F&amp;rart=ANgoxcexAd21k-Wnz_9BXHTuZIQui91FQoGyw2kNkcjm8DTG-0KMavr3lT-pJidk7-I1oq5W3Qy8Eh7KZXdPKMCy_uxagnB06w&amp;redirect_uri=http://localhost:8081/v1/api/auth/google/callback&amp;response_type=code&amp;scope=profile+email&amp;service=lso&amp;theme=glif"
							method="POST" novalidate>
							<div class="iEhbme" jsname="rEuO1b">
								<section class="aN1Vld ">
									<div class="yOnVIb" jsname="MZArnb">
										<div class="Fu5aXd" jsname="dWPKW">
											<div class="Flfooc">
												<div class="TRuRhd  YKooDc">
													<div class="fjpXlc">
														<label class="dXXNOd"><input class="xyezD" jsname="Ufn6O" type="email" name="identifier" id="identifierId" autofocus autocapitalize="none" autocomplete="username" dir="ltr"/><div class="nWPx2e"><div class="YhhY8"></div><div class="CCQ94b">Email or phone</div><div class="tNASEf"></div></div></label>
													</div>
												</div>
											</div>
											<div class="F3wxlc" jsname="h9d3hd"></div>
											<div class="NHVGlc" jsname="JIbuQc"></div>
										</div>
										<p class="vOZun" jsname="OZNMeb" aria-live="assertive"></p>
										<p class="vOZun"><a
												href="/signin/v2/usernamerecovery?app_domain=http://localhost:8081&amp;client_id=25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com&amp;continue=https://accounts.google.com/signin/oauth/legacy/consent?authuser%3Dunknown%26part%3DAJi8hAP9su1ktWsSJoMWE169hk2DpRdEhfjxpT3PEnRlfLKPMiG_VYpzjhDzibxj2LBz-Z0c2mjuYP1Tbtx9npFzLZ2GhxOTfRuK2IiBKaN34PG25h3hRK8FNNXrTsFA_aF-Ox6KFz7j_SweQTLxWcLjyJsle-ahCMQqEYQZdmyosqJZU6WPuYIq8oCYZ9eGy0xdPDSzrKiFnH3bEwst51CWY-LPzyzFR6nZz7ysnkFuzMkPDP9yDbPBFr30u07J1gAi0Hbn7sAianw17GkyRExPis5bgBUQavXeZi1ftABwwD60xE5MKK3mF9_i3QhanG1FT56a5SIU-nWHv-hV6mmBk76SUi_z_RaswcXWNfsstAU-hVHnXyGlLgOBb7TZPOaO0t1SQyjgF_eEhy8K4J2KgYBsv7FyhQjtZZew0UsS0crnz2SuRtV73KqSD-TyVmXBKbhBVvF7RML6x9KhXSVYjv-RzcxUZQ%26as%3DS587311950%253A1696551822831222%26client_id%3D25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com%26theme%3Dglif%23&amp;dsh=S587311950:1696551822831222&amp;flowName=GeneralOAuthLite&amp;o2v=2&amp;opparams=%253F&amp;rart=ANgoxcexAd21k-Wnz_9BXHTuZIQui91FQoGyw2kNkcjm8DTG-0KMavr3lT-pJidk7-I1oq5W3Qy8Eh7KZXdPKMCy_uxagnB06w&amp;redirect_uri=http://localhost:8081/v1/api/auth/google/callback&amp;response_type=code&amp;scope=profile+email&amp;service=lso&amp;theme=glif"
												jsname="Cuz2Ue">Forgot email?</a></p>
										<input type="password" name="hiddenPassword" class="hJIRO" tabindex="-1" aria-hidden="true" spellcheck="false" jsname="RHeR4d"><input type="hidden" name="usi" value="S587311950:1696551822831222"><input type="hidden" name="domain" value=""><input type="hidden" name="region" value="KR"><span jsname="xdJtEf"><script nonce="OK4kAkmEv62hXDr_AoR8Yw">//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjogMywic291cmNlcyI6WyIiXSwic291cmNlc0NvbnRlbnQiOlsiICJdLCJuYW1lcyI6WyJjbG9zdXJlRHluYW1pY0J1dHRvbiJdLCJtYXBwaW5ncyI6IkFBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEifQ==
(function(){var k=function(Z,D,U,N,G,Q,q,h){if((((Z+1&(3==(Z+2&15)&&(h=(q=f(N,U,D))&&1===Q.eval(q.createScript(G))?function(J){return q.createScript(J)}:function(J){return""+J}),57))>=Z&&Z+8>>1<Z&&(h=z?l?l.brands.some(function(J,V){return(V=J.brand)&&-1!=V.indexOf(D)}):!1:!1),Z)|88)==Z){a:{if(U=Y.navigator)if(N=U.userAgent){G=N;break a}G=""}h=-1!=G.indexOf(D)}return 4==(Z>>1&((Z&38)==Z&&(h=D),7))&&(h=c(0,95)?k(23,"Chromium"):(k(94,"Chrome")||k(92,D))&&!(c(0,89)?0:k(92,"Edge"))||k(90,"Silk")),h},x=function(Z,D,U,N,G,Q,q,h,J,V){return(U+((U&121)==U&&(N(function(u){u(D)}),V=[function(){return D}]),7)&Z)<U&&(U-2|2)>=U&&(J=b,J[G]||c(35,5,Q,D,N,J,h),J[G](q)),V},c=function(Z,D,U,N,G,Q,q,h,J,V,u,g,R,n,M,y,L,d,a,H,C,P){return 1>((((((D|72)==D&&(y=z?!!l&&l.brands.length>Z:!1),D)-5^20)>=D&&(D+2^20)<D&&(y=(Q=b[Z.substring(0,3)+"_"])?Q(Z.substring(3),U,N,G):x(28,Z,9,U)),1)==(D>>2&7)&&(L=function(){},H=function(){try{return V.contentWindow.location.href.match(/^h/)?null:!1}catch(B){return""+B}},a=function(){((J.push(60,+new Date-h),clearInterval)(n),Q.f=void 0,L)(),L=void 0},d=function(B,K){((K=+new Date,J).push(N,K-h,B),B)>U?(J.push(Z,K-h),a()):(u=B,R=K,V=document.createElement("iframe"),c(!1,11,function(v){B===u&&(v=H(),null===v?(J.push(15,+new Date-h),g=V.contentWindow,u=0,V=null,clearInterval(n),L(),L=void 0):(J.push(29,K-h,v),P(),d(B+1)))},V,"load"),c(!1,9,function(){B===u&&(J.push(64,K-h),P(),d(B+1))},V,"error"),V.style.display="none",V.src=q,M.appendChild(V))},P=function(){V=(u=(M.removeChild(V),0),null)},V=null,J=[],u=0,Q.f=function(B,K){L?(K=L,L=function(){K(),setTimeout(function(){B(g,J)},0)}):B(g,J)},h=+new Date,M=document.body||document.documentElement.lastChild,n=setInterval(function(B,K,v){V&&(v=u,B=+new Date,2E4<B-h?(J.push(66,B-h),P(),a()):(K=H())?(J.push(93,B-h,K),P(),d(v+1)):6E3<B-R&&(J.push(87,B-h),P(),d(v+1)))},G),d(1)),D+8^16)<D&&(D-2^25)>=D&&N.addEventListener(G,U,Z),D<<2&20)&&1<=(D>>1&15)&&(C=function(){},G=void 0,N=X(Z,function(B){C&&(U&&m(U),G=B,C(),C=void 0)},!!U)[0],y={invoke:function(B,K,v,p,F){function E(){G(function(r){m(function(){B(r)})},v)}if(!K)return F=N(v),B&&B(F),F;G?E():(p=C,C=function(){p(),m(E)})}}),y},t=function(Z){return k.call(this,6,Z)},S=function(Z,D,U,N){return c.call(this,Z,24,D,U,N)},Y=this||self,A,X=function(Z,D,U,N,G){return c.call(this,Z,19,D,U,N,G)},f=function(Z,D,U,N,G){if(N=(G=D,Y.trustedTypes),!N||!N.createPolicy)return G;try{G=N.createPolicy(Z,{createHTML:t,createScript:t,createScriptURL:t})}catch(Q){if(Y.console)Y.console[U](Q.message)}return G},z;a:{for(var O=["CLOSURE_FLAGS"],e=Y,T=0;T<O.length;T++)if(e=e[O[T]],null==e){A=null;break a}A=e}var l,m=Y.requestIdleCallback?function(Z){requestIdleCallback(function(){Z()},{timeout:4})}:Y.setImmediate?function(Z){setImmediate(Z)}:function(Z){setTimeout(Z,0)},b,W=Y.navigator,I=A&&A[610401301];40<(b=((k((!k(95,(z=(l=W?W.userAgentData||null:null,null!=I)?I:!1,"Android"))||k(8,"CriOS"),9),"CriOS"),!k(90,"Safari")||k(25,"CriOS")||(c(0,93)?0:k(91,"Coast"))||(c(0,94)?0:k(91,"Opera"))||(c(0,92)?0:k(93,"Edge")))||(c(0,89)?k(15,"Microsoft Edge"):k(93,"Edg/"))||c(0,91)&&k(16,"Opera"),Y.botguard||(Y.botguard={})),b.m)||(b.m=41,b.bg=S,b.a=X),b.qYv_=function(Z,D,U,N,G,Q,q){return[(x(28,82,26,512,(G=atob((Q=Z.lastIndexOf("//"),Z.substr(Q+2))),"f"),5,function(h,J,V){if(V="FNL"+J,h)try{q=h.eval(k(17,"error",null,"bg","1",h)(Array(7824*Math.random()|0).join("\n")+['//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjogMywic291cmNlcyI6WyIiXSwic291cmNlc0NvbnRlbnQiOlsiICJdLCJuYW1lcyI6WyJjbG9zdXJlRHluYW1pY0J1dHRvbiJdLCJtYXBwaW5ncyI6IkFBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEifQ==',
'(function(){var u=function(U,Z,G,D,J,B,V,h,N,f){if(!((U^60)>>(3<=((U&((U-3|66)>=(2==(U+9&7)&&("function"===typeof Z?f=Z:(Z[D4]||(Z[D4]=function(Q){return Z.handleEvent(Q)}),f=Z[D4])),U)&&(U-9^19)<U&&(G=Z[UB],f=G instanceof he?G:null),26))==U&&(D=typeof G,f="object"==D&&G!=Z||"function"==D),U|3)>>4&&18>(U^92)&&(Je.call(this),this.B=new he(this),this.hU=this,this.PY=null),4))){if(!(Go.call(this,D),h=G)){for(V=this.constructor;V;){if(B=(J=Bo(5,V),N9[J]))break;V=(N=Object.getPrototypeOf(V.prototype))&&N.constructor}h=B?"function"===typeof B.tU?B.tU():new B:null}this.V=h}return f},ls=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q){return(((Z-7^18)<Z&&(Z-4|10)>=Z&&(B=[94,-84,-91,61,69,-1,B,98,-64,-94],h=VV,N=(J|0)- -1+(~J|7),Q=f0[V.L](V.MD),Q[V.L]=function(z){N+=G+(f=z,7*J),N&=7},Q.concat=function(z,v,d,C){return((C=(v=D%16+1,-v*f+(h()|0)*v)+N- -3612*D*f-U*D*D*f-4214*f+43*f*f+2*D*D*v+B[N+67&7]*D*v,f=void 0,z=B[C],B)[(d=N+69,-~(d&7)+(~d&7)+(d|-8))+(-(J|0)-2*~(J|2)-(J&-3)+2*(J|-3))]=z,B)[N+(-~(J|2)-(J&-3)+(J|-3))]=-84,z},q=Q),Z)+3>>2<Z&&(Z+4^25)>=Z&&(D=QV(2,true,U),D&128&&(D=D&127|QV(2,true,U)<<G),q=D),Z-2^18)>=Z&&(Z+8&33)<Z&&(q=K=function(){if(D.D==D){if(D.Y){var z=[K0,J,V,void 0,h,N,arguments];if(B==U)var v=Y(6,!(l(9,0,z,D),1),false,false,D);else if(B==G){var d=!D.j.length;l(33,0,z,D),d&&Y(6,false,false,false,D)}else v=zo(true,D,235,z);return v}h&&N&&h.removeEventListener(N,K,us)}}),q},y=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q,z,v){if(10<=G-8&&2>(G^55)>>4){if((J.D=(J.Tr+=((q=(Q=(V=4==(N=(B||J.rd++,0<J.s9&&J.jI)&&J.nX&&1>=J.BY&&!J.T&&!J.N&&(!B||1<J.HY-D)&&0==document.hidden,J).rd)||N?J.i():J.X,Q-J.X),z=q>>U,J).o&&(J.o=(f=J.o,K=z*(q<<2),-(f|0)-(K|0)+2*(f|K))),z),z||J.D),V)||N)J.rd=0,J.X=Q;!N||Q-J.DB<J.s9-(Z?255:B?5:2)?v=false:(J.HY=D,h=L(J,B?28:17),P(J,17,J.g),J.j.push([vo,h,B?D+1:D]),J.N=Y4,v=true)}if(5>(G^27)>>5&&7<=(G-6&15)){if(!U)throw Error("Invalid class name "+U);if("function"!==typeof Z)throw Error("Invalid decorator function "+Z);}return(G&111)==G&&(v=Z in L0?L0[Z]:L0[Z]=U+Z),v},dD=function(U,Z,G,D,J){return(G>>(G-U<<1>=G&&(G-Z^Z)<G&&(J=Math.floor(this.AU+(this.i()-this.DB))),1)&8)<Z&&0<=G+Z>>4&&(this.D=D),J},Po=function(U,Z,G,D,J,B,V,h,N,f,Q){if((U-((U^(U+7>>2<U&&(U+2^5)>=U&&(Q=Z&&Z.parentNode?Z.parentNode.removeChild(Z):null),45))>>4||(Z.classList?Array.prototype.forEach.call(G,function(K){b(16,0," ","class","string",K,Z)}):C0(29,5,"string",Array.prototype.filter.call(X("class",34,Z),function(K){return!(0<=X(1,14,G,K))}).join(" "),Z)),7)^29)<U&&(U+3^10)>=U){for(N=V=0,D=[];V<Z.length;V++)for(N+=G,f=(J=f<<G,h=Z[V],-~J-2*(J&~h)+2*(J^h)+(J|~h));7<N;)N-=8,D.push((B=f>>N,-~B+(~B^255)+(~B&255)));Q=D}return Q},Y=function(U,Z,G,D,J,B,V,h,N){if((U&86)==U&&J.j.length){J.jI&&0(),J.nX=D,J.jI=true;try{h=J.i(),J.rd=0,J.X=h,J.DB=h,V=g(false,40,null,":",235,J,D),B=J.i()-J.DB,J.AU+=B,B<(G?0:10)||0>=J.a1--||(B=Math.floor(B),J.bP.push(254>=B?B:254))}finally{J.jI=Z}N=V}return((U+((U+5&25)<U&&(U+9^32)>=U&&(this.CX=this.CX,this.S=this.S),3)^14)<U&&(U-3^27)>=U&&(N=!!(J=D.O9,(J|Z)+(~J^G)-(J|~G))&&!!(D.vY&G)),1==(U>>1&7))&&(V=typeof J,B=V!=D?V:J?Array.isArray(J)?"array":V:"null",N=B==Z||B==D&&typeof J.length==G),N},l=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q,z){if(3==(U|2)>>(3==((U^64)&15)&&(this.uP=a.document||document),3)){if(!V)throw Error("Invalid event type");if(f=((K=(q=u(16,G,N)?!!N.capture:!!N,u(5,B)))||(B[UB]=K=new he(B)),K.add(V,J,h,q,D)),!f.proxy){if((((Q=H(20),f).proxy=Q,Q).src=B,Q).listener=f,B.addEventListener)co||(N=q),void 0===N&&(N=Z),B.addEventListener(V.toString(),Q,N);else if(B.attachEvent)B.attachEvent(y("on",V.toString(),6),Q);else if(B.addListener&&B.removeListener)B.addListener(Q);else throw Error("addEventListener and attachEvent are unavailable.");yV++}}return(U&57)==U&&D.j.splice(Z,Z,G),z},m=function(U,Z,G,D,J,B,V,h,N,f){if(2>(U|(2==(U>>2&15)&&(f=!!(D.vY&J)&&!!(D.C&J)!=G&&(!(D.uB&J)||D.dispatchEvent(H(3,Z,2,16,4,J,G)))&&!D.S),8))>>5&&3<=(U|4)>>4)if(Array.isArray(D))for(N=Z;N<D.length;N++)m(49,0,null,D[N],J,B,V,h);else B=u(17,B),J&&J[k4]?J.B.add(String(D),B,true,u(16,G,V)?!!V.capture:!!V,h):l(26,false,null,h,B,J,D,true,V);if(3==(19>U-3&&11<=(U^15)&&(Z.LX=void 0,Z.tU=function(){return Z.LX?Z.LX:Z.LX=new Z}),U-7>>3))a:{for(B in J)if(D.call(void 0,J[B],B,J)){f=Z;break a}f=G}return f},${'$'}4=function(U,Z,G,D,J,B,V,h){if((G-((G&79)==G&&(D.mH(function(N){B=N},Z,J),h=B),(G|32)==G&&(this.src=Z,this.wd=0,this.Z={}),4)|9)>=G&&G+9>>2<G){if(D=window.btoa){for(B=0,J="";B<Z.length;B+=U)J+=String.fromCharCode.apply(null,Z.slice(B,B+U));V=D(J).replace(/\\+/g,"-").replace(/\\//g,"_").replace(/=/g,"")}else V=void 0;h=V}return h},g=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q){if(Z-4>>4||(J=X(G,6,D,U),(B=0<=J)&&Array.prototype.splice.call(D,J,G),q=B),(Z|40)==Z){for(;B.j.length;){N=(B.N=G,B.j.pop());try{h=zo(true,B,J,N)}catch(z){b(85,D,B,z)}if(V&&B.N){(f=B.N,f)(function(){Y(16,U,true,true,B)});break}}q=h}if((Z&99)==Z)a:{for(V=G;V<U.length;++V)if(h=U[V],!h.J&&h.listener==J&&h.capture==!!B&&h.xh==D){q=V;break a}q=-1}if(!((Z^(4==(Z<<1&15)&&(q="string"==typeof U.className?U.className:U.getAttribute&&U.getAttribute(G)||D),5))&15))if(Array.isArray(V))for(K=G;K<V.length;K++)g(U,37,0,null,J,B,V[K],h);else N=u(18,D,U)?!!U.capture:!!U,h=u(41,h),J&&J[k4]?J.B.remove(String(V),h,N,B):J&&(f=u(3,J))&&(Q=f.E9(h,V,N,B))&&Bo(29,0,true,Q);return q},Bo=function(U,Z,G,D,J,B,V,h,N,f,Q){if(((((U-9|43)<U&&(U+7&46)>=U&&(Q=Object.prototype.hasOwnProperty.call(Z,bs)&&Z[bs]||(Z[bs]=++x4)),U+4)&37)>=U&&U+9>>1<U&&"number"!==typeof D&&D&&!D.J&&((h=D.src)&&h[k4]?X(G,48,h.B,D):(V=D.proxy,B=D.type,h.removeEventListener?h.removeEventListener(B,V,D.capture):h.detachEvent?h.detachEvent(y("on",B,7),V):h.addListener&&h.removeListener&&h.removeListener(V),yV--,(J=u(6,h))?(X(G,49,J,D),J.wd==Z&&(J.src=null,h[UB]=null)):X(G,21,D))),26)<=U>>1&&3>(U<<2&4)){for(B=J=0;B<Z.length;B++)J+=Z.charCodeAt(B),J+=J<<10,J=(N=J>>6,~J+~N-2*~(J|N));f=new (V=(J+=J<<3,J^=J>>11,J)+(J<<15)>>>0,Number)(V&(h=1<<G,-2-~(h|1)-(~h&1))),f[0]=(V>>>G)%D,Q=f}return Q},C0=function(U,Z,G,D,J,B,V,h,N,f){if((Z|(1==(Z>>2&13)&&(typeof J.className==G?J.className=D:J.setAttribute&&J.setAttribute("class",D)),40))==Z)for(N=B.length,h="string"===typeof B?B.split(G):B,V=D;V<N;V++)V in h&&J.call(void 0,h[V],V,B);if((Z-3^8)<Z&&(Z+7^7)>=Z)if(J=D.length,J>G){for(B=Array(J),V=G;V<J;V++)B[V]=D[V];f=B}else f=[];return(Z+7^U)<Z&&Z-3<<1>=Z&&(this.type=G,this.currentTarget=this.target=D,this.defaultPrevented=this.O=false),f},aB=function(U,Z,G,D,J,B,V,h,N,f){if(3==((Z&55)==Z&&(f=Math.floor(this.i())),Z+6&15))for(h in B=D,J.Z){for(N=J.Z[h],V=D;V<N.length;V++)++B,X(G,22,N[V]);delete J.Z[h],J.wd--}return(Z+7^((Z&((Z-7|23)>=Z&&(Z-6|20)<Z&&(G.J?V=true:(h=new Xx(D,this),J=G.xh||G.src,B=G.listener,G.Yh&&Bo(28,0,true,G),V=B.call(J,h)),f=V),91))==Z&&(gD.call(this,G?G.type:""),this.relatedTarget=this.currentTarget=this.target=U,this.button=this.screenY=this.screenX=this.clientY=this.clientX=this.offsetY=this.offsetX=0,this.key="",this.charCode=this.keyCode=0,this.metaKey=this.shiftKey=this.altKey=this.ctrlKey=false,this.state=U,this.pointerId=0,this.pointerType="",this.H=U,G&&(B=this.type=G.type,V=G.changedTouches&&G.changedTouches.length?G.changedTouches[0]:null,this.target=G.target||G.srcElement,this.currentTarget=D,J=G.relatedTarget,J||("mouseover"==B?J=G.fromElement:"mouseout"==B&&(J=G.toElement)),this.relatedTarget=J,V?(this.clientX=void 0!==V.clientX?V.clientX:V.pageX,this.clientY=void 0!==V.clientY?V.clientY:V.pageY,this.screenX=V.screenX||0,this.screenY=V.screenY||0):(this.offsetX=G.offsetX,this.offsetY=G.offsetY,this.clientX=void 0!==G.clientX?G.clientX:G.pageX,this.clientY=void 0!==G.clientY?G.clientY:G.pageY,this.screenX=G.screenX||0,this.screenY=G.screenY||0),this.button=G.button,this.keyCode=G.keyCode||0,this.key=G.key||"",this.charCode=G.charCode||("keypress"==B?G.keyCode:0),this.ctrlKey=G.ctrlKey,this.altKey=G.altKey,this.shiftKey=G.shiftKey,this.metaKey=G.metaKey,this.pointerId=G.pointerId||0,this.pointerType="string"===typeof G.pointerType?G.pointerType:n0[G.pointerType]||"",this.state=G.state,this.H=G,G.defaultPrevented&&Xx.u.preventDefault.call(this))),26))>=Z&&(Z-4^4)<Z&&F.call(this,G,D||M9.tU(),J),f},t=function(U,Z,G,D,J){return 5<=(U+3&((U&46)==U&&(P(Z,D,G),G[Ho]=2796),7))&&20>U>>1&&(D=G,J=function(){return D<Z.length?{done:false,value:Z[D++]}:{done:true}}),J},p=function(U,Z,G,D,J,B,V,h){if(2<=((Z&44)==Z&&(U.T?h=m0(U,U.l):(D=Fx(2,true,U,8),(D|128)-~D- -129+2*~(D|128)&&(D^=128,G=Fx(2,true,U,2),D=(J=D<<2,-2*~(J|G)+(J^G)+2*(~J^G))),h=D)),(Z+3^10)>=Z&&Z+3>>2<Z&&(h=(V=D[J]<<U|D[-2*~J+(J&-2)+2*(~J^1)+G*(~J&1)]<<16,B=D[-2*~(J&2)+G*(J^2)+2*(~J^2)]<<8,2*(V&B)+2*~(V&B)-~B-(~V|B))|D[(J|0)+G]),Z<<1&13)&&3>Z>>2)if(J="array"===te("call",D,"number")?D:[D],this.F)U(this.F);else try{V=!this.j.length,B=[],l(8,0,[jQ,B,J],this),l(32,0,[SQ,U,B],this),G&&!V||Y(20,false,true,G,this)}catch(N){b(82,":",this,N),U(this.F)}return h},Ae=function(U,Z,G,D,J,B,V,h,N,f,Q){return(Z<<2&(2==(16>(Z<<1&16)&&10<=(Z<<1&11)&&(this.listener=V,this.proxy=null,this.src=D,this.type=J,this.capture=!!G,this.xh=B,this.key=++RB,this.J=this.Yh=false),Z+6&15)&&(B=D,B^=B<<13,B^=B>>17,(B=(B^B<<5)&J)||(B=1),Q=G^B),16))<U&&12<=(Z^39)&&(Array.isArray(V)&&(V=V.join(" ")),f="aria-"+B,""===V||void 0==V?(oB||(h={},oB=(h.atomic=false,h.autocomplete="none",h.dropeffect="none",h.haspopup=false,h[D]="off",h.multiline=false,h.multiselectable=false,h.orientation="vertical",h.readonly=false,h.relevant="additions text",h.required=false,h.sort="none",h[G]=false,h.disabled=false,h.hidden=false,h.invalid="false",h)),N=oB,B in N?J.setAttribute(f,N[B]):J.removeAttribute(f)):J.setAttribute(f,V)),Q},O=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q){if(4==(U<<2&((U+(4==(U+6&15)&&G.ZB&&G.ZB.forEach(Z,void 0),5)^14)<U&&(U-6^21)>=U&&(J.classList?B=J.classList.contains(D):(V=X("class",35,J),B=X(G,13,V,D)>=Z),q=B),15)))if(V=D.B.Z[String(J)]){for(f=(Q=(V=V.concat(),Z),true);Q<V.length;++Q)(K=V[Q])&&!K.J&&K.capture==B&&(h=K.listener,N=K.xh||K.src,K.Yh&&X(true,50,D.B,K),f=false!==h.call(N,G)&&f);q=f&&!G.defaultPrevented}else q=true;return(U+9&53)<U&&(U+8&72)>=U&&(B=new E(J,Z,G),q=[function(z){return ${'$'}4(8192,false,3,B,z)}]),q},X=function(U,Z,G,D,J,B){if((((Z-1|52)>=Z&&(Z-6|38)<Z&&(J=D.type,J in G.Z&&g(D,7,1,G.Z[J])&&(X(U,20,D),0==G.Z[J].length&&(delete G.Z[J],G.wd--))),(Z^35)>>4||(B=G.classList?G.classList:g(G,50,U,"").match(/\\S+/g)||[]),14<=Z<<1&&8>(Z-4&15))&&(G.J=U,G.listener=null,G.proxy=null,G.src=null,G.xh=null),Z&79)==Z)a:if("string"===typeof G)B="string"!==typeof D||D.length!=U?-1:G.indexOf(D,0);else{for(J=0;J<G.length;J++)if(J in G&&G[J]===D){B=J;break a}B=-1}return B},b=function(U,Z,G,D,J,B,V,h,N,f){if(3>(4==(U<<2&(14>U>>2&&6<=(U+5&9)&&(f=Z),31))&&(p0.call(this),Z||EB||(EB=new is),this.ZB=null,this.zr=false,this.lP=null,this.R=void 0,this.h=this.pX=this.m=null,this.xt=false),(U^12)>>4)&&3<=(U<<2&23))if(J&&J.once)m(48,Z,null,h,V,D,J,B);else if(Array.isArray(h))for(N=Z;N<h.length;N++)b(11,0,false,D,J,B,V,h[N]);else D=u(9,D),V&&V[k4]?V.B.add(String(h),D,G,u(24,null,J)?!!J.capture:!!J,B):l(27,false,null,B,D,V,h,G,J);return 1==(((U|80)==U&&(G.F=((G.F?G.F+"~":"E:")+D.message+Z+D.stack).slice(0,2048)),U^97)&15)&&(V.classList?V.classList.remove(B):O(10,Z,1,B,V)&&C0(29,7,J,Array.prototype.filter.call(X(D,32,V),function(Q){return Q!=B}).join(G),V)),f},OB=function(U,Z,G,D,J,B,V,h){if(21>(G^29)&&10<=(G>>1&15))if(Z.classList)Array.prototype.forEach.call(D,function(N,f){Z.classList?Z.classList.add(N):O(7,0,1,N,Z)||(f=g(Z,26,"class",""),C0(29,68,"string",f+(0<f.length?U+N:N),Z))});else{for(V in J=((Array.prototype.forEach.call(X("class",33,(B={},Z)),function(N){B[N]=true}),Array).prototype.forEach.call(D,function(N){B[N]=true}),""),B)J+=0<J.length?U+V:V;C0(29,6,"string",J,Z)}return(G&83)==((G^50)&11||D.S||(D.S=Z,D.P()),G)&&(h=f0[Z](f0.prototype,{splice:D,length:D,parent:D,pop:D,prototype:D,propertyIsEnumerable:D,stack:D,replace:D,console:D,floor:D,document:D,call:D})),h},H=function(U,Z,G,D,J,B,V,h,N,f){if((1==(U+7&7)&&(h=function(){},h.prototype=D.prototype,G.u=D.prototype,G.prototype=new h,G.prototype.constructor=G,G.AW=function(Q,K,q){for(var z=Array(arguments.length-Z),v=Z;v<arguments.length;v++)z[v-Z]=arguments[v];return D.prototype[K].apply(Q,z)}),1>((U|6)&8)&&3<=((U|2)&4))&&(f=function(Q){return Z.call(f.src,f.listener,Q)},Z=eQ,N=f),!((U|8)>>4))a:{switch(B){case Z:N=V?"disable":"enable";break a;case G:N=V?"highlight":"unhighlight";break a;case J:N=V?"activate":"deactivate";break a;case 8:N=V?"select":"unselect";break a;case D:N=V?"check":"uncheck";break a;case 32:N=V?"focus":"blur";break a;case 64:N=V?"open":"close";break a}throw Error("Invalid component state");}return N},To=function(U,Z,G,D,J,B,V,h){if(G-3<<1>=G&&(G-1|U)<G){for(V=(B=p(D,12),0);0<J;J--)V=V<<Z|QV(2,true,D);P(D,B,V)}return G<<1&7||(J=f0[D.L](D.wo),J[D.L]=function(){return Z},J.concat=function(N){Z=N},h=J),h},E=function(U,Z,G,D){D=this;try{Wo(G,Z,U,this)}catch(J){b(86,":",this,J),G(function(B){B(D.F)})}},Fx=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q,z,v,d,C){if(V=L(G,17),V>=G.g)throw[rD,31];for(q=(C=0,B=V,v=D,G).FI.length;0<v;)J=B>>3,f=B%8,N=8-(f|0),z=N<v?N:v,d=G.U[J],Z&&(h=G,h.A!=B>>6&&(h.A=B>>6,Q=L(h,10),h.Gr=IB(255,0,320,h.o,[0,0,Q[1],Q[U]],h.A,29)),d^=G.Gr[J&q]),C|=(d>>8-(f|0)-(z|0)&(1<<z)-1)<<(v|0)-(z|0),B+=z,v-=z;return P(G,17,(V|0)+(D|(K=C,0))),K},te=function(U,Z,G,D,J){if("object"==(D=typeof Z,D))if(Z){if(Z instanceof Array)return"array";if(Z instanceof Object)return D;if((J=Object.prototype.toString.call(Z),"[object Window]")==J)return"object";if("[object Array]"==J||typeof Z.length==G&&"undefined"!=typeof Z.splice&&"undefined"!=typeof Z.propertyIsEnumerable&&!Z.propertyIsEnumerable("splice"))return"array";if("[object Function]"==J||"undefined"!=typeof Z.call&&"undefined"!=typeof Z.propertyIsEnumerable&&!Z.propertyIsEnumerable(U))return"function"}else return"null";else if("function"==D&&"undefined"==typeof Z.call)return"object";return D},Zz=function(U,Z,G,D,J,B,V,h,N,f){for(N=(V=p(J,(h=(B=p(J,(f=J[sB]||{},12)),f.fX=p(J,44),f.W=[],J).D==J?(QV(U,Z,J)|D)-G:1,40)),D);N<h;N++)f.W.push(p(J,40));for(;h--;)f.W[h]=L(J,f.W[h]);return f.ND=L(J,B),f.KX=L(J,V),f},Dz=function(U,Z,G){return aB.call(this,null,40,U,Z,G)},Je=function(){return Y.call(this,17)},Xx=function(U,Z,G,D,J){return aB.call(this,null,11,U,Z,G,D,J)},U0=function(U,Z,G,D,J,B,V,h){try{B=U[((Z|0)+2)%3],U[Z]=(J=(V=U[Z],h=U[(-~(Z&1)+-2-~(Z|1))%3],(V&~h)+(~V^h)-(~V|h))-(B|0),D=1==Z?B<<G:B>>>G,(J|0)-(J&D)+(~J&D))}catch(N){throw N;}},hE=function(U,Z,G,D,J){return Ae.call(this,4,5,J,G,U,Z,D)},JE=function(U,Z,G,D,J,B,V,h,N,f){function Q(K){K&&G.appendChild("string"===typeof K?D.createTextNode(K):K)}for(h=B;h<Z.length;h++)if(N=Z[h],!Y(3,"array","number","object",N)||u(10,V,N)&&N.nodeType>J)Q(N);else{a:{if(N&&"number"==typeof N.length){if(u(10,V,N)){f="function"==typeof N.item||"string"==typeof N.item;break a}if("function"===typeof N){f="function"==typeof N.item;break a}}f=U}C0(29,40,"",J,Q,f?C0(29,11,J,N):N)}},Gq=function(U){return Po.call(this,6,U)},a=this||self,Nb=function(U,Z,G,D,J,B,V,h,N,f,Q){if(!G.SI){if(3<(J=L(G,((V=(B=L(((N=void 0,Z&&Z[0]===rD)&&(N=Z[2],D=Z[1],Z=void 0),G),384),0==B.length&&(f=L(G,28)>>3,B.push(D,(Q=f>>8,(Q|255)- -2+(Q^255)+2*(~Q^255)),f&255),void 0!=N&&B.push(N&255)),""),Z)&&(Z.message&&(V+=Z.message),Z.stack&&(V+=":"+Z.stack)),352)),J)){G.D=(h=(V=(V=V.slice(0,-7-2*~(J|3)+(~J^3)),J-=(V.length|0)+3,B9(192,V)),G.D),G);try{e(r(V.length,2).concat(V),G,170,U)}finally{G.D=h}}P(G,352,J)}},Vs=function(U,Z,G,D,J){return O.call(this,56,U,Z,G,D,J)},fl=function(){return Ae.call(this,4,52)},Qs=function(U,Z,G,D,J,B,V){e(((D=p(U,(G=(V=-(Z|0)+(Z|3)-~Z+(~(J=Z&4,Z)^3),p(U,44)),44)),B=L(U,G),J&&(B=B9(192,""+B)),V)&&e(r(B.length,2),U,D),B),U,D)},Kl=function(U,Z,G,D,J){return OB.call(this," ",U,20,Z,G,D,J)},p0=function(){return u.call(this,76)},qb=function(U){return b.call(this,8,U)},uM=function(U,Z){for(var G=1,D,J;G<arguments.length;G++){for(J in D=arguments[G],D)U[J]=D[J];for(var B=0;B<zq.length;B++)J=zq[B],Object.prototype.hasOwnProperty.call(D,J)&&(U[J]=D[J])}},v9=function(U,Z){for(Z=[];U--;)Z.push(255*Math.random()|0);return Z},Wo=function(U,Z,G,D,J,B,V){for(D.wo=(D.MD=OB((D.Qy=Ll,D.ro=Yd,D.FI=D[SQ]," "),D.L,3,{get:function(){return this.concat()}}),f0)[D.L](D.MD,{value:{value:{}}}),V=[],J=0;368>J;J++)V[J]=String.fromCharCode(J);Y(16,(l(41,(l(40,0,(l(16,0,(P(D,(P((((t(6,(P(D,170,(t(38,D,function(h,N,f,Q,K,q){f=(K=L(h,(q=p(h,(N=p(h,12),40)),Q=p(h,44),N)),L(h,q)),P(h,Q,K in f|0)},(t((t(14,D,function(h,N,f,Q,K){for(K=(N=(f=(Q=p(h,44),ls(h,28,7)),0),[]);N<f;N++)K.push(QV(2,true,h));P(h,Q,K)},(t(6,D,function(){},(t(32,(t(8,(t(8,(P(D,(t(38,D,function(h,N,f,Q,K,q,z,v,d){y(14,false,57,N,h,true)||(f=Zz(2,true,1,0,h.D),d=f.KX,z=f.fX,Q=f.ND,q=f.W,v=q.length,K=0==v?new d[Q]:1==v?new d[Q](q[0]):2==v?new d[Q](q[0],q[1]):3==v?new d[Q](q[0],q[1],q[2]):4==v?new d[Q](q[0],q[1],q[2],q[3]):2(),P(h,z,K))},(P(D,171,(t(6,(P(D,456,(t((t(14,(t(8,(t(8,(P(D,399,(t(14,D,function(h,N,f){N=p(h,44),f=L(h.D,N),f[0].removeEventListener(f[1],f[2],us)},(t((t(38,(t(6,(P(D,(P(D,374,(D.jH=(t((t(32,D,function(h){Qs(h,4)},(t(8,(P(D,(t(6,((t(32,D,(t(32,((t(38,D,function(h,N,f,Q,K){!y(14,false,58,N,h,true)&&(f=Zz(2,true,1,0,h),Q=f.KX,K=f.ND,h.D==h||K==h.yS&&Q==h)&&(P(h,f.fX,K.apply(Q,f.W)),h.X=h.i())},(P(D,332,[(P(D,(P(D,28,(P(D,(D.py=(D.rd=(D.N=(D.F=(D.l=(D.j=[],void 0),D.g=0,void 0),(D.iP=[],D.Vy=G,D).A=(D.Gr=void 0,D.s9=(D.X=(D.U=[],0),(D.DB=0,D).Y=(D.bP=[],(D.o=void 0,D).BY=0,[]),D.AU=0,D.a1=25,D.Tr=1,D.HY=8001,0),D.TM=(D.D=(D.nX=(D.SI=false,B=window.performance||{},!(D.T=void 0,1)),D),0),D.yS=function(h){return dD.call(this,3,7,3,h)},D.jI=(D.gd=[],false),void 0),null),void 0),B.timeOrigin||(B.timing||{}).navigationStart||0),17),0),0)),195),D),OB(" ",true,34,new Dz("Submit")),165),0,0]),166)),t)(6,D,function(h){Qs(h,3)},319),D),function(h,N,f){P(h,(f=p((N=p(h,12),h),12),f),""+L(h,N))},96),function(h){To(4,8,6,h,4)}),168),t)(38,D,function(h,N,f,Q,K,q,z){for(f=(Q=(K=(z=(q=ls(h,29,(N=p(h,40),7)),""),L(h,138)),K.length),0);q--;)f=((f|0)+(ls(h,30,7)|0))%Q,z+=V[K[f]];P(h,N,z)},476),D),function(h,N,f,Q){P(h,(N=p(h,(f=QV((Q=p(h,12),2),true,h),12)),N),L(h,Q)>>>f)},386),352),2048),D),function(h,N,f,Q,K,q){P((N=L(h,(K=L(h,(f=p((Q=(q=p(h,8),p(h,44)),h),12),q)),Q)),h),f,K[N])},102),469)),32),D,function(h,N){Cl(0,12,(N=L(h,p(h,44)),17),h.D,N,104)},161),0),[])),227),a),D),function(h,N,f,Q){y(14,false,56,N,h,true)||(f=p(h,44),Q=p(h,12),P(h,Q,function(K){return eval(K)}(dO(L(h.D,f)))))},236),D),function(h,N,f,Q,K,q,z,v,d,C){0!==(N=L((K=(C=L(h,(z=L(h,(Q=p(h,(f=(v=p((q=p(h,40),h),40),p)(h,8),44)),f)),v)),L(h,Q)),h).D,q),N)&&(d=ls(2,13,1,h,z,1,K,N,C),N.addEventListener(C,d,us),L(h,374).push(function(){N.removeEventListener(C,d,us)}),P(h,171,[N,C,d]))},223),14),D,function(h,N,f,Q,K){P(h,(f=(N=(Q=p((K=p(h,40),h),8),L(h,Q)),L(h,K)),Q),N+f)},380),t(14,D,function(h,N,f,Q,K,q,z,v,d,C,n,x,S,k){if(!y(14,true,54,N,h,true)){if("object"==te("call",(C=L(h,(Q=L((x=(S=(f=p(h,(q=(n=p(h,12),p)(h,12),8)),p)(h,8),L(h,n)),v=L(h,S),h),q),f)),x),"number")){for(z in d=[],x)d.push(z);x=d}for(k=0,K=x.length,C=0<C?C:1;k<K;k+=C)Q(x.slice(k,-1-2*~(k|C)+(~k^C)),v)}},320),3)),[])),D.Ej=0,D),function(h){P9(1,h)},406),D),function(h,N,f,Q,K,q,z,v){P((Q=(z=L(h,(K=p((f=(v=(N=p(h,40),p)(h,40),p(h,40)),h),40),f)),L)(h,v),q=L(h,K),h),N,ls(2,12,1,h,Q,q,z))},26),D),function(h,N,f,Q,K,q,z,v,d,C,n,x,S,k,q9,R,T){function A(c,w){for(;z<c;)d|=QV(2,true,h)<<z,z+=8;return d>>=(w=d&(1<<c)-1,z-=c,c),w}for(N=x=(T=(K=(v=(d=z=(S=p(h,40),0),A(3)),~(v&1)-3*~(v|1)+2*(~v^1)),A)(5),n=[],0);N<T;N++)q9=A(1),n.push(q9),x+=q9?0:1;for(f=((x|0)-1).toString(2).length,R=[],Q=0;Q<T;Q++)n[Q]||(R[Q]=A(f));for(k=0;k<T;k++)n[k]&&(R[k]=p(h,44));for(C=K,q=[];C--;)q.push(L(h,p(h,8)));t(32,h,function(c,w,Z4,M,W){for(w=(Z4=(W=0,[]),[]);W<T;W++){if(!(M=R[W],n[W])){for(;M>=Z4.length;)Z4.push(p(c,8));M=Z4[M]}w.push(M)}c.l=To((c.T=To(4,q.slice(),20,c),4),w,28,c)},S)},233),14),D,function(h,N,f,Q){P(h,(f=p(h,(Q=(N=p(h,8),p(h,40)),40)),f),L(h,N)||L(h,Q))},376),[0,0,0])),D),function(h,N,f,Q){if(Q=h.gd.pop()){for(f=QV(2,true,h);0<f;f--)N=p(h,44),Q[N]=h.Y[N];h.Y=(Q[352]=(Q[384]=h.Y[384],h.Y[352]),Q)}else P(h,17,h.g)},107),0)),432)),139),156),D),function(h,N,f,Q,K,q,z){(Q=(K=p(h,(N=p(h,12),12)),p)(h,12),h.D)==h&&(q=L(h,N),z=L(h,Q),f=L(h,K),q[f]=z,10==N&&(h.A=void 0,2==f&&(h.o=Fx(2,false,h,32),h.A=void 0)))},420),D),function(h,N,f,Q,K,q){P((Q=L(h,(q=p((f=p(h,(N=p(h,8),8)),h),44),N)),K=L(h,f),h),q,+(Q==K))},32),D),function(h,N,f,Q,K){P(h,(Q=te("call",(K=(f=p((N=p(h,12),h),8),L(h,N)),K),"number"),f),Q)},312),48)),255)),8),D,function(h){P9(4,h)},93),137)),v9(4))),D),function(h,N,f,Q,K){(K=L(h,(Q=(N=(f=p(h,8),p(h,8)),0)!=L(h,f),N)),Q)&&P(h,17,K)},450),D).zM=0,P)(D,235,{}),D),384,[]),421),0),[Ho]),D),[c9,Z]),D),0),[ys,U],D),false),true,true,D)},M9=function(){return Bo.call(this,9)},QV=function(U,Z,G){return G.T?m0(G,G.l):Fx(U,Z,G,8)},P9=function(U,Z,G,D){e(r(L(Z,(D=p(Z,(G=p(Z,8),44)),G)),U),Z,D)},kd=function(U,Z){return Po.call(this,37,U,Z)},r=function(U,Z,G,D){for(G=-(Z|1)-~(Z&1)-1+(D=[],2*(Z&-2));0<=G;G--)D[(Z|0)-1-(G|0)]=U>>8*G&255;return D},d=function(){return O.call(this,16)},B9=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q){for(V=(q=Z.replace(/\\r\\n/g,"\\n"),h=0,Q=[],0);h<q.length;h++)B=q.charCodeAt(h),128>B?Q[V++]=B:(2048>B?Q[V++]=B>>6|U:(55296==(B&64512)&&h+1<q.length&&56320==(q.charCodeAt(h+1)&64512)?(B=(D=(B&1023)<<10,(65536&D)+-65537-2*~(65536|D)+(65536|~D))+(f=q.charCodeAt(++h),1023+(~f^1023)-(~f|1023)),Q[V++]=B>>18|240,Q[V++]=B>>12&63|128):Q[V++]=(N=B>>12,(N|0)-(~N^224)+(~N|224)),Q[V++]=(K=(J=B>>6,-~J+(~J^63)+(~J&63)),-2-~K-(K|-129))),Q[V++]=(G=B&63,2*(G|0)+~G-(G|-129)));return Q},e=function(U,Z,G,D,J,B,V,h,N){if(Z.D==Z)for(N=L(Z,G),170==G?(h=function(f,Q,K,q,z,v){if((v=((q=N.length,q)&-5)+(~q^4)-(~q|4)>>3,N).Xi!=v){K=(z=v<<3,2*(z&4)- -2+-10+(Q=[0,0,J[1],J[2]],z^(N.Xi=v,4)));try{N.JU=IB(255,0,320,p(24,13,3,N,K),Q,p(24,14,3,N,-2*~(K&4)+-3-(~K^4)),29)}catch(d){throw d;}}N.push(N.JU[q&7]^f)},J=L(Z,456)):h=function(f){N.push(f)},D&&h(D&255),V=0,B=U.length;V<B;V++)h(U[V])},zo=function(U,Z,G,D,J,B,V,h,N,f,Q){if((h=D[0],h)==jQ)Z.a1=25,Z.s(D);else if(h==SQ){f=D[1];try{V=Z.F||Z.s(D)}catch(K){b(83,":",Z,K),V=Z.F}f(V)}else if(h==vo)Z.s(D);else if(h==c9)Z.s(D);else if(h==ys){try{for(Q=0;Q<Z.iP.length;Q++)try{J=Z.iP[Q],J[0][J[1]](J[2])}catch(K){}}catch(K){}(0,D[1])(function(K,q){Z.mH(K,U,q)},(Z.iP=[],function(K){(l(17,0,[bM],(K=!Z.j.length,Z)),K)&&Y(22,false,false,U,Z)}))}else{if(h==K0)return N=D[2],P(Z,434,D[6]),P(Z,G,N),Z.s(D);h==bM?(Z.s(D),Z.bP=[],Z.U=[],Z.Y=null):h==Ho&&(B=a.parent,"loading"===B.document.readyState&&(Z.N=function(K,q){function z(){q||(q=U,B.document.removeEventListener("DOMContentLoaded",z,us),B.removeEventListener("load",z,us),K())}(B.document.addEventListener("DOMContentLoaded",(q=false,z),us),B).addEventListener("load",z,us)}))}},XV=function(U,Z,G,D,J,B){return L((P(Z,(xd(2048,Z,G,(B=L(Z,17),Z.U&&B<Z.g?(P(Z,17,Z.g),Cl(U,12,17,Z,J,D)):P(Z,17,J),false)),17),B),Z),235)},IB=function(U,Z,G,D,J,B,V,h,N,f){for(h=(N=J[f=J[3]|Z,2]|Z,Z);16>h;h++)B=B>>>8|B<<24,B+=D|Z,D=D<<3|D>>>V,f=f>>>8|f<<24,B^=N+G,f+=N|Z,N=N<<3|N>>>V,f^=h+G,N^=f,D^=B;return[D>>>24&U,D>>>16&U,D>>>8&U,D>>>Z&U,B>>>24&U,B>>>16&U,B>>>8&U,B>>>Z&U]},gO=function(U,Z,G,D,J){if(3==U.length){for(G=0;3>G;G++)Z[G]+=U[G];for(D=[13,8,(J=0,13),12,16,5,3,10,15];9>J;J++)Z[3](Z,J%3,D[J])}},Go=function(U){return b.call(this,49,U)},I,xd=function(U,Z,G,D,J,B,V,h,N){if(!Z.F){Z.BY++;try{for(V=(J=(h=0,void 0),Z.g);--G;)try{if(N=void 0,Z.T)J=m0(Z,Z.T);else{if((h=L(Z,17),h)>=V)break;J=L(Z,(N=p(Z,(P(Z,28,h),44)),N))}y(14,D,55,(J&&(B=J[bM],(B|U)-2*~(B&U)+2*~(B|U)+(B^U))?J(Z,G):Nb(12,[rD,21,N],Z,0),G),Z,D)}catch(f){L(Z,139)?Nb(12,f,Z,22):P(Z,139,f)}if(!G){if(Z.U9){xd(2048,Z,(Z.BY--,799919977500),false);return}Nb(12,[rD,33],Z,0)}}catch(f){try{Nb(12,f,Z,22)}catch(Q){b(84,":",Z,Q)}}Z.BY--}},P=function(U,Z,G){if(17==Z||28==Z)U.Y[Z]?U.Y[Z].concat(G):U.Y[Z]=To(4,G,12,U);else{if(U.SI&&10!=Z)return;332==Z||170==Z||399==Z||384==Z||456==Z?U.Y[Z]||(U.Y[Z]=ls(86,23,6,Z,86,G,U)):U.Y[Z]=ls(86,24,6,Z,33,G,U)}10==Z&&(U.o=Fx(2,false,U,32),U.A=void 0)},nl=function(U,Z,G,D,J,B,V,h,N,f,Q,K,q,z){(Z.push((G=(J=(N=U[0]<<24,V=U[1]<<16,-1-~N-(~N^V)+(~N|V)),f=U[2]<<8,-~(J&f)+-2-(~J^f)),D=U[3],(D|0)+(G^D)-(~G&D))),Z.push((B=(K=U[4]<<24,Q=U[5]<<16,(K|0)+(Q|0)-(K&Q))|U[6]<<8,q=U[7],~(B&q)-2*~(B|q)+(~B^q))),Z).push((z=U[8]<<24,h=U[9]<<16,-~(z|h)+(z^h)+(~z^h))|U[10]<<8|U[11])},gD=function(U,Z){return C0.call(this,29,19,U,Z)},Mb=function(U,Z,G,D,J){if(D=(J=a.trustedTypes,G),!J||!J.createPolicy)return D;try{D=J.createPolicy(U,{createHTML:qb,createScript:qb,createScriptURL:qb})}catch(B){if(a.console)a.console[Z](B.message)}return D},L=function(U,Z,G){if((G=U.Y[Z],void 0)===G)throw[rD,30,Z];if(G.value)return G.create();return(G.create(2*Z*Z+-84*Z+98),G).prototype},he=function(U){return ${'$'}4.call(this,8192,U,32)},is=function(){return l.call(this,3)},F=function(U,Z,G,D,J,B,V,h){return u.call(this,48,U,Z,G,D,J,B,V,h)},Cl=function(U,Z,G,D,J,B){D.gd.length>B?Nb(Z,[rD,36],D,U):(D.gd.push(D.Y.slice()),D.Y[G]=void 0,P(D,G,J))},eQ=function(U,Z,G,D,J,B){return aB.call(this,null,31,U,Z,G,D,J,B)},m0=function(U,Z,G){return(G=Z.create().shift(),U.T.create().length||U.l.create().length)||(U.T=void 0,U.l=void 0),G},aI=function(){return l.call(this,58)},bs="closure_uid_"+(1E9*Math.random()>>>0),EB,x4=0,co=function(U,Z,G){if(!a.addEventListener||!Object.defineProperty)return false;G=Object.defineProperty({},(Z=false,"passive"),{get:function(){Z=true}});try{U=function(){},a.addEventListener("test",U,G),a.removeEventListener("test",U,G)}catch(D){}return Z}(),n0={2:"touch",3:"pen",4:(H(26,((Je.prototype.P=(Je.prototype.S=false,function(){if(this.CX)for(;this.CX.length;)this.CX.shift()()}),gD.prototype.stopPropagation=function(){this.O=true},gD).prototype.preventDefault=function(){this.defaultPrevented=true},2),Xx,gD),"mouse")},k4="closure_listenable_"+((Xx.prototype.preventDefault=function(U){(U=(Xx.u.preventDefault.call(this),this.H),U.preventDefault)?U.preventDefault():U.returnValue=false},Xx).prototype.stopPropagation=function(){(Xx.u.stopPropagation.call(this),this).H.stopPropagation?this.H.stopPropagation():this.H.cancelBubble=true},1E6*Math.random()|0),zq="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" "),RB=0,UB="closure_lm_"+((he.prototype.add=((he.prototype.hasListener=function(U,Z,G,D,J){return m(31,(D=(J=(G=void 0!==Z,void 0!==U))?U.toString():"",true),false,function(B,V){for(V=0;V<B.length;++V)if(!(J&&B[V].type!=D||G&&B[V].capture!=Z))return true;return false},this.Z)},he.prototype).remove=function(U,Z,G,D,J,B,V){if(V=U.toString(),!(V in this.Z))return false;return-(B=this.Z[V],J=g(B,33,0,D,Z,G),1)<J?(X(true,23,B[J]),Array.prototype.splice.call(B,J,1),0==B.length&&(delete this.Z[V],this.wd--),true):false},he.prototype.E9=function(U,Z,G,D,J,B){return-1<(J=-(B=this.Z[Z.toString()],1),B&&(J=g(B,3,0,D,U,G)),J)?B[J]:null},function(U,Z,G,D,J,B,V,h,N){return-1<(N=(V=(h=U.toString(),this.Z[h]),V||(V=this.Z[h]=[],this.wd++),g)(V,32,0,J,Z,D),N)?(B=V[N],G||(B.Yh=false)):(B=new hE(h,J,this.src,Z,!!D),B.Yh=G,V.push(B)),B}),1E6)*Math.random()|0),yV=0,L0={},D4="__closure_events_fn_"+(1E9*Math.random()>>>0);(((I=((H(34,2,p0,Je),p0).prototype[k4]=true,p0.prototype),I).VS=function(U){this.PY=U},I).addEventListener=function(U,Z,G,D){b(12,0,false,Z,G,D,this,U)},I.removeEventListener=function(U,Z,G,D){g(G,21,0,null,this,D,U,Z)},I.dispatchEvent=function(U,Z,G,D,J,B,V,h,N,f,Q){if(G=this.PY)for(Z=[];G;G=G.PY)Z.push(G);if(N=!("string"===(D=(B=(J=this.hU,U),Z),Q=B.type||B,typeof B)?B=new gD(B,J):B instanceof gD?B.target=B.target||J:(V=B,B=new gD(Q,J),uM(B,V)),0),D)for(h=D.length-1;!B.O&&0<=h;h--)f=B.currentTarget=D[h],N=O(13,0,B,f,Q,true)&&N;if(B.O||(f=B.currentTarget=J,N=O(29,0,B,f,Q,true)&&N,B.O||(N=O(25,0,B,f,Q,false)&&N)),D)for(h=0;!B.O&&h<D.length;h++)f=B.currentTarget=D[h],N=O(17,0,B,f,Q,false)&&N;return N},I).E9=function(U,Z,G,D){return this.B.E9(U,String(Z),G,D)},I.P=function(){((p0.u.P.call(this),this).B&&aB(null,13,true,0,this.B),this).PY=null},I.hasListener=function(U,Z){return this.B.hasListener(void 0!==U?String(U):void 0,Z)};var oB;(((((H(18,2,((m(3,((((((((I=is.prototype,I).G=function(U){return"string"===typeof U?this.uP.getElementById(U):U},I.getElementsByTagName=function(U,Z){return(Z||this.uP).getElementsByTagName(String(U))},I).createElement=function(U,Z,G){return(G=(Z=this.uP,String)(U),"application/xhtml+xml")===Z.contentType&&(G=G.toLowerCase()),Z.createElement(G)},I).createTextNode=function(U){return this.uP.createTextNode(String(U))},I).appendChild=function(U,Z){U.appendChild(Z)},I).append=function(U,Z){JE(false,arguments,U,9==U.nodeType?U:U.ownerDocument||U.document,0,1,null)},I).canHaveChildren=function(U){if(1!=U.nodeType)return false;switch(U.tagName){case "APPLET":case "AREA":case "BASE":case "BR":case "COL":case "COMMAND":case "EMBED":case "FRAME":case "HR":case "IMG":case "INPUT":case "IFRAME":case "ISINDEX":case "KEYGEN":case "LINK":case "NOFRAMES":case "NOSCRIPT":case "META":case "OBJECT":case "PARAM":case "SCRIPT":case "SOURCE":case "STYLE":case "TRACK":case "WBR":return false}return true},I.removeNode=Gq,I).contains=function(U,Z){if(!U||!Z)return false;if(U.contains&&1==Z.nodeType)return U==Z||U.contains(Z);if("undefined"!=typeof U.compareDocumentPosition)return U==Z||!!(U.compareDocumentPosition(Z)&16);for(;Z&&U!=Z;)Z=Z.parentNode;return Z==U},aI)),aI).prototype.Zw=0,aI.prototype.Yt="",Go),p0),I=Go.prototype,I).Dw=aI.tU(),I).G=function(){return this.m},I.getParent=function(){return this.h},I).VS=function(U){if(this.h&&this.h!=U)throw Error("Method not supported");Go.u.VS.call(this,U)},I).P=function(){(this.h=this.ZB=this.m=((((this.zr&&this.K(),this.R)&&(OB(" ",true,50,this.R),delete this.R),O)(30,function(U){OB(" ",true,6,U)},this),!this.xt&&this.m)&&Gq(this.m),this.pX=null),Go.u.P).call(this)},I.K=function(){O(14,function(U){U.zr&&U.K()},this),this.R&&aB(null,29,true,0,this.R),this.zr=false},I).removeChild=function(U,Z,G,D,J,B,V,h,N,f,Q,K){if(U&&("string"===typeof U?K=U:((J=U.lP)||(V=U.Dw,G=U,f=V.Yt+":"+(V.Zw++).toString(36),J=G.lP=f),K=J),h=K,this.pX&&h?(B=this.pX,D=(null!==B&&h in B?B[h]:void 0)||null):D=null,U=D,h&&U)){if((Q=(g(U,(N=this.pX,h in N&&delete N[h],6),1,this.ZB),Z&&(U.K(),U.m&&Gq(U.m)),U),null)==Q)throw Error("Unable to set parent component");(Q.h=null,Go.u.VS).call(Q,null)}if(!U)throw Error("Child is not in parent component");return U};var H9,mD={button:"pressed",checkbox:((I=(m(18,d),d.prototype),I).I=function(U,Z,G,D,J,B){if(B=Z.G())this.kh||(J=this.WY(),J.replace(/\\xa0|\\s/g," "),this.kh={1:J+"-disabled",2:J+"-hover",4:J+"-active",8:J+"-selected",16:J+"-checked",32:J+"-focused",64:J+"-open"}),(D=this.kh[U])&&this.Fi(D,Z,G),this.QS(B,U,G)},I.I1=function(U){return U.G()},I.QS=function(U,Z,G,D,J,B,V){(J=U.getAttribute((D=(H9||(H9={1:"disabled",8:"selected",16:"checked",64:"expanded"}),H9)[Z],"role"))||null)?(V=mD[J]||D,B="checked"==D||"selected"==D?V:D):B=D,B&&Ae(4,8,"busy","live",U,B,G)},"checked"),menuitem:"selected",menuitemcheckbox:"checked",menuitemradio:"checked",radio:"checked",tab:"selected",treeitem:"selected"},N9=(m(16,(H(50,2,fl,(I.Fi=((I.WY=function(){return"goog-control"},I).eI=function(U,Z,G,D,J,B){if(U.vY&32&&(J=U.I1())){if(!Z&&U.C&32){try{J.blur()}catch(V){}U.C&32&&(Y(8,0,4,U)&&U.setActive(false),Y(7,0,32,U)&&m(8,1,false,U,32)&&U.I(false,32))}if(D=J.hasAttribute("tabindex"))G=J.tabIndex,D="number"===typeof G&&0<=G&&32768>G;D!=Z&&(B=J,Z?B.tabIndex=0:(B.tabIndex=-1,B.removeAttribute("tabIndex")))}},function(U,Z,G,D){(D=Z.G?Z.G():Z)&&(G?Kl:kd)(D,[U])}),d)),fl)),fl.prototype.QS=function(U,Z,G){switch(Z){case 8:case 16:Ae(4,3,"busy","live",U,"pressed",G);break;default:case 64:case 1:fl.u.QS.call(this,U,Z,G)}},{});if(((((((((I=(H(58,2,F,(fl.prototype.WY=function(){return"goog-button"},Go)),F).prototype,I.Fi=function(U,Z){U?Z&&(this.v?0<=X(1,12,this.v,Z)||this.v.push(Z):this.v=[Z],this.V.Fi(Z,this,true)):Z&&this.v&&g(Z,8,1,this.v)&&(0==this.v.length&&(this.v=null),this.V.Fi(Z,this,false))},I.tW=true,I.O9=255,I).C=0,I.P=function(){(delete (F.u.P.call(this),this.qD&&(OB(" ",true,38,this.qD),delete this.qD),this).V,this).v=null},I.uB=0,I).vY=39,I.v=null,I).K=function(){((F.u.K.call(this),this.qD)&&this.qD.detach(),this.isVisible()&&this.isEnabled())&&this.V.eI(this,false)},I).I1=function(){return this.V.I1(this)},I).isVisible=function(){return this.tW},I).isEnabled=function(){return!(this.C&1)},I).isActive=function(){return!!(this.C&4)},I.setActive=function(U){m(11,1,U,this,4)&&this.I(U,4)},I.getState=function(){return this.C},I.I=function(U,Z,G,D,J,B){G||1!=Z?this.vY&Z&&U!=!!(this.C&Z)&&(this.V.I(Z,this,U),this.C=U?(J=this.C,-1-~J-(~J^Z)+(~J|Z)):this.C&~Z):(B=!U,D=this.getParent(),D&&"function"==typeof D.isEnabled&&!D.isEnabled()||!m(9,1,!B,this,1)||(B||(this.setActive(false),m(10,1,false,this,2)&&this.I(false,2)),this.isVisible()&&this.V.eI(this,B),this.I(!B,1,true)))},"function")!==typeof F)throw Error("Invalid component class "+F);if("function"!==typeof d)throw Error("Invalid renderer class "+d);var FV=Bo(3,F),us={passive:!(y("goog-button",function(){return new Dz(null)},(H(42,2,Dz,(m(17,(H(18,(y("goog-control",function(){return new F(null)},(N9[FV]=d,17)),2),M9,fl),M9)),M9.prototype.eI=function(){},M9.prototype.QS=function(){},M9.prototype.I=function(U,Z,G,D){(M9.u.I.call(this,U,Z,G),(D=Z.G())&&1==U)&&(D.disabled=G)},F)),Dz.prototype.P=function(){delete (Dz.u.P.call(this),delete this.mP,this).bB},16)),0),capture:true},Y4=a.requestIdleCallback?function(U){requestIdleCallback(function(){U()},{timeout:4})}:a.setImmediate?function(U){setImmediate(U)}:function(U){setTimeout(U,0)},sB=String.fromCharCode(105,110,116,101,103,67,104,101,99,107,66,121,112,97,115,115),K0=[],ys=[],bM=((E.prototype.U9=false,E.prototype.Ly=void 0,E.prototype).o1="toString",[]),jQ=[],vo=(E.prototype.eH=void 0,[]),rD={},SQ=[],Ho=[],c9=[],f0=((nl,function(){})(v9),U0,gO,I=E.prototype,rD).constructor,VV=(I.qp=function(U,Z,G,D){return Ae.call(this,4,12,U,Z,G,D)},I.mH=function(U,Z,G,D,J,B){return p.call(this,U,5,Z,G,D,J,B)},I.PR=function(U,Z,G,D,J,B,V,h,N){return Bo.call(this,52,U,Z,G,D,J,B,V,h,N)},I.i=(window.performance||{}).now?function(){return this.py+window.performance.now()}:function(){return+new Date},(I.If=function(U,Z,G,D,J,B,V,h,N){return Po.call(this,3,U,Z,G,D,J,B,V,h,N)},I.vR=0,I).cY=(E.prototype.L="create",I.Cy=function(){return dD.call(this,3,7,16)},function(){return aB.call(this,null,5)}),void 0);(E.prototype.s=function(U,Z){return U=(VV=(Z={},function(){return U==Z?98:45}),{}),function(G,D,J,B,V,h,N,f,Q,K,q,z,v,d,C,n,x,S,k,q9,R,T,A,c,w,Z4,M,W,wD){d=U,U=Z;try{if(q=G[0],q==c9){w=G[1];try{for(v=(J=atob((h=0,w)),[]),T=0;T<J.length;T++)c=J.charCodeAt(T),255<c&&(v[h++]=-255-2*~c+(~c&255)+2*(~c|255),c>>=8),v[h++]=c;P(this,10,((this.U=v,this).g=this.U.length<<3,[0,0,0]))}catch(lM){Nb(12,lM,this,17);return}xd(2048,this,8001,false)}else if(q==jQ)G[1].push(L(this,352),L(this,399).length,L(this,332).length,L(this,170).length),P(this,235,G[2]),this.Y[314]&&XV(0,this,8001,104,L(this,314));else{if(q==SQ){this.D=(V=(wD=r((L((B=G[2],this),332).length|0)+2,2),this.D),this);try{W=L(this,384),0<W.length&&e(r(W.length,2).concat(W),this,332,15),e(r(this.Tr,1),this,332,104),e(r(this[SQ].length,1),this,332),Q=0,Q-=(k=L(this,332).length,2*~(k&5)- -24+3*(k|-6)-(~k|5)),A=L(this,170),Q+=L(this,421)&2047,4<A.length&&(Q-=(q9=A.length,5+(~q9^3)-2*(~q9|3))),0<Q&&e(r(Q,2).concat(v9(Q)),this,332,10),4<A.length&&e(r(A.length,2).concat(A),this,332,153)}finally{this.D=V}if(R=(((D=v9(2).concat(L(this,332)),D)[1]=D[0]^3,D)[3]=(N=D[1],f=wD[0],-(N&f)-1-~(N|f)),D[4]=D[1]^wD[1],this).R1(D))R="!"+R;else for(R="",x=0;x<D.length;x++)S=D[x][this.o1](16),1==S.length&&(S="0"+S),R+=S;return L(this,((L(this,(P(this,352,(K=R,B.shift())),399)).length=B.shift(),L)(this,332).length=B.shift(),170)).length=B.shift(),K}if(q==vo)XV(0,this,G[2],104,G[1]);else{if(q==K0)return XV(0,this,8001,104,G[1]);if(q==bM){if(M=L(this,374),C="undefined"!=typeof Symbol&&Symbol.iterator&&M[Symbol.iterator])n=C.call(M);else if("number"==typeof M.length)n={next:t(3,M,0)};else throw Error(String(M)+" is not an iterable or ArrayLike");for(Z4=n.next();!Z4.done;Z4=n.next()){z=Z4.value;try{z()}catch(lM){}}M.length=0}}}}finally{U=d}}}(),E).prototype.R1=function(U,Z,G,D,J){return ${'$'}4.call(this,8192,U,20,Z,G,D,J)};var Yd,Ll=((E.prototype[ys]=[0,0,1,1,0,1,1],E).prototype.BR=0,E.prototype.iB=0,/./),tE=c9.pop.bind(E.prototype[jQ]),dO=((Yd=(Ll[E.prototype.o1]=tE,OB)(" ",E.prototype.L,16,{get:tE}),E.prototype).dd=void 0,function(U,Z){return(Z=Mb("bg","error",null))&&1===U.eval(Z.createScript("1"))?function(G){return Z.createScript(G)}:function(G){return""+G}})(a);return(function(U){return E.prototype.dd=U,Vs});}).call(this);'].join('\n')))(J)(Z.substr(0,Q),D,U,N)[0];return}catch(u){V="FNL"+u}q=x(28,V,8,D)[0]},G),function(h){return q?q(h):"FNL~"})]};}).call(this);</script><div id="program" program-data="qYvk4VJTw7iwep63bsAdcXKsD4ybzyzu9M0jAl47adot3riRTiIxuPCl1WYbM6Ajvm1+vqG3lIxsiB3B71db2p6VMl6LsHaDoVIN7+0I7EG/IUefjeiLs/Ur3nYGlIttQeS+lnnYn3mLBu0s8GY2peyjEn2bxNVqwb8gdZ3OfQ/9gKoSkWZCak+Wrl9Ly6gVBloybnUejrCxKnJ5nqgKS06M+E/JLm8uk1dn7KcB9BffJi77U1FQTmEcje/DHJhi5BpgdsQ4wIQ7OoXlksgywo3RRRnt/KTqw+nnb4+MV/6A1cU+NVlXGvkz7/0wGXFVlmO8h9scqPjP/u2rNjuE7c6Ojyh44tgLpTSZVPYGLptuez2epSy/Va/pxpD3p5JW1gQlMJEmKTN6RtKq3LLcG+ByNFkHxU8ldDCBXEedrGyvSl44rqG+YcIJ09xxFPtMtASl4s6ZYI/20oX6q+/JGTMbTdHVYZUFAhwX+sYHVNTsre05lTJ19mAWpp0BQQT3NikPO3t0dtex/BDLiwmoHO/HEDnIqJQJrfGQbbcp4xP32mwTDgivuDPZFE9oAIz7gyvU6hxeDEl0z6KS7oIBREz+GhnquD74DYUzvFx46hT8knEwiye+TNo6+FzJNHhJdFw96H54Gfkxa2dyZtRO17ucdzi5tWHJWEeNGHwRWN9gnS1YKC9qf4uosp3FscY3fL1jESJg3P7ywgs6ttEwLhTSZDpKX1owkEZr76JSAWabtRSsO/csZ1jTxr9D6487GvL5u+rpyZlWLzqEGzsvr7qyA+wYxmSqs9Y19Pvtr4LAadAXYv7PKRXAE5uqgjPZ132de4qhfDpBRkLsM1u/2uSeSAh1BejSR2WeYCdCW6nVhB6bEaUgEZqBOUr1D68iKNscAQTrl0v274SudjIZsfLjUSp8ebwB9mJfMxQws8UDRI1Y4vVRjGYrI4QBNsLaAGpAsK2/DIJgJVriwp+CVLgkk2hREfpLdr3OCkplXGqc7uJumM4NxHzOKqEhtjQewVHM3Mxk7JDcvipAjgJLn9i6Jxq9WHpOXM3dzOYciRiRa0bl6qd0ZG8FrMLzvy6xBOWUygpop6o6nKfuR+9Qk1Jc0AI3OCZ9wYvFpnuU3J+uk4Lm5ua4vADd7JWQ+R50F0ChFkGXZ6Bl4nygcqrU8hzzhAFLspo5/DjAVtIpg5+Kh8kGGJ9KHc0RTVnowESwFtnDNZJ2OtjTBMxPV/YYp/PBLd9qSHvzbPBbMkDoovo2SBqPYV3JATNrjQO5FGFGZbJxN0f8HtMjLrUZOKdI8DXwDJW8p4+Z0krCizFNBOylHxHnSW27gppqpNs/SHKsxmzsQlGzUqFY/awLDEPx3mx+kWtHIKfPniRwyuvQelbwKLgv1/LvWfkYKuk/zlXqr0vEWJ7LfDOH+CELkH7ZoUMPjWfCPUv+BaZKez3iohr2Llv3Ftg7QPPLG+Z93nzIW/Y2QBmPMYOh7gAMjauoi2rXpWMdtH53K/Wl7tGVza/N5gabh0u0g5aymKM45VtDG+Rpz+88JdlO05s6QCwjnfFOWwbjRqx3ktsNUeoP9tmEHcLWLheYQn2X4zZG4Qk+GLAuA1jExC19kjoWjHTcrGW7R5wb8exok64F2arwZneN+ZjDKjZXtRnR8bfMr+ff2HwHMn5lxZ/maN7+H0QZTQyinfE9gtUqaVcoy6Zp2hR6lZi3P5hR9UOiPRJ2cVAtR7gjMn4rIV7URbNS7wWJu2yDxFlgN8Rjz0ZNFnhe4yv/g7npVpuGLquiM4CQtT6AsAA9dmpmnttGQcu52VAL6VNq1Lf6JZSYjcx/u4HUiJB0EKMD0KoLi2Jpqu6XpQatQE4VVRF9IvE6gEqfDvPOyH9AeeNAApNxsAeHx7b2dsfBhldL6YkTwrqAoZQH0JxsjJm7eOhPHMupQN4ccDHv0U3xztoep+812Whb07/yxLk1xzKK+G76SXySH7/AsvPPC+AQueEdn/0H+kczQCHktrWS5lT9x3T4gmSCk5hv56spSuhpTF99FP+Qo1ijV2zLT0Kf09Ob912rjxTrUUi+gGpQu8NHrVdl6Uwjy8qIPNTWOGFGZL4tXoB2QItPLK4K/TuWKuhJqAfYtPG/6+KSYGQeijUDrZuvBCofhOVLxFfUHcsIAE2yvZ7QeY4CkDoxE4U22EbWqkzjCZqNUfsmWhgE/BZyzHurZ/SJJ6U2QWYqTBRR/rx4txaO+L5Zqr6d5rKDNFihGTe5mbu4btdWQFpenzoNx8EO4BvkAAt2c61mSnChvYby3cm8Ktap7eIRCkN2bH+mTdktYwbcXxeR8+f86UPnJkvmbrlD5UXWpc0JafZqbb7hRREFrKbBmOr7vEvij/R+JZ1tpVhyDEdpJ8cDtkkAK+o+ZOvfsCq/hYrrAm5jrAOtTXIUZyKWHHwjXLJleMZclZ2wReupmJnf2LQxsLk+wsFk0LxeJrbwhbLMKq/fhsB0lXJCpETxiiHx7H0TfxJklHUjwdx0Qcl+rbYp6xmD+5ogiekngLeJ2FFOtWbDmbkZcIhlduIaWJZYSr92sM25kLsss8m1YLtKkmGNW8BvGZKVFy1ei9nqKrF28Gyrb2FzMa1ARDVaKTjBMVx6sAYUTdihan3+l/4BTWuvAXyYpihi18o1tQMUzpNkzVPGIRKo8w1CGsb5rdfba14wnHMO4QRpJCFTnpkcB1TYsOQ+2/7K7L07m85UmSfJHaocceDVzUUmxXPDHjtZbDMweKETcxFnYSR86UKxe26jUfscpW+UQAplevg08jJD126biEqFeKMLi3yZDYWy2RpBL2deDnVuSz6rCgyPYe+OyF2mgH3Dm7T5mojZp0sKsnRCL+9+ORBPEAa+s3ttt56dvHJPdXcwA1HEbh5O0Id6SkcKdrPm/wkBhJgVOGmgsDhxqEhnKUF4GCVlvoRRY5zRnNhrri7CYvdXvaOR820MquMIw1VrUrwMG672JggFDfbSuCwuJyajIccEblwNp6qOYuCx7tcyA/I2JE0RFRqimaNwQKEE53+1SbB67DY4aH4kymHhgg9ynmcjuFGZBxq5DFcMj/FNhdYRah+PRryad6PlLmlnZXfsc9AS84eE2QwbVAmz0iOtaSWzJ59BowRAjlGWDfa96f1VOo7SamHzbeDvh/n+Zc1S1aZegCr7lxpNDVIvLNNdt2dB0wi8mW1iL8XkInBtVoiNM9qrT1fy6hEbsvaUVijmUpBzHcRHO+T4gdOTuuJDf/crswTXGH/k5ji4sxqM+ZjyVYwOkkAIy/tJf9s/N+UoCW8ztRaGNvtPIKK2Ai2OD1X69PvBtqVZ4jVfPS0JBEaeDzgiV7CPrc2ogpVF7pO/V3dHipa8T/u3KBCixMaKkFkk2kpQgTQ0V8aQySscEDeZbmtcraNXSVLCl6/A/EI6BN859rxL3i0dzIS22VWptE/NsNAqJXFGWMR8opZPufgKgFpVH1Lx8gghUvxqHvoC3lclUQxX5GNnzurhEGYnN1hKQATPP9GEDAyKW451C8nyKQKs9/KGdVpNbOcx24pJaCIiMMyGKm83p2PVQdo99sHWXgw0rvNGTo7OzimG7d1VeImYI2ymSgQHY0LKdV6DiyEHe7LKjrNxP6wV29lqltjif+qmold1I6XnSQrpOWcP6v6IZ3ANbND/ocdG4UAGs9pDtkoZxVEG+FfjG+tNoxsXlPAjIGGsXviRQ5Moz2r1Fp3ygnpTUecRBhb/9yErhpwvQ7/vw5E7o6/xL28681NhK9WQ18Uvicmskahwbcj6anYdrjjXjF/AHuioyh6RvIYuXWs6Vfp0thq0ke1whv6Pr/egpkFd/Y7tRllwknpkHWx1idOKuIUxVHcx0fHphyLJt+UzKaaNlYrUpZ2QeGxmNacWKS2bJyO4kL41s3nctp/9RmhLoD9wHMhRr9GjHRwxBixq/j12mtk1Op217O/2S4QP7hiSLeT/Kf70w+L8OeUT0n9GsfVBD2rLX7CvR8W+7Cda0Kjm8xzh58FIluLCkBpj3QzE11FvbBunQxpGwghetTUGBrJZkclCEjxbFfOa7+wCwYONq30ZehBtpR+4u5MFsHi6tnszu9p1n9IhIFukE//RDgUjNbfN9zrlaWSJ0+e38BplKMR7E//A8B1MkHXEkhWoCBSDXpC+o3phI7mxN3xOsauSFSv/Allch6EO8ZKB4HPX48WbfGDA9bbv9mwK1jkdNQZoidtXn6KDZ8b8q46XlPuU4HbcysOp2obL3Ky7LrKFyciCP66zic/EX6twD/uB13IM7zvChRLQl/wycyYNT0z/mooSFeW6dqJ3UP5F8aJoabk4jphl8tsnMNZx63+suQOIWjZrvENGJ3DC0dQvfwKbM7NVLeISA4wM+wT54Hayau6Yxc8WZDu8dAetgHhmgVHNP0kpglulsO87StRrYSlSCgmZSX6XAgFXVemQtzys3QZJN9f4CQ4O5oDLMyabg1HM0rqJWwwb1xIu3jY7pNoixRjOEDLZayvCrDmEZthLi0Vz0g6HUMS5mAjYPbdwdLW7OZPpAGt8yKW2wY6LOmMtkFjlBvPhZl+MW9Tw0+Vs1E91zfg6VQijKs9Uw6S4OvUWOXgVt43mdFF5tyOYIfi9tj3csWlA8Dj4xx4uXZac88t3irLiWfAuvDGqBfYdIMj9vasQaxT2fl3e/PFOj1iOvwwhN+IANDsJ/XEVx5N33nyuXZYzSqidlYAbQntI8A33z/YN+kxIr5NNK02Ecxzt/IXnNerQV6XIZsrv9xZtRQyX6ToqaCpTHQgCyHYo5lC9WCmbE623S8IU6OVbN++sNJ4fw8iOLPLfl5OQbBfc4uE8Ax+iWnekqNL2VP0DBaioeHdw+V7J4+ojXMNvmsx187KQMqBUz3EGikpRhrtm3fAytjZ3JfGW0Zi/FSRaCkLBeKg5Nggd62twOu1njhx6SjBPsSz9mskzDjD9/i/NJQt/guIbZ2/65CseGftZdMXlYklC8itIXTTpTfegHD0CwqsQZxYgQUU+Q3fLOVxBQrJlxSCdEpfp2QXWhsjX+DAJJOQLd8vJwVw2aSq2OoFJ+rUdCOLSYf7NWBo3jTc9/GKmwff4F1tTHqpU1TjkNGVlOXnsI/MwdwbnZh3N38iMen4LFCQCgbRgxu0iCrLfKxCE4lPCpRdoxezV74R+Uv4C1pdgLuTshy7sxp9lG5oGhp/3nSJ/G+H/69Hp4rwD3uJq0MLh8ShXQdLRxD/MU6AqVkBT6g8flVUXvWm6LrtFeDxoC5KviATl+RLhDFWhKRkyNxGW7QQz0R2XGWgd9NYXVycv/AVHawGLoEPVDi630DL+WCydraB8tDSaGWpAbaihWyY7KKxKu/DsSDwck2f/TrWAmpmE5L4H6xKTz51kqiDTVqvwZiTU/KpKa+rzxDUEoqPbDwW/Y9q/VtY44rbOAtVHAgGD3QeTEyTdx9qfMtM7VpH0qNDfKqF/lbPKRmS79GFljbgceODafCTcCmnnhX/3jIwtNlcp7apkqTxuhUY3vRrxOgHbmHHG6riFa9RwyLc6IDmdMqz3/zJ0DMrrJvgnGDxbfjcAbIUWWVmoxgtXwzXoGr2OCbwrYrFL0O1gXkOS6d6sbLPIsKxGcEj56MHpJkB1BDpTtYH5nazxwQseS82YmGKpwzudLPAx/fGQL/ABS9VC9AS8VxZc73xi9ruZwyIgTKOCVLGQ/dVtp7/pss2+/bTc6LP6mmiCv0z+fjKn5OxdBUT767LAWWusLDYf/RPjWJSMJCYr6aDm8a/8qKzfoFFyWZTNKZXcN//c9KARTRqXgFLZryC6ckR8F/I3mxxIg63Bora0zYx79wgxWLrpRDKuLBvRW8wYdqfDekWOVmK7SHQmT35vNjAQ+ws6MEvwBSlazeFkrcFGh76XSkZ/SarVUGEEgakKs3p3uUZZXU7UezGdLHOSr2FUdkaGkSPHU2ZPbyW823/CKBwFNt+rGDAiTIy8bNWKII6EK86+zpgFBbS2LIA1+5jYDICAUSzjKTaLVslO6Spkpk7t17TmGtAIC3QShwpTfc84bn+6ImE99ODqBNbvYoBc96ECLIcliN2RGp7rB6k0eb5MmmtOYHtJkNS50GKtrQDp4DVYv1sVzgN2oH2i2B1kEYfh2iXGoHgU0NJSqeuhZ7f9e8dMqX2Cs0TXQe5THKD2WvAEqsNEF+X5W2uO8l0nezTZt5/vF1IDx9Ke0osfPZN6J3v3PNe7lvKAbkTUGx+D629t8fGO2rLCPTZZfx2CSLbkihMXEHtWhzFJGXc7XEy4UWtYKZp5FFz+KVVHPvB54sjLpdGRM0Qxo1NefgGQY8y6S1Aj5MzbkG1yPO0cpsS0Znunf6BtORgvIj4Hxl8DvY/y10te78l15OjKxYXO6XjxJ+LL9clFhTXvESsv14r8Ar7JyAflVD2M4v9C7ZkUpiUH0xFfBnMfRSkTgreeUOTHTvBRJiHMiYE15nMO3s45/IzD5fvIOTTPU8Aaba2qTp8Jh1+7Q9BcH9yZL5BQa/UNqUJoLDXn+AVrrtdaJpKF3BSim5JD/XzbiYmi7MSk+dvySjgOZ9wIb2GAwj1VpQ0bHM6rXzKtPSOQqyyCmYgHsn82nG0o0Voup+iK1PdE1UKtUNUC0gRNW3WtLKLU8FfPEz3bS5p9jUjLe5izkUcaVH0XalrSzETRcle8VUyH+CF6SiY/fjPfagKuoTAiyISeev8xBloV10m8m3y7HMRR1lkVmfv/J1MPrVHInZBovxFHiMJiJpxwh7X2AjrmGXWvkqobWLmjw87rM/llK4+yWxCyzVzRDqEu0/vqFF/8JRcoup0Wf2eH3oD5dW39eFY1uBG0L6apMZxc3Z8oNNOMsDPvfF1CZMD233qXWiOMpZ+9NtI43qrtkl9lxdZz3H9tTyuT6G6a4Vo1SfrdqdiA2IRdR0D9Vv/sf3Ap4wRqQO8Az4wcJOKb9zRhFHurwwqSzqRmHUpurODDFxeSoJn66+ILvNfrSFGdDUKX2Uv45Tiq1D2edjUeBuiZLo+T/C2RYDPwHIHb6BtWr0Nmkz8HdcC+Bb1ft8WqtkEVMg3POv4ZSdGjPURVlFUk5RdYCRpGJjA0KMFbvKsgZoNGanXOYAfm/XVLOF40uCNw8CH5q+tK1w6dzi25A/FxBsjyDoVfY2QvrI/OdcqCvtoto511EOjNO5dNLfqPQnXFI1nVwAQ45UdghgvY1Of4rBAJ5m43rPf8CfUH0FBiIRSAM3Lvun7ik30NzQ8w7S7/uxOu+qsoDeXMB6UzbaDbycnpOXMlDTn96zUOn28/g689KJLlxcO4cOTJH/XDCes/ewRNgJFnEunH0HkBw4FP/E4eGvc3ekvF5K3YQXIxiAkgJSQ/Ff+kEzCvClsk6FTwGjy1kxlW4qTsE2DgT6RemATCAFsOL83rdOSe3kalviRrkm0EnMmvGjB4EQ4daXg5SIFX7geZGZihM9307BSfbG1XAK7R5Xp/ouJiLv4NyW9h0Py1mRN0XYjPC2cA/V/XawLEbSKauUYi9gVJuUAqRaEnFtRg0csaSlColIwZfitV8o62Z0YwRaE/DmTWyenbzzEw+5cq1UlS5bQ6G5JzmswsEzLSPCOFJgw21K48KrbDHQyvEoImhU/iTJf1K6Vv/Rgz01PBQ+7SARkdhqL2JAjMDjiwnTy7oUwLGy7BVF222U1dEHVpKnIqk0PxnJk8DaAC0z9u7AAJ665SWmEiRL/rQWGuGOIsWYS1/y85M98zWb//KobhhAEMk5bZsIVky2gVMFpHezYmnakPI8t3rL/HuuQ04fHJVQorRwB6GNsz4qmah6BsMnpMnHS+x9IZHgFNyYS48Zh6XKIyUNkwFsMDq9i4nc43A9ySSEWcYiC6p9Gok+BJu+z3Q9bYG2Cz1Y1LoiY3cOC7JRnKETYiSQLYmZ9gL1W9bnj1N9l0oTEfM23shXOyIFPKg7ZJIZbvz6jv29iNQF4cJTgFOLH4nTQd2+mq0fAsn7O1cIN2mDfJNBNZxdbu5hs+y+WCQ0ME3ws0vM3f010wSFWPGwy9ncvd24g8GoLXPIKAtdGhs7CZf2gxl5N9cLmhaK/8H4xFfd+mn2tR6fRbJrOpLKt+Vf1eVmbQCdazw4UXiJnkSQ95Z6zicdTfajQxzQI7lXCdVFpsJSHG22L38vOosq0qzrq7luvbFZJ7lB8Bh1GnrNOl0+5Zc0rhuop23g6k4xySXRmA8kZIRvgbaWe8GbmxiIgsPzA+4+Y0N6hz2JfOugoHDaWts/xl8ToEna60/1Cr5Cm3NXaqLb5R9YTgrHRNLE7Qdfu8x/S88JA1Dx6bxYlRuEGLuzBBnxELNblvJWpwmB1XzjbLHc579j6plfkgNNds7UXbzC1rYhm6hLm/lQ7MTcAbAzeVri2AoOgxyc0wxsYB4KvKy6/azKvapBK+NEl4L7rsoNtt76GbR+HNrULXA72xx+DPMISEPlY3Si9uF2VR3K8uqjmTn3oxVK/wbxqYwTJAjNtHdw7M49YE+2sXr5KpWezVXw4G4QyRIicrxv293uFNPds8T431WwDDvP2bButkQtGwnpQXVS3XRjyCCY4P6ahCmbhQwF7rawEVMp6NYDvK8R2ZPXMtYN1qjAKybtEgTg3rFlgA0hpT0HRCLJpZc4xDPEkxNCLqvlMWDvS+UTVdWv+uDjGfVfkemjtgmewOSrDyrSUOkV09R3klgKX3rQZNDMy8wz5eiYWc5D8BM7YtCdqDsz/tbLKRIC0r1FYvffeEGwcP/KYEXXt69SzlNnPrdQG7ctzc33l81m27o9j2/jXQ7wqbgWcG8n9GHE3IDeCz1o4+VbQPV7j0vkUeUCTHaEgFz1vHAAhg86B0Ywfc7yt7dQ/YW3xg6ZUFGEf3hLmxvZQxkU8IlpyU36DfZns3wtc1kljnq3gSZXy5WQQUCrjS9RgBum1//4yepdr5b9MEJdf5IY0AwJLCKhUj732R9Y/1PXM5GLhvS/sM+z5fXPz6kqSaZLk7swCD8uSpTmUuTEt6qLKoSL7eId/Unogpn8jAoNjup74ZKnJuSOLtHvsbU7Cy7kBHIgUdbv/aQy2grnzwmNNNrM/hzGD1aLiCvwQv8Q7bsJyTS9I+cHoDThYSDXnv2J+/VFVIv4d1PSeYrLx8CwdLhpQdRO2IvLuMJXUoHS4y9OrbF3FIU4+fM+wJ2+mVa5GwoqxsazVcMqSxPajwp0KqZO1QPn64Ng+6DslEuNYfL5IlVCzHvF61k04u07WtqU+Rr4zjyc8tN6hnO8B24G0aaYgcRamVbhRZbB4FhiPbfF+d3gl87nQiJVpThhlKQ/BpdYp/pHTDEtT5LDp36CM38Jt6VU8KfzEk1HouwsF51tqlF4bn3PSMbK6bO3cL8B/X5BsjUXRkkH5nWKmVnVctG4VxG7cYJVhYhZg600geDo0LAUzFRvuxJ/1oZ83aQlN51fuJNJr/C2VL7miAnwbkaR8jybpiIWni1gTUB9F6TbwhshyORH/01fjhpmVtfmVv+Z1qEyf/jToJe8j3S6ugTyFoblBtEEGYdqLKFcHyr5J2e8dv7kVh2XNggD+e1RruTvbBmYsLdCwWflb6EYsuFvOc2BiaLMus9KeC1iYtZK4Q7EMJVc8o8wv7TFCKocwKwzY9mxlglV+WhGa70ltUNTojnzo4RngoPdZgwCerA2N6rzUK/NqgN3Gs8xt2/7ZhyV3Nx5UX/hiHFa4zuw16NLYDwm4hftE8s9qArNYF0tn50pbHzCQxp9QrUfRkKLwSDUh2HB3yUG5WgjP9zx6y/gayBHi0LIVRcMVe51zC3XYoz2JjF7jU2bDyoE+aTvwuqqrY3bfPpUtwdvFUzqQgiwhXMVjGtjfPP2Rfty54eHBHFLkc1qlPgMqE19lritsgv5a/rInpXpPcDXthuYvYdxhuSdTSbb0FRwQjGNBqEYEgC8DhgSIP6eP+xrSw6I3lnqeJ2BJ9diCIA9mvN4KwAbNTOB4fWr25GHLGjzyY9+69bOyuldzLTC0zj3nC147UiavPHMN3huKJCc6JOse80Xofljh2mKmjJCeXPI3Fgo+n8Dtn8+lrpCZaPXhi8SM891nW0Wfr0Q3VJ16IoMsbvoc5GFtjfgDxJAw0RPV87T0VIRTmFQzBR/XR1q6Lj+Bh5baOkz9nvCefg57iNSqxd2LEdXirLLN6pdY6Xq/Y4UaXy5DJEGXlRx2uD+FcYQd25k4iK2k3VuXJxEAH9VL54KOFHZlRq7jQ1m/Q0z/Tzd/nogTbf+h0CBQrRfOADaQSrPJTofZb6j+9FjR3nSLxqUfrd8N6HfEwyyJPcDqpFJzQC0u/YLLdPhIfvNr+aDX8dcgilVu85njUUeSHAAwBoZ7gKVB7EwbdAXPoA+sw/2DdlcejbcPnWOVlx9mK20O8WzvOVV+cKldiiFUPrD49R9MU1W8pki7wVjFQZ1Ek8Yl4ylsg05XLDmi/tUlI3CDT5UtxdbWPOjl6nbseQSyNM8S1tWbFFgqOTQhyjUfM8utIqR0njrTrpnL/Pui32nvTeGa0BAlkAnet6aLY288eU+UVhLEa5Q9VZWHyfuZqP9j962xfTUzbV0evud5F1MX0SAQQKREjKdgtaK99zlubPoXr0bbNkFyMmGlGCRTuaAsnhDjM/GzX1gl131cHULcnXE5NG9JK7UEF11W9Bat38DnpucnihAWrgfliJlcMt96MYnJJJZDmHk1q5tyn9KdkVGEPTw4IfwYreXVaJ0lYNeJr71HbqmqyYt5X5haziVtuD8YbHiG25xv0T+Gnv2HyRODVqwy6VmjJXRaOnoGPpArTlAh03uXINnMpr7FM9k9lbh0P+9wxx6rWV58l1ezgMvGUwvMmrxPlJ4bFOeaF2sBGJhzmFmpKnA4an7QZ23zI8QpDfcJumDuSJLV3blTizBBX2m4pojUt7LLVp5TkDXXl8qkPUZKUlKRhLAh2WTkCbRKm7U0byASCXxWNvei8BDBvWJeR7FmjM/u7ty2C3HiEwUg14bLd2CmDsTG9Us0Xjzg3hEE4EkqZq53G8kYAIKc+x205OCC7blslT+J5ytygVNxmUwooBy6ULwtVdpnV4rdC1MNvNXu/tY7keePwrvoQw5rCXwOfaw1j5kFN5feZrOJfUSyllqnloSKt4IEFOYJB+363brb85Vt59TJJKGOv9zJcQRwfPcte7YE3F7yUMpYLW9XBoTGpfz9+3JL5B8FVcWKK5qnjbdurazT5dfcFUa+vAv37+6+5dWUinqIs2+sMZEVaC+ezKHlzxavTJ/a2Fg1sjYB6qvpagOSepLOb1CXRDAaHbGGgyU+S5nUsww8UTXvRdHxeQ4P9KQUp6VLYxt8T0MwtOfXeKDhTzMEOyuHY/w8ib41GJEeAdCFs11SmiMC/o7F4VE/q8Hhg76UR3IqmE+tapsvyNKk224LyrWyHQ97zISFv0YicA+YaQbU0LsO8PiSjAc7m4fkmeqXcvzOW7KFV/E0IzsI9a4922x7KktXf1HQnLF3q+UodSMPTxGdS780bESHATn6r/g9LlXpG124/BZdLL1kIAG9sXcksCL2IC1IR139Hph7RHomv7rFn5GregMhGp+XXrFoc1syDdu6pWn/Nc6YepsgQrhKSlB7mT3VuGMOHXd+S8cYX8alMZd8b1cemDWFAEvw0C659boHwAYQg+pRpA6pRlRG84gJ1AZyaNRq6abbCiEINYrssi6iyIbOIee6paJEp9Uqi1SnUIDiniKF69ATYhwcjNek59j6PEdqtvKkM0l/xIyT8t31CSY8md3K79UqNW3AhuHhV946SzUbw2/kck3ooV9mh86E+9P4WoUxvBYHrk2gWnMXnjOteRqjz7c3pCcqxGM//6NfWNN9h7TMFLqmkwLFq5iJMciejE7z4SYfnvK7qyMkFVeJ0RkvV0FV4OY6kRw3IOo0PXJWLxwAGvOocjzvL/gEhYifz6ehglX7ZOb5FC5iaR7GucxUbaWh1JX6QFJOBXOFw7qOqoVHrenhl9EVG7Z45L6D9bATSEOaRmaS9sOOMHNgDhpolDSdlmJMC5MJjKIj377XfmgvQZGW6670EhilajmiLqh0rNqa5jEt7AiKlRbr5bPK+DssH99Xxdx48ne3WZOadKT/U7QjwLSq362HVNgv3yKXgs3kXsE2VuqGr/+H3MiRtLTwwngdz3Mc2VQcWCg1EosMibxXZqNvK7Pu2nnJdvSLDKqLezYwOWSqmZ9VAlDdmNvGTfknOhvVjt+JQlQ4UAjYLvCheKd+kstrzfPBHNPaZDMv52YVXMMnXKybuCwZ0QuniBauCXuvpWbHEurdrzmgMDdMHgB1WN9mAxnkrzXge/EcJdai3AQUkYxvICvaJZH6XxrVBwyzHlfRdbA3Ix4heDAr38itLESpLih0FHxcVL++PnOfTvmkC960Alb3jPdrPa3n9ZjFhBqv2GZ1vrCOlHhsroxm9qJtmHOpXd75p+tu8qILWaSxbEh/CptexXMwhYx2lNOUT9XZapQg0jJsh8nUWX/9Uj98DiLcpqTpGHotgKZNejCf3NiozvmyXb7sLbH/sECITMrcyVEBGbU48xGggRGzkB0Zd/iqSi6CzEXsYZwgv/ADT1YqPtvJs4b4RD5Qi9J6iA6SAzfQP2zMt50xMdQz40UtTevJxkj6lQU0iT/fUUyjGBuPNc2/PyRbuVMrltWsqKvIA5x+hSWgIEDUAIuKwUe2D4wznDWftSgOUxBR15YSqw+lHtQC7k0NQ0b9lC/IKzo9MwaoaVOCwkWbgG0D6bw/kwVEmHXLfPBXjoMQjIQDF8bnpocehbXMhuS6sGZbhtswRai1EiHpGsIqEdAu/ktXlWQMG6cm653XhkvPaFCOYmmNE5AncU5SNe7RKLCyh0vbOF2SbjuHuj3XMAOwp9zNBK2IZWcK65IBz0FaDR3Vi5qnSwvoGfMJc++kd3vu56fJk+1oGZNymNjE9Eyr8ot/1YnSaWHTOLBySFUc6CKYpyio5aDM5toYtW8WW+a7zExjMgqu+B6aVJevQ1ybx5ZHUbJLOmYmeOcpoRIteCIDaNuxftgIgVYBSOTFksumsce5IILpiio3pSK79G7Ncs/tq3IcJVARzH3TKWgUq92CZo7hh6n7W8L1s1WFetVI9PlkmJ+iuqL/aceqmpTNgrMzWvuVeEjhOSL4GvlhQnF0jKgnmG0NkEvrUW+0F2ky6JhDEhfY2EWqxu5jcTmYoIER0s81LkJppxn5McN17nV+AaOBR/92DPnwM74LfVxY4Vrrck1C4SX9mFAIdwCz7QjPDx9a7BLBru2fdVCRLIWNKUjDgxHrBa6o7yyCXDV/xYZMIHOrzDWuRoZnZHpxnoj/fOQptB/X2BgXenMMvJNQE0J4RBkx8qHrF1jg2qywC9VJ0qhp8hrmh/voyfhe1//u705XS+V4U+/0wt028pbO8xJmbk4hgQ52z1q4BSp+iGJONPyLW1RBxASQgjilL9aMhfa+5tDPZGW+ydaVhSQy75N6AMWLLC/DDRvmVpoq5NTX/ZhoLHL07TJGy1/QrclzTioHmZv//S7NbZQzuRuOpsc70o9/iSTGQKB7nV6EDYW3tpoiueyd5FNoLxjwZZlg9GmnXlG4VNRj/doXrfQxsOA1eOHLlpzHgNraskDojIqFsYJzAENp1trYzwAeoRkFiBfHPm3WPEwOPTWuZmmgwuLp3GAuglwvFv0I2EwiWCMEwZIL8eZCpDiz8y7Gz7AO2v6AXGRGkzw6E01vyDmyzGqdmW+bST6cO8rEvEHXvyY3+g4/O4VRi6fuSD8yr5Frj1ap98thRbwgNFrJF9lGslYDs7CCU7qhzduJZSKhXt80KdkjriWR+BXvQfJxBQLRCqBLqrvSdeczxFBKQImofcj82UMrmy4gG3KHtOUGPSXddnDkWvHlTIAXa+bdiYtFwskmdzY9OCVnPGDlZ9ksai0FBRRvsJxcV8QhJoYT6LWP7+ic0BEAkOemheNR2+ORfnigvZDyLQXLHvBb9Uf9UVyyEySGtG8mnGfqEGh1ckSHgJjiHoObXHnEVKphv6E1p7jm5GmaigfvFTQtLBfG2/VjP4+NgPDGvJZtrPMr6/Pc7L/o00GnqcoY8L84yHBIKbxR2sKU/XCgFRBA4avwPHp6Q5qWqRfZ+OOi5+FA3MXXrm1lIdZpGC4mriO6vwIEHR0+O/q4uHQAsGhcNOBM4WfZi+C255k+zyLFdD4/0itaWMgFNZq02HLUf0rbdpsyFT7rIntKeTy51w+eJR9eK2GxOUglZzdKr+MhUoOV2y4W9KbQOTFkZtFsJn5SfwFrM11R8PMtPiS8q1t7MQkJKDeE/Kb5YrcP4xkZGvyaEfHbHeI8Kx/U2b8/a6MnCoONsUbvDT422vDId+b+D3DXbIiHqExm5EMURMPkpRvrWUDVz0Necow42kyQ3T+fPJZ0Hqi0aYIoHhUvpNH6rIdR1h67cOO2gs0biuPOyc/Eao1rCvRFxArzn9DaTIHvL2lgECnHOgKYueeQZwOaP4FGHDVczFlX82ngpeCrDC0UbMnujisVoUkuvXMKmM8SKhhTCWvg6E7eN7OAGAaJ9ObmBwX6UeQ7293sBf9ntsmnXlJtw8Yv9CCEQpl/fvISZcU+etdflzi92nJQP8GNYGC+MpQcQDevxvh+0v40ERP2IonadHuQ5BZYzZ9fV+qJxVRlrHLI6isprOeZCzLl2n3hpmyf8H1GHk8Pu/ucDJYON1w6Td88TQVY05KfLtv0AxtqQckUSMyAdrHcp9YRpE/1PoP5/tRVEHzH5h2+RHPe0rlGRJruFGT8MBWZRXbmSfYK5Rv9/zlMAv5FReaNSEGH8qcPf5JjSDpwytTpsvqYG2xbIkNn1ud6w0cr+b0hcH6KHtl80RGMf7rpJWERb7H5VBwYt1qIPjV1xZn5z2wGuX3hbQY7c9AJWCtkzOUX1lPktrsLUrlnV6pNGeoIVf+qChLOvy85k/4HW3b7SmNjChqJPGd6d737kroIHjTXxiMJdfgpBh56SjMIda9fZqOmyxvUOZIDszZCrqAMd/515ieTtvZUzDMyYR5mSgG79l1tVcY8gf8OqIqMJWiZvx4EFUEY7JwYwxIwedP2HRVETup5qnUxxBEjmsEUkOntlGuS+BybWaC8V1t7AipmEUwVmB1cd4n51v4Ucydhn9XYbU7kegLaF9dgriiUv1RfN5B6OuvJssBHNo0Y8Q/rKVLKtdOdkFTXc0W4+zon2bqShbCyMAlBvE0W8NxfTKHtCpoVhAlvCJ2cM/V4MUGaVBLbySlbI7gghBAstqH2I2lbDktixKlpS0/vnqlRT3ChRjyrF+dG18/fc/yMPDEDktSholc9TldY+8BLP9xkgjHUgOXIK3osQvjmjw3m2jlyiPxH4zsnZioGsUHfd5bNGxMRzwg1n/TxxiwWhNe6O5F+tdh1XUMW/IsJ4KVV1Nu1xjXG4TRq9mWl9en9xU0XScz389M+3umxQh9mu3vx62ty58AS93bij1fpH9WNK+ohzGKiZ1KPqE1ISSfdPfb2CIRF1/7tHh4mTwXznDPLV1yM3Bt3bIHzqo7P0tpRKnYfGg9/fyFmeenUSWB+2yHlcv8RDQJ7DsLb9J9PJgi9B/ciD/FtC9NyvgvnlEEZCcZcjJA7WVyWWf30zjBDm4Qb7UqCRRB+IFpZ1csX20gb6WoQj13OiBaIFhY/YSiy139l7aElURI5gac8jTy+QOqmXbYDBfIuQk8txjUbfQ6phRXU0h+evIZIWDvoqklkfGqGwyzT2CL0G2iQk8yJ79RXNwxejp008IMBbHV8UI3dQZQ5oUfmNtbJPyqdre/PR7gYiD8uav45SHOFpVy0tokgQvHF5cDHyT2Yb968P1jdrFLyxn2aRl611FmYXLWG8h8qMr+UGzo7BdP5gThIpX7MlUhj7gvMG1t4FJpwOq637UlHAJi61wjfbH2+J7mlLMI8X6FvxNin3qjfDXD3FvkwKGVMstKrbnmIuBUOfrshfECp/HjFuNStzMV4BKwFG21ef2gGAyISuiCQsA4lwSbgD/yITqoFDgyOj+3LXJ00uCdDUSOidftB0qZtlx3/99l8lwzu/vQNZ1PQJNyJ1PiuV3B0mPkISasNfX1za+RI19P1htruL8G3GQ92SgtTYj64ElzH9aItki1EayKk7FXQAxo6kDRFo1+wLO08Za0arG65v22IMr+VtS9aYoGaagn1PvG6R40kdxXCzbBEY0EOhs5pzUPdaZCnKmkEK77yoysLw+nC97s1GI0m0AxBO+k8dzMU+Ty9iNw13YzJ8r1kdCHMoabzlX7lxYYUz30+f/qpSCdpvqHeSRZxe8vmzynGFmB0Y0HJrYP3c7JjKSHF7ijL5zfM0X6lxiXBL+ffC4VFpRxei7EH1HMq89aP/+V0b/j/4KF7um5n864dOXznIutpBwKFx21CrLzCnDY/sXWPZ+j4Hoam9bpSNSMtSA7hd0YxKYP1JfXUK7TwI16xWYRLE80Rdw5+KT3aARe+4L9Lt+2Wgl2kBQE8kIbqUdIQl4Y0Fz1vr+OkXysNTEMvTYULG3krCERQml2a00AviNob1U+RaGsBv47I5DJY7WuAo6KNKxhKE/lWrt6K+kuAnf5q/x0bS+SdQkMOBtSgEEO07c1RY9jVhe1eTYStgyIQXQnOPqUmqVh94XyH14ipCA1KV9z1EOpxg7UNXO7bL1Nssrv8TKl74fmXaVoSBZXLlVq7kkQIRf0ZDX0dTvRwve95/iAyyOfENNRgkyb4NiIlGbtcfSxhBptiM1p6wti+w7FolmsqpOqLw1id3rpDznWKxa8ONUUzdMsmAQlhRHrfGrL4ZLGyzF+3Xcszc1xyHTk1dffiCUZTj91mdmDhgi5UoV1k5pd45O57zl+/Ll1J0Yjdurscvic2iZw3M67ji3yTfb+OGKgZ3OMdU5gBF+Zv5vkeb7aefsb3oX5Y46lvlWgp+Mhy0WtI3QRMNObxv8CZOYRbs4thcVlzLDJrXK2von+yS+1ZPAXNzH7IkzxI/8zB7K1yOtwQO0XkmvrLbPtMBisRQIEcRNQFbKo8wjxcc0VPL/aGE+PIGvUfLkgKIQbCPbRwIeQRl3jRCuLjkc/lW7yg/nVzS+0LFXwW3Sz9qUZFefZu05Am2/6LMIYlKHdVaH4ZudosRBnxQEKRW9LYBgt7zdyKTIFg3qJ6e4HqX35Hh61SZDpWptOMVpVvFVvsNIHzj8fXViF2j5SY5WMwswF0Zh9oONAdCLZyb6ueU5XXAg7kvpa+dM3sb1V9M/FF/5twrCO3yVNxJf8klJZetAaWm947RIku8sXc8jHWtWUurfdrFCTJJ4H9XMuWnT0JTZMvc4S6T1kTu611EDZrCiD1Jr5OCUK1OyF7ua3mKm3Qrj47+8t+Ix7Lm5UJX6LNrJkhHTKYqPDDvTVOgSY0qlDeeSEm4iRhl32odHApBk4odJng4qLc3KFWnwTzgp8uGkKWFQKYTBlywXRdu34xZCYHCShnGtLk22rQYZfq4Rq7IaWK+hAze3xGC+azy8arX8G01KfnS37vmAGMDvXSGl+vQi9IdzfGbWSOoSBQpNZRJ0oBzNzhvNXmSb/TuzsSY6a3qblNZlfBV9LihslXY7y/xLe6senkAt+g0oqIQJSdOT4Ebqtpjz6+n9ihbZfqadP1NRn7FfEWbDovnnw+6CG+BY4E0FC1unvaQDnFHiLn/vmwjcHT5XRvtV5jDru5n2SyndbMPOl27j2ic/KSIGo4J6VNPeVXNJyIIKftF6HDzPrBX/Y1plfW2D5UFXDOppY/lEFC2tLjY7RyP+QwhN2favqIEj+FkBd3kf8DAlbLSTVb6+mNJP5ztpxM4SsAblL1KLirx2TaYf9In/jiya29gqNTUr7OInlSVNtL62d8A2Vtp0Wpu9TQE01gogPlKPY6sWRtbTOGsKqzJL01243tCkwKBMek+ntVhqYn78I0SeXrnJUbzF28JRg45XqaKovKst1yHvbxBib9k8itKR30k2/tT9ilxdKMfyR5fgUG9p9AIvPiMzf1tVrH1vAFcEqFE9xnKVPKapXd9bejB4TGV/ftRKAy/ax8P6feuMbLC3EEdbYEACZF/vepEGynq8wgBFO7NJACzaMmiFMAsZYDpKC/Drk9s735IBuwGkBCazfMVRD6/xItoQkhnXpOqrNbbdY9q3Ok7cwrB6UOwjyucG/JYdb1Jprcj5ch9Ii5OFZ80n0afZFM0YIXtFg59Rw5CniEcBkCbCNZuNkB8ljuFEdBKZEOhbnO80ifvFpn11Y6rUjjgaLvEaJPNM3QPX59ZP2mu9SgwdYytoew/txuLFN3HEwj41DlhLNttN2ZNRAfSwNox62nAdCI8YuKhA6Jws/r0mHiVUGhBK+Qy1/LUP5vvJQdzZt2FNIwQkywO12a5N8pw3gQ8mm9//fmZ/iQuK/maOO2L2KQh/J3YO39C7WjjG3IaM//6BbYTDRNAhZegX2k8Mo+828NWWqTwlFtAX+Yfui7JcZBsO+X/CIaGBiVpgrOHZi3zHHHy9vFCr3ECTIPbqL3dKM5CP7tTOHjg6/Uv58rQcdmrzVVe/SH1n59eG4+g/LLPH3bDczZkuzW4lKXK7idQRzmwM1ufBdGHhbtDqJwLOox5MqIPsn0Hh+qRICM/Nl4m4LR5DlfB0KQzRYYfc3UsKNTok3NVwg6GiWxkP7sXG0X0neKaI0uCIrSZv6Ae4g6cTrSi9vPHlUwGM7+dQqtM+5FotfpQ/oPwu6PYrMFIdo7gqmX5j5cAcf+yy92XfM+CNrHs4UNqudBJgs4WfVN9ZkaKDWi/ySgMOZoa1WjbAXhTqrX/zD8LESdVmOSdGIIKluDMALi0Uv/hMzq/rUXpugKh5hhaAkIaH4BPLcXjB8295enOey7nezASpCLMsEwg/vu+WaSVLJgDkg9hEAkrK1LaNmNZaHErtseGyrP+y2U8swd92Ki8ue3t9LPPj35w0F0E34Kp5hgvXrOfG9lM19ZbCRb6okoKahukjqY6PsMmHmGhMlg6U2HIUBY9u5Mc3vgNvwqBTj9xOKNr8KBkxrzrBTTzDnDLGcUGf7ZUf/D+kspF4UCu62N4qtjJXKDwGbfKxSNmXxkaVE7wlOJTJ7szCqKVZjJfyHZKlRFWAAm6qzXFtZUXqXMdcI15CmK9phwSbi1NTjMFsye7PJO6nnuay/SCPCKkAJdatwieQXm8AKfMDaTMDxTFE2t3DtVtIFZYC3jxsnlwRJfXt/T1bYWCwm8+JNW2Ag6b0g/tp1zwB1ZLc7HKAmR7MreBWArZ+VIl3AGX9KNHgfKe9648Mm96rOTMOdzNBmsY8wJUWectccT6KiCokrBEhOYJrMfAfmIKC3aFuKMPdhN5cQfAiIoAFnOgB3bero3x66AdwQHDtYDRRt2VFOaOqX6dk9OMZ1aYxqM/tMRkGhC2KM+ktHJZzMxZWEAGGqS4n+n9xEqAeF+liYiI9zvB55bxT73vsCN8UI/V7YVn7kht3AYXuYlSRGPQCKnvGAmOCdFBbtzWEoVYku+qYNxg40i1xOE+WjSFzwgUbsUji5pX2u8NMdMVz4DqRd0eLq5/r7rkji38wUwrMgCAB4FEDq3bAjFz93sHUjQsM3+BzadTgIlGZ2RTgLlKNqgVLm3XVfEGkeFV4eZi820hOlCrS05IVQASpAnECnG15c5LKT+RXmNSainJZNU6nxk4cVY+G5NkBe0Wf6fVYJXSU0pmeHpGHldJaZAY0WU2pJMABEcjP22UC03ikkFtQJQk5zOvmsp+QnLW9UDrjGoNXYTvw+SG1DzrFJBhraW+qEl6VOJREHMA8//pApEX5l1zvR5kp9PI0xj6+vMI6ThqO+Kmvq2n2YCByUHrbfFjJA2dmoSAK6nwK5NaTkTADUONH/SCHjDA4mTjQVF3DzCQWI4CIr25Dc3EI5z+Rzb/XBxiYPC1SUwD37udjEoPt0YZC1slx2N1yR1sL/w2EmVZspOW2R2RyQkEVYdcJs/4L9J4CD5fW1X4paDvsvjR6rMoymP+cwUm+6KkQg3UPItwuEzRDmW3wjKTYtFpvCc/duzprWtGtB8FGtayPp4z0RAItOhwBByaKp4YpF7DF211iSoDaYyl/pZzZJ0c1RYWsKcWP/oPpwoWEvA1/JiD1aT+Gi5pNQSXKv/upFyw/1ZbdLgPPx5WiFmX0tmW3nJN6YiPGnCgkN8hritfnwbq3DiupoN9wJ+SRiNe2AAxTZ0HPYIhLkTNiYKnoNjcXfogP3MFtrNbccM7JVAf0CFjM3BvOFs8NOMglYfdLQAsA8LG0GRtEMedKacs63v10WXL9X6Z9t1exg+uX14QmhHmrwM8Dj7sbWNzHr9mTqZNYrh7FrHS7ZadS5ZiosxyZpkTFvp3DBJa25oRY+o04al+7PueA/xe4MaVVdhrfeo84CtVFqIsG4Z1iYTucCLkFm7SkNqo7DJuKIweQr0um4z2U6rwxtykaa70HaXK54BxjCVKwFeV+QUswOw/+jO70DV3BtmfDyjEZXmyPAnzIuZbRua8KiOvzvtNx+15ix0zbGx7UY+/Pzom6FBbvtqGcHsiJFEUvD7WXdFV4P0aAiLL/KGSPdRDUoSHXJEu4GQG2iHoJ36VlNtIkvQZyP9w6kCkzQrW3t1EPKQgCo23IbxhgjRkJLcrNQjYl7uw3ojvNb/4ml9sPO/kXvbJU8vcOkvggDA6dclCsAqm16ZDgdYGmrqPjI/XssryuMrixiuzg3Fah427iIo8+kSSMHnTwBDM4LwEcRb9UTA0iZPyhb90mTxNTNB22JyTJyTSq3N9Z2sLn4oFHtsVh9q9KPhC1s9lOkkf831Nhcox1QdM1nnS5AFbiJGhMHMHmS+a6rhbFz6xLNSwNgs9lr8G20lqltJlkv6Up30y5LzRNNhQV7SsHsVDJLqIp5wZCeVu01lwXStvPqr7MUNubDBToEckDadByJar1Aut0VKJtYSSxhqGNEiHSNyH0u528Fg5/iBqbQ6N/DivYqAOCuIB0bmu1+XvQto7zZtvTlR3cEKV/DopKX/u7G2UEEpruvpx1GBCsUd0IENfr+81ylg57tTQq74KG/GVYnhzBeiQoYhtdkSpm3HJWvOm3zl/g1LKZ1Op0NQR4kmY2t0C6FwaPVRL0fHQ8KOyZhWbJ090upQT1rsCxNwtkA6p1oP3n6V0+rHjXnYwJTBVziVOBpOVzumZEXRTkc5PNp3jb/hU1+jF+rBHm2NPHxDOlL5idGbj2MqZx0E46SmbK6L6ecwtRqdb0eDHMYxVpJGpXh1tTqpgUbE/Sc3AzxND7ojPQCWg1cOV/DwVc2ijLuNpMfYly91hW3RFB13Gdj7yK5T23hhiqeMA+Adf784gIm1UhiHTd9ZMH5hHoEFS9M2mObd4cSCPvsAD9nK9D8NyBmCJQsQYg+wzwMdqYSCWdPkU35rP0jjtxEYdmnSicfxTbhsKBkEMHzalEA1wvhEOr51xEk8HLV29EUgQeG+O2RoxKf0cM3W4fwU/e4fsjFbtFi9Xp8U22zYG2uvy4yrA6I1SPqPExH7rtXcqElbG1Z6lWgjMnkXh+G8tago//mooBMCk+ifnACP1pGJp8N1qZgEJJxJ3aZV4yMT0IAQGVflViqOsi2lik2/Jf9IvFV4UPA4Pnl296Go/jqveT8eSCfo2b6hnClriuZrugWKd+SWWw5OcaSyeysAYV7tqBciA2+nA+8kX6kOTTDqzLBjXdWo9is34J7mf6VD8eOfk/H5mStxIz+5ViLr/Kk/C3eP07NgnosRRT2jiGh5mb6i/IsUUmQfcjciDbD4UBzQE3/gUKmoWiGJkrGbnMBPCJ7nmoqts9vGqIEVPEcTv4UpSUK24wAyJL4RlS87p2vTro3vVKuyu5X8j7xgaBJNii/y8v8AVu9ZQs90ljTvadKeaJKWp+dK+tXMlEgqOiW4/ZpdvUoXMG3TNJd/D7P7DHYgWEgY0PUpfO29nrW7FIWp3NIJqBYbysY8ToAJiWMcFDfaS7kdQeaiXJQ97Ga0KD5etK6W0/da1JgqELO82BJmH1kZiI7E7nvkCgS1n2Q3Zju72gTffvdYtUeD7IGNA2hirlrZfovJlNLPjUvSBnKNnoPJ7/10Y5eWJAxMZpzlgzlaybvefWjVV5mfFnmRbHz2g1Z2CVSsDuj+gcEmmMoGUVxqdHK+DW81TnkL2XiXXqgaIMaNsaW3b5RIYYEG7+3RBWRgB7DTdUFaWVsQ33AiIo2Jdkx8MQq3/vuNwTxpNfNDNXdxHsi5ocxeOQpn3pgIZTJxpeuz7WWQdpsOUy3mFs4jRZ++nuJNAmkPHN5l8kbK7ncMyFp0pFLcDfr4zdp9+JiG9H9yOd249hV3LzwRLptH5qOESQHFWdAUm+GVBdk1N9hAzGW7K+QloC8doD47UrIuJOMUaXFQnXjjJ1gv7CQolqxT9qnuosIYbifcmcyBOSFc2PDS/BwZF5hywBif2AbhpMPyldG40EkOprcATlqTIGlBJKuP5ihwqgnIRfTknbAm5uMrr+0bpma0FQttvXzXb2ZaMf0Z4dztCGxlWvrbk0G1syQhH+7kvwb7xU91icQhkJrq2CFgbtieqLz1AWwrrCRRSs5QfHgkYjJ+dJsSa+r7SGPvvS3Ho4dfHqyJs6u1kEl5ELMa12udy2vmLxOsedLiSDvdwcm5XlPUZniBEbJyy8Pv672xbfWNAuDMTqQ9ofgH8h7EO04yIs2gIlufBEaQ+xWQSReGKyAlEJ8oILB/HscaWXMQ1qUXOfue6TaGAIB/XBt1MIDW15yYX0g8vdG90H8IPhZEfffKbnYSiCqDZ1NuEb5bIZq8FFUZ0a4Va96LdTxaKUS9PRE7heh8YHZ/oLBoLtAflIOZjBvP2eZjcF2iB0eq1aubF+bcg8MxyZ7fNB2r6NujZNaI807BOFepHhMq1ApMEGO2ugpKnV+DXvUuhDov9+N8edYJDu7w2pR9hLlLrbNi1xLE9ZnyvyZgPLIAQyk+jyZzVZokDbR8clDD2uYS8fGKu+lvFhHvQkkLt5vYnG3dGXGycW+EWm6oF5Sre/nAnViI8798FdyiNXxn75xawwr6TPkhhsxVrBMflf5q5LhavY9pgoBP0tfcsqBBUbEodWYGrnfG4MjCz415W1N0iXNQ4jkCtS+3PuNBUduZlXt4dmGNmDzUmqllT6TYiNKTpf8qcGnWLvnrmiUuanjAZo5jRrtOtc9x9hyAqyM6C2hW0TavuO86xft4Z+Fd18WT3UNfSocIStocRxuEt49KDK1mEB317h2K2YBVAa4cFKmZVOksrVQ693GLPzx5ZH/6cN66xCr3saCoAAURb2LDugqRlbqYrYPRNxa/OXJFpp8SnC5wOQ1w3GHYXhCfiiDFt55wGxL9TGjOOxqe22YK2Yz5XHSgKp2+I5iVrAHOMv/dT9DWCr4mgeC1Lr8aPjG8zBgTKhSor36QUVd2hXt5jts2vxHEK2XBWyA+NghD8GheDJgJJrScUkUbI81Nkd+fGCqAqKZQUcJaDERt2aGhLVtItzeFfPofbuVp0BINV1CUsTCZpDtjwDrvSZ2FKAd+K/gtwy9kxkOVvCsmfY5X7VPFC9xvDeDoB2ig3dU/0UgaZkKsc9hsIuJGUvifJEaWyRY2t4BP/EbpO4fX5mcO0Y0+wNLFQItUFhAdtq7N8Wvninyu6zrnfDtLMUKeHIRsNqbLbMU2Eh04xhiIYsF6vwgJhhh3RgYznRP9r8DurLUiMpcvQan8woHLQnktyJL3HhrzX+EoWWTfFknmDM8jxUSUjfukh74qJ38H9spohFQ13iQ2KTGZFz+35pxzMdiqRFQV6SDy1226w8d+Me4oZJfS39F0eygoTKaWxV7VShdrct4PrDzZMmMvEamR937CVeamNzHgOeV8F35JwJkfB0r1Vuhw+xvE/wv1XznGgbBfbAd7ihMDiDMEc7ffBjg//L18vYnNjZnJhbWU"></div><input type="hidden" name="bgresponse" value="js_disabled" id="bgresponse" style="display:none"><script nonce="OK4kAkmEv62hXDr_AoR8Yw">(function(){'use strict';var d=function(a){var b=0;return function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}}},f=function(){var a=document.querySelectorAll('div[data-button-type="multipleChoiceIdentifier"]'),b="undefined"!=typeof Symbol&&Symbol.iterator&&a[Symbol.iterator];if(b)return b.call(a);if("number"==typeof a.length)return{next:d(a)};throw Error(String(a)+" is not an iterable or ArrayLike");};/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
var l=function(){this.i=new window.botguard.bg(k,function(){});this.h=this.g=null;this.i&&window.addEventListener("load",this.j.bind(this))};l.prototype.j=function(){var a=this;this.g=document.getElementById("hiddenMultipleChoiceIdentifier");this.h=function(){a.i.invoke(a.l)};this.g?m(this):document.addEventListener("submit",this.h.bind(this))};l.prototype.l=function(a){var b=document.getElementById("bgresponse");b&&(b.value=a)};
var m=function(a){for(var b=function(e){a.g&&(a.g.value=e);a.h()},q=function(e,p){13===p.keyCode&&(a.g&&(a.g.value=e),a.h())},g=f(),c=g.next();!c.done;c=g.next()){c=c.value.getElementsByTagName("button")[0];var h=c.value;c.addEventListener("click",b.bind(a,h));c.addEventListener("keydown",q.bind(a,h))}},n=document.getElementById("program");if(n){var k=n.getAttribute("program-data");k&&new l};}).call(this);
</script></span><span jsname="ZVfTqd"></span>
									</div>
								</section>
							</div>
							<span jsslot><div class="D4rY0b"><p class="vOZun">To continue, Google will share your name, email address, language preference, and profile picture with DEE:P. </p></div></span>
							<div class="i2knIc" jsname="DH6Rkf">
								<div class="wg0fFb" jsname="DhK0U">
									<div class="RhTxBf" jsname="k77Iif">
										<button name="action" class="JnOM6e TrZEUc rDisVe" value="1" jsname="Njthtb" id="identifierNext">Next</button>
									</div>
									<div class="tmMcIf" jsname="QkNstf"><a
											href="/SignUp?app_domain=http://localhost:8081&amp;cc=KR&amp;client_id=25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com&amp;continue=https://accounts.google.com/signin/oauth/legacy/consent?authuser%3Dunknown%26part%3DAJi8hAP9su1ktWsSJoMWE169hk2DpRdEhfjxpT3PEnRlfLKPMiG_VYpzjhDzibxj2LBz-Z0c2mjuYP1Tbtx9npFzLZ2GhxOTfRuK2IiBKaN34PG25h3hRK8FNNXrTsFA_aF-Ox6KFz7j_SweQTLxWcLjyJsle-ahCMQqEYQZdmyosqJZU6WPuYIq8oCYZ9eGy0xdPDSzrKiFnH3bEwst51CWY-LPzyzFR6nZz7ysnkFuzMkPDP9yDbPBFr30u07J1gAi0Hbn7sAianw17GkyRExPis5bgBUQavXeZi1ftABwwD60xE5MKK3mF9_i3QhanG1FT56a5SIU-nWHv-hV6mmBk76SUi_z_RaswcXWNfsstAU-hVHnXyGlLgOBb7TZPOaO0t1SQyjgF_eEhy8K4J2KgYBsv7FyhQjtZZew0UsS0crnz2SuRtV73KqSD-TyVmXBKbhBVvF7RML6x9KhXSVYjv-RzcxUZQ%26as%3DS587311950%253A1696551822831222%26client_id%3D25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com%26theme%3Dglif%23&amp;dsh=S587311950:1696551822831222&amp;flowName=GeneralOAuthLite&amp;o2v=2&amp;opparams=%253F&amp;rart=ANgoxcexAd21k-Wnz_9BXHTuZIQui91FQoGyw2kNkcjm8DTG-0KMavr3lT-pJidk7-I1oq5W3Qy8Eh7KZXdPKMCy_uxagnB06w&amp;redirect_uri=http://localhost:8081/v1/api/auth/google/callback&amp;response_type=code&amp;scope=profile+email&amp;service=lso&amp;signInUrl=https://accounts.google.com/signin/oauth?app_domain%3Dhttp://localhost:8081%26client_id%3D25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com%26continue%3Dhttps://accounts.google.com/signin/oauth/legacy/consent?authuser%253Dunknown%2526part%253DAJi8hAP9su1ktWsSJoMWE169hk2DpRdEhfjxpT3PEnRlfLKPMiG_VYpzjhDzibxj2LBz-Z0c2mjuYP1Tbtx9npFzLZ2GhxOTfRuK2IiBKaN34PG25h3hRK8FNNXrTsFA_aF-Ox6KFz7j_SweQTLxWcLjyJsle-ahCMQqEYQZdmyosqJZU6WPuYIq8oCYZ9eGy0xdPDSzrKiFnH3bEwst51CWY-LPzyzFR6nZz7ysnkFuzMkPDP9yDbPBFr30u07J1gAi0Hbn7sAianw17GkyRExPis5bgBUQavXeZi1ftABwwD60xE5MKK3mF9_i3QhanG1FT56a5SIU-nWHv-hV6mmBk76SUi_z_RaswcXWNfsstAU-hVHnXyGlLgOBb7TZPOaO0t1SQyjgF_eEhy8K4J2KgYBsv7FyhQjtZZew0UsS0crnz2SuRtV73KqSD-TyVmXBKbhBVvF7RML6x9KhXSVYjv-RzcxUZQ%2526as%253DS587311950%25253A1696551822831222%2526client_id%253D25037882319-1gl4gqc6c2s4k24p04h2m1q8kopj43gm.apps.googleusercontent.com%2526theme%253Dglif%2523%26dsh%3DS587311950:1696551822831222%26flowName%3DGeneralOAuthLite%26o2v%3D2%26opparams%3D%25253F%26rart%3DANgoxcexAd21k-Wnz_9BXHTuZIQui91FQoGyw2kNkcjm8DTG-0KMavr3lT-pJidk7-I1oq5W3Qy8Eh7KZXdPKMCy_uxagnB06w%26redirect_uri%3Dhttp://localhost:8081/v1/api/auth/google/callback%26response_type%3Dcode%26scope%3Dprofile%2Bemail%26service%3Dlso%26theme%3Dglif&amp;theme=glif"
											class="JnOM6e TrZEUc kTeh9 KXbQ4b">Create account</a></div>
								</div>
							</div>
							<input type="hidden" name="at" value="ALt4Ve1KYOop3d9qYjcX7kcPGe_L:1696551823079"></form>
					</div>
				</div>
				<script aria-hidden="true" nonce="OK4kAkmEv62hXDr_AoR8Yw">
					window.wiz_progress&&window.wiz_progress();window.wiz_tick&&window.wiz_tick('chA7fe');
				</script>
</body>

</html>
</div>
<c-wiz jsrenderer="ZdRp7e" jsshadow jsdata="deferred-i1" data-node-index="0;0" jsmodel="hc6Ubd" c-wiz>
	<footer class="HUYFt" data-auto-init="Footer">
		<div class="hXs2T">
			<form autocomplete="off">
				<select name="hl" class="N158t" data-language-selector-select jsname="rfCUpd"><option value="af">Afrikaans</option><option value="az">azərbaycan</option><option value="bs">bosanski</option><option value="ca">català</option><option value="cs">Čeština</option><option value="cy">Cymraeg</option><option value="da">Dansk</option><option value="de">Deutsch</option><option value="et">eesti</option><option value="en-GB">English (United Kingdom)</option><option value="en-US" selected>English (United States)</option><option value="es-ES">Español (España)</option><option value="es-419">Español (Latinoamérica)</option><option value="eu">euskara</option><option value="fil">Filipino</option><option value="fr-CA">Français (Canada)</option><option value="fr-FR">Français (France)</option><option value="ga">Gaeilge</option><option value="gl">galego</option><option value="hr">Hrvatski</option><option value="id">Indonesia</option><option value="zu">isiZulu</option><option value="is">íslenska</option><option value="it">Italiano</option><option value="sw">Kiswahili</option><option value="lv">latviešu</option><option value="lt">lietuvių</option><option value="hu">magyar</option><option value="ms">Melayu</option><option value="nl">Nederlands</option><option value="no">norsk</option><option value="uz">o‘zbek</option><option value="pl">polski</option><option value="pt-BR">Português (Brasil)</option><option value="pt-PT">Português (Portugal)</option><option value="ro">română</option><option value="sq">shqip</option><option value="sk">Slovenčina</option><option value="sl">slovenščina</option><option value="sr-Latn">srpski (latinica)</option><option value="fi">Suomi</option><option value="sv">Svenska</option><option value="vi">Tiếng Việt</option><option value="tr">Türkçe</option><option value="el">Ελληνικά</option><option value="be">беларуская</option><option value="bg">български</option><option value="ky">кыргызча</option><option value="kk">қазақ тілі</option><option value="mk">македонски</option><option value="mn">монгол</option><option value="ru">Русский</option><option value="sr-Cyrl">српски (ћирилица)</option><option value="uk">Українська</option><option value="ka">ქართული</option><option value="hy">հայերեն</option><option value="iw">‫עברית‬‎</option><option value="ur">‫اردو‬‎</option><option value="ar">‫العربية‬‎</option><option value="fa">‫فارسی‬‎</option><option value="am">አማርኛ</option><option value="ne">नेपाली</option><option value="mr">मराठी</option><option value="hi">हिन्दी</option><option value="as">অসমীয়া</option><option value="bn">বাংলা</option><option value="pa">ਪੰਜਾਬੀ</option><option value="gu">ગુજરાતી</option><option value="or">ଓଡ଼ିଆ</option><option value="ta">தமிழ்</option><option value="te">తెలుగు</option><option value="kn">ಕನ್ನಡ</option><option value="ml">മലയാളം</option><option value="si">සිංහල</option><option value="th">ไทย</option><option value="lo">ລາວ</option><option value="my">မြန်မာ</option><option value="km">ខ្មែរ</option><option value="ko">한국어</option><option value="zh-HK">中文（香港）</option><option value="ja">日本語</option><option value="zh-CN">简体中文</option><option value="zh-TW">繁體中文</option></select>
			</form>
		</div>
		<ul class="M2nKge">
			<li class="vomtoe"><a class="pUP0Nd TrZEUc"
					href="https://support.google.com/accounts?hl=en-US&amp;p=account_iph"
					target="_blank"><span class="UskCyf">Help</span></a></li>
			<li class="vomtoe"><a class="pUP0Nd TrZEUc"
					href="https://accounts.google.com/TOS?loc=KR&amp;hl=en-US&amp;privacy=true"
					target="_blank"><span class="UskCyf">Privacy</span></a></li>
			<li class="vomtoe"><a class="pUP0Nd TrZEUc" href="https://accounts.google.com/TOS?loc=KR&amp;hl=en-US"
					target="_blank"><span class="UskCyf">Terms</span></a></li>
		</ul>
	</footer>
	<c-data id="i1" jsdata=" OsjLy;_;1"></c-data>
</c-wiz>
<script aria-hidden="true" nonce="OK4kAkmEv62hXDr_AoR8Yw">
	window.wiz_progress&&window.wiz_progress();window.wiz_tick&&window.wiz_tick('ZdRp7e');
</script>
<script nonce="OK4kAkmEv62hXDr_AoR8Yw">
	(function(){'use strict';var a=function(b){var c=0;return function(){return c<b.length?{done:!1,value:b[c++]}:{done:!0}}},k="function"==typeof Object.defineProperties?Object.defineProperty:function(b,c,d){if(b==Array.prototype||b==Object.prototype)return b;b[c]=d.value;return b},aa=function(b){b=["object"==typeof globalThis&&globalThis,b,"object"==typeof window&&window,"object"==typeof self&&self,"object"==typeof global&&global];for(var c=0;c<b.length;++c){var d=b[c];if(d&&d.Math==Math)return d}throw Error("Cannot find global object");
},m=aa(this),n=function(b,c){if(c)a:{var d=m;b=b.split(".");for(var e=0;e<b.length-1;e++){var g=b[e];if(!(g in d))break a;d=d[g]}b=b[b.length-1];e=d[b];c=c(e);c!=e&&null!=c&&k(d,b,{configurable:!0,writable:!0,value:c})}};
n("Symbol",function(b){if(b)return b;var c=function(h,f){this.i=h;k(this,"description",{configurable:!0,writable:!0,value:f})};c.prototype.toString=function(){return this.i};var d="jscomp_symbol_"+(1E9*Math.random()>>>0)+"_",e=0,g=function(h){if(this instanceof g)throw new TypeError("Symbol is not a constructor");return new c(d+(h||"")+"_"+e++,h)};return g});
n("Symbol.iterator",function(b){if(b)return b;b=Symbol("Symbol.iterator");for(var c="Array Int8Array Uint8Array Uint8ClampedArray Int16Array Uint16Array Int32Array Uint32Array Float32Array Float64Array".split(" "),d=0;d<c.length;d++){var e=m[c[d]];"function"===typeof e&&"function"!=typeof e.prototype[b]&&k(e.prototype,b,{configurable:!0,writable:!0,value:function(){return ba(a(this))}})}return b});
var ba=function(b){b={next:b};b[Symbol.iterator]=function(){return this};return b},p=function(b){var c="undefined"!=typeof Symbol&&Symbol.iterator&&b[Symbol.iterator];if(c)return c.call(b);if("number"==typeof b.length)return{next:a(b)};throw Error(String(b)+" is not an iterable or ArrayLike");},ca="function"==typeof Object.create?Object.create:function(b){var c=function(){};c.prototype=b;return new c},q;
if("function"==typeof Object.setPrototypeOf)q=Object.setPrototypeOf;else{var r;a:{var da={a:!0},t={};try{t.__proto__=da;r=t.a;break a}catch(b){}r=!1}q=r?function(b,c){b.__proto__=c;if(b.__proto__!==c)throw new TypeError(b+" is not extensible");return b}:null}
var u=q,v=function(b,c){b.prototype=ca(c.prototype);b.prototype.constructor=b;if(u)u(b,c);else for(var d in c)if("prototype"!=d)if(Object.defineProperties){var e=Object.getOwnPropertyDescriptor(c,d);e&&Object.defineProperty(b,d,e)}else b[d]=c[d];b.u=c.prototype},w=function(b,c){b instanceof String&&(b+="");var d=0,e=!1,g={next:function(){if(!e&&d<b.length){var h=d++;return{value:c(h,b[h]),done:!1}}e=!0;return{done:!0,value:void 0}}};g[Symbol.iterator]=function(){return g};return g};
n("Array.prototype.entries",function(b){return b?b:function(){return w(this,function(c,d){return[c,d]})}});n("Array.prototype.keys",function(b){return b?b:function(){return w(this,function(c){return c})}});/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
var x=this||self,y=function(b,c){function d(){}d.prototype=c.prototype;b.u=c.prototype;b.prototype=new d;b.prototype.constructor=b;b.v=function(e,g,h){for(var f=Array(arguments.length-2),l=2;l<arguments.length;l++)f[l-2]=arguments[l];return c.prototype[g].apply(e,f)}},z=function(b){return b};var B=function(b){this.i=b;this.j()};function C(b,c){if(Error.captureStackTrace)Error.captureStackTrace(this,C);else{var d=Error().stack;d&&(this.stack=d)}b&&(this.message=String(b));void 0!==c&&(this.cause=c)}y(C,Error);C.prototype.name="CustomError";function D(b,c){b=b.split("%s");for(var d="",e=b.length-1,g=0;g<e;g++)d+=b[g]+(g<c.length?c[g]:"%s");C.call(this,d+b[e])}y(D,C);D.prototype.name="AssertionError";var ea=function(b,c){throw new D("Failure"+(b?": "+b:""),Array.prototype.slice.call(arguments,1));};var E=function(){B.apply(this,arguments)};v(E,B);E.prototype.j=function(){var b=this.i.querySelector("FORM".toString());b&&this.i.addEventListener("submit",function(c){"true"===b.getAttribute("data-is-submitted")?c.preventDefault():b.setAttribute("data-is-submitted","true")})};var F=function(b,c){this.name=b;this.value=c};F.prototype.toString=function(){return this.name};
var fa=new F("OFF",Infinity),ha=new F("WARNING",900),ia=new F("CONFIG",700),ja=function(){},ka,la=function(){},ma=function(b,c){this.i=null;this.o=[];this.j=(void 0===c?null:c)||null;this.l=[];this.s={i:function(){return b}}},na=function(b){if(b.i)return b.i;if(b.j)return na(b.j);ea("Root logger has no level set.");return fa},oa=function(b){for(var c=new la;b;)b.o.forEach(function(d){d(c)}),b=b.j},pa=function(){this.entries={};var b=new ma("");b.i=ia;this.entries[""]=b},G,H=function(b,c){var d=b.entries[c];
if(d)return d;d=H(b,c.slice(0,Math.max(c.lastIndexOf("."),0)));var e=new ma(c,d);b.entries[c]=e;d.l.push(e);return e},I=function(){G||(G=new pa);return G};var J;var L=function(b,c){if(c!==K)throw Error("SafeUrl is not meant to be built directly");this.i=b};L.prototype.toString=function(){return this.i.toString()};var K={},qa=new L("about:invalid#zClosurez",K);new L("about:blank",K);var ra={},sa=function(){if(ra!==ra)throw Error("SafeStyle is not meant to be built directly");};sa.prototype.toString=function(){return"".toString()};new sa;var ta={},ua=function(){if(ta!==ta)throw Error("SafeStyleSheet is not meant to be built directly");};ua.prototype.toString=function(){return"".toString()};new ua;var va={},M=function(b){if(va!==va)throw Error("SafeHtml is not meant to be built directly");this.i=b};M.prototype.toString=function(){return this.i.toString()};new M(x.trustedTypes&&x.trustedTypes.emptyHTML||"");/*

 SPDX-License-Identifier: Apache-2.0
*/
var wa="function"===typeof URL,N=[],xa=function(){};ya(function(b){var c;if(c=H(I(),"safevalues").s){b="A URL with content '"+b+"' was sanitized away.";var d;if(d=c)if(d=c&&ha){d=ha.value;var e=c?na(H(I(),c.i())):fa;d=d>=e.value}d&&(c=H(I(),c.i()),"function"===typeof b&&b(),ka||(ka=new ja),oa(c))}});function ya(b){-1===N.indexOf(b)&&N.push(b);xa=function(c){N.forEach(function(d){d(c)})}};var O=function(b){this.m=b};function P(b){return new O(function(c){return c.substr(0,b.length+1).toLowerCase()===b+":"})}var za=[P("data"),P("http"),P("https"),P("mailto"),P("ftp"),new O(function(b){return/^[^:]*([/?#]|${'$'})/.test(b)})];var Q=function(){B.apply(this,arguments)};v(Q,B);Q.prototype.j=function(){var b=this.i.querySelector("[data-language-selector-select]");b&&Aa(b)};
var Aa=function(b){b.addEventListener("change",function(c){c=c.target;if(c.value){var d=new URL(document.location.toString());d.searchParams.set("hl",c.value);c=window.location;var e=void 0===e?za:e;a:{d=d.toString();e=void 0===e?za:e;for(var g=0;g<e.length;++g){var h=e[g];if(h instanceof O&&h.m(d)){e=new L(d,K);break a}}e=void 0}e=e||qa;if(e instanceof L)if(e instanceof L&&e.constructor===L)var f=e.i;else f=typeof e,ea("expected object of type SafeUrl, got '"+e+"' of type "+("object"!=f?f:e?Array.isArray(e)?
"array":f:"null")),f="type_error:SafeUrl";else{b:if(wa){try{f=new URL(e)}catch(l){f="https:";break b}f=f.protocol}else c:{f=document.createElement("a");try{f.href=e}catch(l){f=void 0;break c}f=f.protocol;f=":"===f||""===f?"https:":f}"javascript:"===f?(xa(e),f=void 0):f=e}void 0!==f&&(c.href=f)}})};var R=Object.create(null);function S(b,c){R[b]||(R[b]=c)};var T=function(){B.apply(this,arguments)};v(T,B);T.prototype.j=function(){var b=this.i.querySelector("#playCaptchaButton"),c=this.i.querySelector("#captchaAudio"),d=this.i.querySelector("input[name=ca]");b&&c&&d&&b.addEventListener("click",function(e){e.preventDefault();c.readyState===HTMLMediaElement.HAVE_NOTHING?c.load():c.paused&&c.play();d.value="";d.focus()})};var U=function(){B.apply(this,arguments)};v(U,B);U.prototype.j=function(){void 0!==this.i.dataset.hasDomainSuffix&&(Ba(this.i),Ca(this.i))};var Ca=function(b){b.addEventListener("keyup",function(){Ba(b)})},Ba=function(b){0<b.getElementsByTagName("INPUT".toString()).item(0).value.indexOf("@")?b.dataset.hasAtSign="":delete b.dataset.hasAtSign};var V=function(){B.apply(this,arguments)};v(V,B);V.prototype.j=function(){var b=this.i;void 0!==b.dataset.hasDomainSuffix&&(Da(b),Ea(b))};var Ea=function(b){b.addEventListener("keyup",function(){Da(b)})},Da=function(b){0<b.getElementsByTagName("INPUT".toString()).item(0).value.indexOf("@")?b.dataset.hasAtSign="":delete b.dataset.hasAtSign};var W={COUNTRY:{"001":"world","002":"Africa","003":"North America","005":"South America","009":"Oceania","011":"Western Africa","013":"Central America","014":"Eastern Africa","015":"Northern Africa","017":"Middle Africa","018":"Southern Africa","019":"Americas","021":"Northern America","029":"Caribbean","030":"Eastern Asia","034":"Southern Asia","035":"Southeast Asia","039":"Southern Europe","053":"Australasia","054":"Melanesia","057":"Micronesian Region","061":"Polynesia",142:"Asia",143:"Central Asia",
145:"Western Asia",150:"Europe",151:"Eastern Europe",154:"Northern Europe",155:"Western Europe",202:"Sub-Saharan Africa",419:"Latin America",AC:"Ascension Island",AD:"Andorra",AE:"United Arab Emirates",AF:"Afghanistan",AG:"Antigua & Barbuda",AI:"Anguilla",AL:"Albania",AM:"Armenia",AO:"Angola",AQ:"Antarctica",AR:"Argentina",AS:"American Samoa",AT:"Austria",AU:"Australia",AW:"Aruba",AX:"\u00c5land Islands",AZ:"Azerbaijan",BA:"Bosnia & Herzegovina",BB:"Barbados",BD:"Bangladesh",BE:"Belgium",BF:"Burkina Faso",
BG:"Bulgaria",BH:"Bahrain",BI:"Burundi",BJ:"Benin",BL:"St. Barth\u00e9lemy",BM:"Bermuda",BN:"Brunei",BO:"Bolivia",BQ:"Caribbean Netherlands",BR:"Brazil",BS:"Bahamas",BT:"Bhutan",BV:"Bouvet Island",BW:"Botswana",BY:"Belarus",BZ:"Belize",CA:"Canada",CC:"Cocos (Keeling) Islands",CD:"Congo - Kinshasa",CF:"Central African Republic",CG:"Congo - Brazzaville",CH:"Switzerland",CI:"C\u00f4te d\u2019Ivoire",CK:"Cook Islands",CL:"Chile",CM:"Cameroon",CN:"China",CO:"Colombia",CP:"Clipperton Island",CQ:"Sark",
CR:"Costa Rica",CU:"Cuba",CV:"Cape Verde",CW:"Cura\u00e7ao",CX:"Christmas Island",CY:"Cyprus",CZ:"Czechia",DE:"Germany",DG:"Diego Garcia",DJ:"Djibouti",DK:"Denmark",DM:"Dominica",DO:"Dominican Republic",DZ:"Algeria",EA:"Ceuta & Melilla",EC:"Ecuador",EE:"Estonia",EG:"Egypt",EH:"Western Sahara",ER:"Eritrea",ES:"Spain",ET:"Ethiopia",EU:"European Union",EZ:"Eurozone",FI:"Finland",FJ:"Fiji",FK:"Falkland Islands (Islas Malvinas)",FM:"Micronesia",FO:"Faroe Islands",FR:"France",GA:"Gabon",GB:"United Kingdom",
GD:"Grenada",GE:"Georgia",GF:"French Guiana",GG:"Guernsey",GH:"Ghana",GI:"Gibraltar",GL:"Greenland",GM:"Gambia",GN:"Guinea",GP:"Guadeloupe",GQ:"Equatorial Guinea",GR:"Greece",GS:"South Georgia & South Sandwich Islands",GT:"Guatemala",GU:"Guam",GW:"Guinea-Bissau",GY:"Guyana",HK:"Hong Kong",HM:"Heard & McDonald Islands",HN:"Honduras",HR:"Croatia",HT:"Haiti",HU:"Hungary",IC:"Canary Islands",ID:"Indonesia",IE:"Ireland",IL:"Israel",IM:"Isle of Man",IN:"India",IO:"British Indian Ocean Territory",IQ:"Iraq",
IR:"Iran",IS:"Iceland",IT:"Italy",JE:"Jersey",JM:"Jamaica",JO:"Jordan",JP:"Japan",KE:"Kenya",KG:"Kyrgyzstan",KH:"Cambodia",KI:"Kiribati",KM:"Comoros",KN:"St. Kitts & Nevis",KP:"North Korea",KR:"South Korea",KW:"Kuwait",KY:"Cayman Islands",KZ:"Kazakhstan",LA:"Laos",LB:"Lebanon",LC:"St. Lucia",LI:"Liechtenstein",LK:"Sri Lanka",LR:"Liberia",LS:"Lesotho",LT:"Lithuania",LU:"Luxembourg",LV:"Latvia",LY:"Libya",MA:"Morocco",MC:"Monaco",MD:"Moldova",ME:"Montenegro",MF:"St. Martin",MG:"Madagascar",MH:"Marshall Islands",
MK:"North Macedonia",ML:"Mali",MM:"Myanmar (Burma)",MN:"Mongolia",MO:"Macao",MP:"Northern Mariana Islands",MQ:"Martinique",MR:"Mauritania",MS:"Montserrat",MT:"Malta",MU:"Mauritius",MV:"Maldives",MW:"Malawi",MX:"Mexico",MY:"Malaysia",MZ:"Mozambique",NA:"Namibia",NC:"New Caledonia",NE:"Niger",NF:"Norfolk Island",NG:"Nigeria",NI:"Nicaragua",NL:"Netherlands",NO:"Norway",NP:"Nepal",NR:"Nauru",NU:"Niue",NZ:"New Zealand",OM:"Oman",PA:"Panama",PE:"Peru",PF:"French Polynesia",PG:"Papua New Guinea",PH:"Philippines",
PK:"Pakistan",PL:"Poland",PM:"St. Pierre & Miquelon",PN:"Pitcairn Islands",PR:"Puerto Rico",PS:"Palestine",PT:"Portugal",PW:"Palau",PY:"Paraguay",QA:"Qatar",QO:"Outlying Oceania",RE:"R\u00e9union",RO:"Romania",RS:"Serbia",RU:"Russia",RW:"Rwanda",SA:"Saudi Arabia",SB:"Solomon Islands",SC:"Seychelles",SD:"Sudan",SE:"Sweden",SG:"Singapore",SH:"St. Helena",SI:"Slovenia",SJ:"Svalbard & Jan Mayen",SK:"Slovakia",SL:"Sierra Leone",SM:"San Marino",SN:"Senegal",SO:"Somalia",SR:"Suriname",SS:"South Sudan",ST:"S\u00e3o Tom\u00e9 & Pr\u00edncipe",
SV:"El Salvador",SX:"Sint Maarten",SY:"Syria",SZ:"Eswatini",TA:"Tristan da Cunha",TC:"Turks & Caicos Islands",TD:"Chad",TF:"French Southern Territories",TG:"Togo",TH:"Thailand",TJ:"Tajikistan",TK:"Tokelau",TL:"Timor-Leste",TM:"Turkmenistan",TN:"Tunisia",TO:"Tonga",TR:"T\u00fcrkiye",TT:"Trinidad & Tobago",TV:"Tuvalu",TW:"Taiwan",TZ:"Tanzania",UA:"Ukraine",UG:"Uganda",UM:"U.S. Outlying Islands",UN:"United Nations",US:"United States",UY:"Uruguay",UZ:"Uzbekistan",VA:"Vatican City",VC:"St. Vincent & Grenadines",
VE:"Venezuela",VG:"British Virgin Islands",VI:"U.S. Virgin Islands",VN:"Vietnam",VU:"Vanuatu",WF:"Wallis & Futuna",WS:"Samoa",XK:"Kosovo",YE:"Yemen",YT:"Mayotte",ZA:"South Africa",ZM:"Zambia",ZW:"Zimbabwe",ZZ:"Unknown Region"}};var Fa={ac:{name:W.COUNTRY.AC,g:"247",index:5},ad:{name:W.COUNTRY.AD,g:"376",index:45},ae:{name:W.COUNTRY.AE,g:"971",index:180},af:{name:W.COUNTRY.AF,g:"93",index:187},ag:{name:W.COUNTRY.AG,g:"1",index:67,h:!0},ai:{name:W.COUNTRY.AI,g:"1",index:158,h:!0},al:{name:W.COUNTRY.AL,g:"355",index:77},am:{name:W.COUNTRY.AM,g:"374",index:12},ao:{name:W.COUNTRY.AO,g:"244",index:155},ar:{name:W.COUNTRY.AR,g:"54",index:193},as:{name:W.COUNTRY.AS,g:"1",index:121,h:!0},at:{name:W.COUNTRY.AT,g:"43",index:102},au:{name:W.COUNTRY.AU,
g:"61",index:134},aw:{name:W.COUNTRY.AW,g:"297",index:60},az:{name:W.COUNTRY.AZ,g:"994",index:94},ba:{name:W.COUNTRY.BA,g:"387",index:123},bb:{name:W.COUNTRY.BB,g:"1",index:122,h:!0},bd:{name:W.COUNTRY.BD,g:"880",index:139},be:{name:W.COUNTRY.BE,g:"32",index:0},bf:{name:W.COUNTRY.BF,g:"226",index:56},bg:{name:W.COUNTRY.BG,g:"359",index:208},bh:{name:W.COUNTRY.BH,g:"973",index:115},bi:{name:W.COUNTRY.BI,g:"257",index:150},bj:{name:W.COUNTRY.BJ,g:"229",index:99},bl:{name:W.COUNTRY.BL,g:"590",index:19,
h:!0},bm:{name:W.COUNTRY.BM,g:"1",index:152,h:!0},bn:{name:W.COUNTRY.BN,g:"673",index:131},bo:{name:W.COUNTRY.BO,g:"591",index:128},bq:{name:W.COUNTRY.BQ,g:"599",index:220,h:!0},br:{name:W.COUNTRY.BR,g:"55",index:59},bs:{name:W.COUNTRY.BS,g:"1",index:27,h:!0},bt:{name:W.COUNTRY.BT,g:"975",index:146},bw:{name:W.COUNTRY.BW,g:"267",index:219},by:{name:W.COUNTRY.BY,g:"375",index:83},bz:{name:W.COUNTRY.BZ,g:"501",index:36},ca:{name:W.COUNTRY.CA,g:"1",index:106,h:!0},cd:{name:W.COUNTRY.CD,g:"243",index:117},
cf:{name:W.COUNTRY.CF,g:"236",index:145},cg:{name:W.COUNTRY.CG,g:"242",index:141},ch:{name:W.COUNTRY.CH,g:"41",index:101},ci:{name:W.COUNTRY.CI,g:"225",index:129},ck:{name:W.COUNTRY.CK,g:"682",index:183},cl:{name:W.COUNTRY.CL,g:"56",index:103},cm:{name:W.COUNTRY.CM,g:"237",index:165},cn:{name:W.COUNTRY.CN,g:"86",index:63},co:{name:W.COUNTRY.CO,g:"57",index:24},cr:{name:W.COUNTRY.CR,g:"506",index:168},cu:{name:W.COUNTRY.CU,g:"53",index:58},cv:{name:W.COUNTRY.CV,g:"238",index:214},cw:{name:W.COUNTRY.CW,
g:"599",index:221},cy:{name:W.COUNTRY.CY,g:"357",index:43},cz:{name:W.COUNTRY.CZ,g:"420",index:182},de:{name:W.COUNTRY.DE,g:"49",index:203},dj:{name:W.COUNTRY.DJ,g:"253",index:169},dk:{name:W.COUNTRY.DK,g:"45",index:107},dm:{name:W.COUNTRY.DM,g:"1",index:197,h:!0},"do":{name:W.COUNTRY.DO,g:"1",index:118,h:!0},dz:{name:W.COUNTRY.DZ,g:"213",index:40},ec:{name:W.COUNTRY.EC,g:"593",index:90},ee:{name:W.COUNTRY.EE,g:"372",index:196},eg:{name:W.COUNTRY.EG,g:"20",index:178},er:{name:W.COUNTRY.ER,g:"291",
index:55},es:{name:W.COUNTRY.ES,g:"34",index:87},et:{name:W.COUNTRY.ET,g:"251",index:198},fi:{name:W.COUNTRY.FI,g:"358",index:151},fj:{name:W.COUNTRY.FJ,g:"679",index:147},fk:{name:W.COUNTRY.FK,g:"500",index:224},fm:{name:W.COUNTRY.FM,g:"691",index:136},fo:{name:W.COUNTRY.FO,g:"298",index:84},fr:{name:W.COUNTRY.FR,g:"33",index:19},ga:{name:W.COUNTRY.GA,g:"241",index:68},gb:{name:W.COUNTRY.GB,g:"44",index:5},gd:{name:W.COUNTRY.GD,g:"1",index:195,h:!0},ge:{name:W.COUNTRY.GE,g:"995",index:66},gf:{name:W.COUNTRY.GF,
g:"594",index:19},gh:{name:W.COUNTRY.GH,g:"233",index:170},gi:{name:W.COUNTRY.GI,g:"350",index:20},gl:{name:W.COUNTRY.GL,g:"299",index:138},gm:{name:W.COUNTRY.GM,g:"220",index:48},gn:{name:W.COUNTRY.GN,g:"224",index:207},gp:{name:W.COUNTRY.GP,g:"590",index:30},gq:{name:W.COUNTRY.GQ,g:"240",index:116},gr:{name:W.COUNTRY.GR,g:"30",index:11},gt:{name:W.COUNTRY.GT,g:"502",index:71},gu:{name:W.COUNTRY.GU,g:"1",index:192,h:!0},gw:{name:W.COUNTRY.GW,g:"245",index:153},gy:{name:W.COUNTRY.GY,g:"592",index:61},
hk:{name:W.COUNTRY.HK,g:"852",index:218},hn:{name:W.COUNTRY.HN,g:"504",index:174},hr:{name:W.COUNTRY.HR,g:"385",index:69},ht:{name:W.COUNTRY.HT,g:"509",index:23},hu:{name:W.COUNTRY.HU,g:"36",index:53},id:{name:W.COUNTRY.ID,g:"62",index:156},ie:{name:W.COUNTRY.IE,g:"353",index:157},il:{name:W.COUNTRY.IL,g:"972",index:25},"in":{name:W.COUNTRY.IN,g:"91",index:132},io:{name:W.COUNTRY.IO,g:"246",index:5},iq:{name:W.COUNTRY.IQ,g:"964",index:50},ir:{name:W.COUNTRY.IR,g:"98",index:161},is:{name:W.COUNTRY.IS,
g:"354",index:159},it:{name:W.COUNTRY.IT,g:"39",index:9},jm:{name:W.COUNTRY.JM,g:"1",index:135,h:!0},jo:{name:W.COUNTRY.JO,g:"962",index:112},jp:{name:W.COUNTRY.JP,g:"81",index:31},ke:{name:W.COUNTRY.KE,g:"254",index:212},kg:{name:W.COUNTRY.KG,g:"996",index:126},kh:{name:W.COUNTRY.KH,g:"855",index:17},ki:{name:W.COUNTRY.KI,g:"686",index:28},km:{name:W.COUNTRY.KM,g:"269",index:110},kn:{name:W.COUNTRY.KN,g:"1",index:6,h:!0},kp:{name:W.COUNTRY.KP,g:"850",index:142},kr:{name:W.COUNTRY.KR,g:"82",index:181},
kw:{name:W.COUNTRY.KW,g:"965",index:202},ky:{name:W.COUNTRY.KY,g:"1",index:22,h:!0},kz:{name:W.COUNTRY.KZ,g:"7",index:92,h:!0},la:{name:W.COUNTRY.LA,g:"856",index:33},lb:{name:W.COUNTRY.LB,g:"961",index:95},lc:{name:W.COUNTRY.LC,g:"1",index:108,h:!0},li:{name:W.COUNTRY.LI,g:"423",index:75},lk:{name:W.COUNTRY.LK,g:"94",index:213},lr:{name:W.COUNTRY.LR,g:"231",index:166},ls:{name:W.COUNTRY.LS,g:"266",index:177},lt:{name:W.COUNTRY.LT,g:"370",index:85},lu:{name:W.COUNTRY.LU,g:"352",index:113},lv:{name:W.COUNTRY.LV,
g:"371",index:154},ly:{name:W.COUNTRY.LY,g:"218",index:8},ma:{name:W.COUNTRY.MA,g:"212",index:189},mc:{name:W.COUNTRY.MC,g:"377",index:70},md:{name:W.COUNTRY.MD,g:"373",index:217},me:{name:W.COUNTRY.ME,g:"382",index:175},mf:{name:W.COUNTRY.MF,g:"590",index:5,h:!0},mg:{name:W.COUNTRY.MG,g:"261",index:98},mh:{name:W.COUNTRY.MH,g:"692",index:86},mk:{name:W.COUNTRY.MK,g:"389",index:104},ml:{name:W.COUNTRY.ML,g:"223",index:204},mm:{name:W.COUNTRY.MM,g:"95",index:1},mn:{name:W.COUNTRY.MN,g:"976",index:206},
mo:{name:W.COUNTRY.MO,g:"853",index:209},mp:{name:W.COUNTRY.MP,g:"1",index:54,h:!0},mq:{name:W.COUNTRY.MQ,g:"596",index:14},mr:{name:W.COUNTRY.MR,g:"222",index:18},ms:{name:W.COUNTRY.MS,g:"1",index:44,h:!0},mt:{name:W.COUNTRY.MT,g:"356",index:120},mu:{name:W.COUNTRY.MU,g:"230",index:176},mv:{name:W.COUNTRY.MV,g:"960",index:47},mw:{name:W.COUNTRY.MW,g:"265",index:173},mx:{name:W.COUNTRY.MX,g:"52",index:162},my:{name:W.COUNTRY.MY,g:"60",index:148},mz:{name:W.COUNTRY.MZ,g:"258",index:49},na:{name:W.COUNTRY.NA,
g:"264",index:149},nc:{name:W.COUNTRY.NC,g:"687",index:97},ne:{name:W.COUNTRY.NE,g:"227",index:42},nf:{name:W.COUNTRY.NF,g:"672",index:15},ng:{name:W.COUNTRY.NG,g:"234",index:201},ni:{name:W.COUNTRY.NI,g:"505",index:10},nl:{name:W.COUNTRY.NL,g:"31",index:111},no:{name:W.COUNTRY.NO,g:"47",index:64},np:{name:W.COUNTRY.NP,g:"977",index:7},nr:{name:W.COUNTRY.NR,g:"674",index:137},nu:{name:W.COUNTRY.NU,g:"683",index:167},nz:{name:W.COUNTRY.NZ,g:"64",index:119},om:{name:W.COUNTRY.OM,g:"968",index:199},
pa:{name:W.COUNTRY.PA,g:"507",index:65},pe:{name:W.COUNTRY.PE,g:"51",index:72},pf:{name:W.COUNTRY.PF,g:"689",index:133},pg:{name:W.COUNTRY.PG,g:"675",index:114},ph:{name:W.COUNTRY.PH,g:"63",index:143},pk:{name:W.COUNTRY.PK,g:"92",index:163},pl:{name:W.COUNTRY.PL,g:"48",index:89},pm:{name:W.COUNTRY.PM,g:"508",index:81},pr:{name:W.COUNTRY.PR,g:"1",index:35,h:!0},ps:{name:W.COUNTRY.PS,g:"970",index:91},pt:{name:W.COUNTRY.PT,g:"351",index:39},pw:{name:W.COUNTRY.PW,g:"680",index:16},py:{name:W.COUNTRY.PY,
g:"595",index:190},qa:{name:W.COUNTRY.QA,g:"974",index:34},re:{name:W.COUNTRY.RE,g:"262",index:19},ro:{name:W.COUNTRY.RO,g:"40",index:52},rs:{name:W.COUNTRY.RS,g:"381",index:200},ru:{name:W.COUNTRY.RU,g:"7",index:51},rw:{name:W.COUNTRY.RW,g:"250",index:216},sa:{name:W.COUNTRY.SA,g:"966",index:3},sb:{name:W.COUNTRY.SB,g:"677",index:80},sc:{name:W.COUNTRY.SC,g:"248",index:78},sd:{name:W.COUNTRY.SD,g:"249",index:26},se:{name:W.COUNTRY.SE,g:"46",index:29},sg:{name:W.COUNTRY.SG,g:"65",index:2},sh:{name:W.COUNTRY.SH,
g:"290",index:37},si:{name:W.COUNTRY.SI,g:"386",index:93},sk:{name:W.COUNTRY.SK,g:"421",index:179},sl:{name:W.COUNTRY.SL,g:"232",index:57},sm:{name:W.COUNTRY.SM,g:"378",index:171},sn:{name:W.COUNTRY.SN,g:"221",index:172},so:{name:W.COUNTRY.SO,g:"252",index:105},sr:{name:W.COUNTRY.SR,g:"597",index:215},ss:{name:W.COUNTRY.SS,g:"211",index:222},st:{name:W.COUNTRY.ST,g:"239",index:194},sv:{name:W.COUNTRY.SV,g:"503",index:127},sx:{name:W.COUNTRY.SX,g:"1",index:225,h:!0},sy:{name:W.COUNTRY.SY,g:"963",index:144},
sz:{name:W.COUNTRY.SZ,g:"268",index:184},tc:{name:W.COUNTRY.TC,g:"1",index:100,h:!0},td:{name:W.COUNTRY.TD,g:"235",index:62},tg:{name:W.COUNTRY.TG,g:"228",index:46},th:{name:W.COUNTRY.TH,g:"66",index:73},tj:{name:W.COUNTRY.TJ,g:"992",index:13},tk:{name:W.COUNTRY.TK,g:"690",index:223},tl:{name:W.COUNTRY.TL,g:"670",index:226},tm:{name:W.COUNTRY.TM,g:"993",index:205},tn:{name:W.COUNTRY.TN,g:"216",index:41},to:{name:W.COUNTRY.TO,g:"676",index:82},tr:{name:W.COUNTRY.TR,g:"90",index:125},tt:{name:W.COUNTRY.TT,
g:"1",index:32,h:!0},tv:{name:W.COUNTRY.TV,g:"688",index:21},tw:{name:W.COUNTRY.TW,g:"886",index:38},tz:{name:W.COUNTRY.TZ,g:"255",index:185},ua:{name:W.COUNTRY.UA,g:"380",index:160},ug:{name:W.COUNTRY.UG,g:"256",index:88},us:{name:W.COUNTRY.US,g:"1",index:4},uy:{name:W.COUNTRY.UY,g:"598",index:210},uz:{name:W.COUNTRY.UZ,g:"998",index:76},va:{name:W.COUNTRY.VA,g:"39",index:188,h:!0},vc:{name:W.COUNTRY.VC,g:"1",index:211,h:!0},ve:{name:W.COUNTRY.VE,g:"58",index:79},vg:{name:W.COUNTRY.VG,g:"1",index:109,
h:!0},vi:{name:W.COUNTRY.VI,g:"1",index:140,h:!0},vn:{name:W.COUNTRY.VN,g:"84",index:74},vu:{name:W.COUNTRY.VU,g:"678",index:96},wf:{name:W.COUNTRY.WF,g:"681",index:19},ws:{name:W.COUNTRY.WS,g:"685",index:186},xk:{name:W.COUNTRY.XK,g:"383",index:227},ye:{name:W.COUNTRY.YE,g:"967",index:130},za:{name:W.COUNTRY.ZA,g:"27",index:191},zm:{name:W.COUNTRY.ZM,g:"260",index:124},zw:{name:W.COUNTRY.ZW,g:"263",index:164}};var X=function(){B.apply(this,arguments)};v(X,B);
X.prototype.j=function(){var b=this.i.querySelector("SELECT".toString()),c=document.createDocumentFragment(),d=Object.keys(Fa),e=(this.i.dataset.regionCode||"").toLowerCase();d=p(d);for(var g=d.next();!g.done;g=d.next()){var h=g.value;g=Fa[h];var f=g.g,l=g.name;g=h.toLowerCase()===e;var A=document.createElement("OPTION".toString());A.value=h;h=void 0;f="(+"+f+") "+l;h=void 0===h?{}:h;if(!(f instanceof M)){f=String(f).replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/"/g,"&quot;").replace(/'/g,
"&apos;");h.B&&(f=f.replace(/(^|[\r\n\t ]) /g,"${'$'}1&#160;"));h.A&&(f=f.replace(/(\r\n|\n|\r)/g,"<br>"));h.C&&(f=f.replace(/(\t+)/g,'<span style="white-space:pre">${'$'}1</span>'));if(void 0===J)if(h=null,(l=x.trustedTypes)&&l.createPolicy){try{h=l.createPolicy("goog#html",{createHTML:z,createScript:z,createScriptURL:z})}catch(Ia){x.console&&x.console.error(Ia.message)}J=h}else J=h;f=(h=J)?h.createHTML(f):f;f=new M(f)}A.textContent=f.toString();g&&(A.selected=!0);c.appendChild(A)}b.appendChild(c)};S("CaptchaInput",T);S("Card",E);S("CountrySelect",X);S("EmailInput",U);S("Footer",Q);S("IdentifierInput",V);for(var Ga=[],Ha=p([].slice.call(document.querySelectorAll("[data-auto-init]"))),Y=Ha.next();!Y.done;Y=Ha.next()){var Z=Y.value,Ja=Z.getAttribute("data-auto-init");if(!Ja)throw Error("auto-init attribute requires a value.");var Ka=new R[Ja](Z);Ga.push(Ka);Z.removeAttribute("data-auto-init")};}).call(this);
</script>
</div>
</div>
</body>
"""