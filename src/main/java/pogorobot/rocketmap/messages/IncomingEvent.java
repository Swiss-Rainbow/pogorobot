/**
 Copyright 2019 Benjamin Marstaller
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
    http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

package pogorobot.rocketmap.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import pogorobot.events.EventMessage;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = RocketmapEventGym.class, name = "gym"),
		@JsonSubTypes.Type(value = RocketmapEventGymInfo.class, name = "gym_details"),
		@JsonSubTypes.Type(value = RocketmapEventEgg.class, name = "egg"),
		@JsonSubTypes.Type(value = RocketmapEventRaid.class, name = "raid"),
		@JsonSubTypes.Type(value = RocketmapEventPokemon.class, name = "pokemon"),
		@JsonSubTypes.Type(value = WebserviceEventQuest.class, name = "quest"),
		@JsonSubTypes.Type(value = WebserviceEventInvasion.class, name = "invasion"),
		@JsonSubTypes.Type(value = WebserviceEventWeather.class, name = "weather"),
		@JsonSubTypes.Type(value = RdmEventAccount.class, name = "account"),
		@JsonSubTypes.Type(value = RdmEventPokestop.class, name = "pokestop") })
public abstract class IncomingEvent<T extends EventMessage<?>> {

	private String type;

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public abstract T getMessage();

	public abstract void setMessage(T message);

}
