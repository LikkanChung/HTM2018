import nexmo
client = nexmo.Client(key="2828c5e2", secret='B68UBlhZKhcauoL2')
response = client.send_message({'from': 'Python', 'to': '447756004657', 'text': 'Hello world'})

response = response['messages'][0]

if response['status'] == '0':
  print ('Sent message', response['message-id'])

  print ('Remaining balance is', response['remaining-balance'])
else:
  print ('Error:', response['error-text'])
