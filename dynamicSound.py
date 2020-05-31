import rtmidi
import time
import random

# midi thread functions

# midi chords
def majorChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+4,startValue+7])

def minorChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+3,startValue+7])

def augmentedChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+4,startValue+8])

def reducedChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+3,startValue+6])


midiout = rtmidi.MidiOut()
available_ports = midiout.get_ports()
#print (available_ports)
#print (midiout.get_port_count())
midiout.open_port(1)

try:
	while True:
		chordType = random.randint(0,3)
		if chordType == 0: chord = majorChordGenerator()
		if chordType == 1: chord = minorChordGenerator()
		if chordType == 2: chord = augmentedChordGenerator()
		if chordType == 3: chord = reducedChordGenerator()
		midiout.send_message([0x90,chord[0],30])
		midiout.send_message([0x90,chord[1],30])
		midiout.send_message([0x90,chord[2],30])
		time.sleep(float(random.randint(3000,5000)/1000))
		midiout.send_message([0x80,chord[0],0])
		midiout.send_message([0x80,chord[1],0])
		midiout.send_message([0x80,chord[2],0])
		for iter in range(0,10):
			for i in range(50,70):
			    midiout.send_message([0x80,i,0])
except KeyboardInterrupt:
	# nasty
	for iter in range(0,10):
		for i in range(50,70):
	    		midiout.send_message([0x80,i,0])
	del midiout
