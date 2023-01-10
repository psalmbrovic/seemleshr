import http from "k6/http";
import { check } from "k6";

import { randomSeed } from 'k6';


export let options = {
    vus: 1,
    duration: "2s",
}


export let data = {


        "PIN": "1122",
        "amount": 10,
        "bank_code_scheme": "NIP",
        "beneficiary_account_name": "ABATAN SAMUEL ADESHINA",
        "beneficiary_bank_code": "000013",
        "beneficiary_nuban": "0113446255",
        "currency_code": "NGN",
        "narration": "",
        "reference": "Load Test Account-2023-01-10T08:06:29+01:00",
        "save_beneficiary": true,
        "source_account": "8012682284"
        
        }

export let headers = {

    "api_secret": "vb_ls_75e97d06e821c0dcbb5e2421",
    "requestId": "{{$guid}}",
    "Content-Type": "application/json"
};

// export default function () {
//     randomSeed(123456789);
//     const rnd = Math.random();
//     console.log(rnd);
// }


export default function () {

    let response = http.post('https://api.woven.finance/v2/api/payouts/request?command=initiate', JSON.stringify(data), { headers: headers });
    console.log(response.body);
    check(response, {
        'is status 200': (r) => r.status === 200
    });
}