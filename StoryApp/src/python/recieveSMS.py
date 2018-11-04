import json
from flask import Flask, request, jsonify
from pprint import pprint
import re
app = Flask(__name__)

@app.route('/webhooks/inbound-sms', methods=['GET', 'POST'])
def inbound_sms():
    if request.is_json:
        #request1 = json.loads(requests.get_json)

        print(request.get('text'))
        print(request.get('msisdn'))
        #+ ',' + request.get('msisdn'))

    else:
        data = dict(request.form) or dict(request.args)
        print( data.get("text"))
        print(data.get('msisdn'))
        #+ "," + data.get('msisdn'))
        
    
    return ('', 204)

app.run(port=3000,debug=True)
#app.run(port=4040)
