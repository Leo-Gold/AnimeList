package com.project.constants.userRate;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum STATUS {
	planned,
	watching,
	rewatching,
	completed,
	@JsonProperty("on_hold")
	onHold,
	dropped;
}
