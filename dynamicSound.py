import rtmidi
import time
import random

# midi thread functions

# midi chords
def randomMajorChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+4,startValue+7])

def majorChordGenerator(startValue):
    return ([startValue,startValue+4,startValue+7])

def randomMinorChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+3,startValue+7])

def minorChordGenerator(startValue):
    return ([startValue,startValue+3,startValue+7])

def randomAugmentedChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+4,startValue+8])

def randomReducedChordGenerator():
    startValue = random.randint(50,60)
    return ([startValue,startValue+3,startValue+6])

def setOctave(note):
	octave = random.randint(0,2)
	if octave == 0:
		note = note - 12
	if octave == 2:
		note = note + 12
	return note

chordSecuence = [[69,65,60,67],[60,67,69,65],[65,69,60,67],[65,67,69,67],[65,67,69,60],[65,67,69,64],[69,64,65,67],[69,64,60,67],[60,62,69,65],[69,62,65,67]]

midiout = rtmidi.MidiOut()
available_ports = midiout.get_ports()
#print (available_ports)
#print (midiout.get_port_count())
midiout.open_port(1)

arpegio = True
tempo = 30

try:
	while True:
		#chordType = random.randint(0,3)
		#if chordType == 0: chord = randomMajorChordGenerator()
		#if chordType == 1: chord = randomMinorChordGenerator()
		#if chordType == 2: chord = randomAugmentedChordGenerator()
		#if chordType == 3: chord = randomReducedChordGenerator()
		csec = random.randint(0,9)
		for note in chordSecuence[csec]:
			chord = majorChordGenerator(note)
			firstnote = setOctave(chord[0])
			secondnote = setOctave(chord[1])
			thirdnote = setOctave(chord[2])
			midiout.send_message([0x90,firstnote,30])
			if arpegio == True:
				time.sleep(float(60/tempo))
				midiout.send_message([0x80,firstnote,0])
			midiout.send_message([0x90,secondnote,30])
			if arpegio == True:
				time.sleep(float(60/tempo))
				midiout.send_message([0x80,secondnote,0])
			midiout.send_message([0x90,thirdnote,30])
			if arpegio == True:
				time.sleep(float(60/tempo))
				midiout.send_message([0x80,thirdnote,0])
			if arpegio == False:
				time.sleep(float(random.randint(3000,5000)/1000))
			midiout.send_message([0x80,firstnote,0])
			midiout.send_message([0x80,secondnote,0])
			midiout.send_message([0x80,thirdnote,0])
			for iter in range(0,10):
				for i in range(50,70):
					midiout.send_message([0x80,i,0])
except KeyboardInterrupt:
	# nasty
	for iter in range(0,10):
		for i in range(50,70):
	    		midiout.send_message([0x80,i,0])
	del midiout
