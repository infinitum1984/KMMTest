package me.daniil.common.data.network

import me.daniil.common.data.entity.FieldNet
import io.ktor.client.HttpClient
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import me.daniil.common.data.entity.BaseCatalogResponse

class FieldsApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
        install(Auth){
            bearer {
                loadTokens {
                    BearerTokens(TOKEN,TOKEN)
                }
            }
        }
    }

    suspend fun getAllLaunches(): BaseCatalogResponse<FieldNet> {
        return httpClient.get(LAUNCHES_ENDPOINT)
    }

    private companion object {
        const val LAUNCHES_ENDPOINT = "https://api.cfg.com.ua/machineDriver/test-base/fields"
        const val TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiJjMWM4NjYwNS1hMDY1LTQ0MGUtODQzZi04ZGMxNzJiNTMyMDciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vZTJmNjNlMjAtYzJjMS00YTE0LWFlNGYtMGU3MTU0ZmIzZjY4L3YyLjAiLCJpYXQiOjE2NjM3NDc4MzMsIm5iZiI6MTY2Mzc0NzgzMywiZXhwIjoxNjYzNzUxNzkyLCJhaW8iOiJBVFFBeS84VEFBQUFRUmlVeDJRcFh6TGRjR0pUTTVCMStNNVZrNVdTcy9YQ1ZIZ1NIbDJoazdLV0V4ZGt3QjFFdVRlZE5ZTlZQNXdLIiwiYXpwIjoiNWRlYTc4NGItYmE2OC00MTBiLWI4NjctYjJiZmJlZjU2ZGY1IiwiYXpwYWNyIjoiMSIsIm5hbWUiOiLQndC-0YHQuNC6INCU0LDQvdC40LvQviDQntC70LXQutGB0LDQvdC00YDQvtCy0LjRhyIsIm9pZCI6IjgzNmI2MGFjLTk2YWMtNGQxMC04MWI2LWFmNWJiY2RhZDU0MCIsInByZWZlcnJlZF91c2VybmFtZSI6ImRub3N5a0BjZmcuY29tLnVhIiwicmgiOiIwLkFRa0FJRDcyNHNIQ0ZFcXVUdzV4VlBzX2FBVm15TUZsb0E1RWhELU53WEsxTWdjSkFQVS4iLCJzY3AiOiJTZWN1cml0eS5BbGwiLCJzdWIiOiJUZ0R2RmdtQzJXZFB4MTh1YnNOdjcwR0VoQnpNYUFLWGtoWXJpSFZtU1Q4IiwidGlkIjoiZTJmNjNlMjAtYzJjMS00YTE0LWFlNGYtMGU3MTU0ZmIzZjY4IiwidXRpIjoibUdTUU41N3RFMEdOV2tSLV9hbGdBQSIsInZlciI6IjIuMCJ9.HOC3wd4DWJKIObJRt1StXTJOJ1m2kVRqofDp75R5S-FjHTcNaqGoWBolCiujlCMd6glJZDPEREhlF3ODt9VeSxvMWeULAJvYasCVEeO6_cD0se7wQS3pCX-2PkLGaqGY75t8WTWHzjaOBsdYvEp0E0tMNhC9ocdCdaaWVayL2k_lFoyQYc_EEEMplIWTtErRNMh8jX_zIrj_uy1yDidnn-7fKekiVxZgC0GUhqtW1CUq2PSbCeFrtFPTg2oDX9e53sfYGCD6UQEke_eSoSb4TJ-eVmumDFYCW7ATLsQPazRtUwVL6CEEVHB7L1Z8-Zbybs4WaYflcg944p4VvFpfog"
    }

}